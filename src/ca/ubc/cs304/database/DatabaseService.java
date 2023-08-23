package ca.ubc.cs304.database;

import ca.ubc.cs304.entities.*;

//import javafx.concurrent.Worker;

import ca.ubc.cs304.entities.*;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.sql.Date;

import static ca.ubc.cs304.Util.buildTableModel.buildTableModel;

public class DatabaseService {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";

    private Connection connection = null;

    public DatabaseService() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
    }

    public boolean establishConnection(String username, String password) {
        try {
            connection = DriverManager.getConnection(ORACLE_URL, username, password);
            connection.setAutoCommit(false);
            System.out.println("\nConnected to Oracle!");
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
            return false;
        }
        return true;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + " " + e.getMessage());
        }
    }

    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println("EXCEPTION: " + " " + e.getMessage());
        }
    }


    public List<ItemEntity> getItemInfo() {
        ArrayList<ItemEntity> result = new ArrayList<ItemEntity>();

        try {
            String query = "SELECT * FROM ITEMS NATURAL JOIN ITEMSTATUS";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ItemEntity item = new ItemEntity(rs.getInt("ITEMID"),
                        rs.getString("STATUS"),
                        rs.getDate("RECEIVEDATE"),
                        rs.getString("SECTOR"),
                        rs.getInt("FRAGILE"),
                        rs.getInt("DELIVERYP_ID"),
                        rs.getInt("WAREHOUSEID"),
                        rs.getInt("CUSTOMERID")
                );
                item.setMissing(rs.getInt("MISSING"));
                result.add(item);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
        return result;
    }

    public List<FoodItemEntity> getSubFoodItemInfo() {
        ArrayList<FoodItemEntity> result = new ArrayList<FoodItemEntity>();

        try {
            String query = "SELECT * FROM FOODITEMS";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FoodItemEntity item = new FoodItemEntity(rs.getInt("ITEMID"),
                        rs.getDate("EXPIRATION"),
                        rs.getDate("MANUFACTUREDATE")
                );
                result.add(item);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
        return result;
    }

    public List<ClothingItemEntity> getSubClothingItemInfo() {
        ArrayList<ClothingItemEntity> result = new ArrayList<ClothingItemEntity>();

        try {
            String query = "SELECT * FROM CLOTHINGITEMS";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ClothingItemEntity item = new ClothingItemEntity(rs.getInt("ITEMID"),
                        rs.getInt("COSTS"),
                        rs.getString("MATERIAL")
                );
                result.add(item);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
        return result;
    }

    public List<ElectronicItemEntity> getSubElectronicItemInfo() {
        ArrayList<ElectronicItemEntity> result = new ArrayList<ElectronicItemEntity>();

        try {
            String query = "SELECT * FROM ELECTRONICITEMS";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ElectronicItemEntity item = new ElectronicItemEntity(rs.getInt("ITEMID"),
                        rs.getInt("WARRANTY"),
                        rs.getString("REPAIRS")
                );
                result.add(item);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
        return result;
    }

    public void insertItem(ItemEntity item) throws SQLException{
        String query = "INSERT INTO ITEMS VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, item.getItemID());
        ps.setString(2, item.getSector());
        ps.setString(3, item.getStatus());
        ps.setDate(4, item.getRecieveDate());
        ps.setInt(5, item.getFragile());
        ps.setInt(6, item.getDeliveryP_ID());
        ps.setInt(7, item.getWarehouseID());
        ps.setInt(8, item.getCustomerID());

        ps.executeUpdate();
        connection.commit();

        ps.close();
    }

    public void insertFoodItem(FoodItemEntity foodItem) throws SQLException{
        String query = "INSERT INTO FOODITEMS VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,foodItem.getItemID());
        ps.setDate(2,foodItem.getExpiration());
        ps.setDate(3,foodItem.getManufactureDate());

        ps.executeUpdate();
        connection.commit();

        ps.close();
    }

    public void insertClothingItem(ClothingItemEntity clothingItem) throws SQLException{
        String query = "INSERT INTO CLOTHINGITEMS VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, clothingItem.getItemID());
        ps.setInt(2, clothingItem.getCosts());
        ps.setString(3, clothingItem.getMaterial());

        ps.executeUpdate();
        connection.commit();

        ps.close();
    }

    public void insertElectronicItem(ElectronicItemEntity electronicItem) throws SQLException{
        String query = "INSERT INTO ELECTRONICITEMS VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, electronicItem.getItemID());
        ps.setInt(2, electronicItem.getWarranty());
        ps.setString(3, electronicItem.getRepairs());

        ps.executeUpdate();
        connection.commit();

        ps.close();
    }

    public void deleteItem(Integer itemID) {
        System.out.println(itemID);
        try {
            System.out.println("entered try");
            String query = "DELETE FROM ITEMS WHERE ITEMID = ?";
            System.out.println(query);
            PreparedStatement ps = connection.prepareStatement(query);
            System.out.println("made it past connection phase");
            ps.setInt(1, itemID);

            int rowCount = ps.executeUpdate();
            System.out.println("executed query");
            if (rowCount == 0) {
                System.out.println("WARNING: " + " Branch " + itemID + " does not exist!");
            }

            connection.commit();
            System.out.println("commited query");

            ps.close();
        } catch (SQLException e) {
            System.out.println("EXCEPTION: " + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void updateItem(ItemEntity item){
        try {
            String query = "UPDATE ITEMS SET SECTOR = ?, STATUS = ?, RECEIVEDATE = ?, FRAGILE = ?, DELIVERYP_ID = ?, " +
                    "WAREHOUSEID = ?, CUSTOMERID = ? WHERE ITEMID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, item.getSector());
            ps.setString(2, item.getStatus());
            ps.setDate(3, item.getRecieveDate());
            ps.setInt(4, item.getFragile());
            ps.setInt(5, item.getDeliveryP_ID());
            ps.setInt(6, item.getWarehouseID());
            ps.setInt(7, item.getCustomerID());
            ps.setInt(8, item.getItemID());

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println("WARNING: " + " Branch " + item.getItemID() + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println("EXCEPTION: " + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public List<WorkerEntity> projectWorkers(Boolean col1, Boolean col2, Boolean col3) {
        ArrayList<WorkerEntity> result = new ArrayList<WorkerEntity>();

        try {
            StringBuilder queryBuilder = new StringBuilder("SELECT ");

            if (col1) {
                queryBuilder.append("WORKERID, ");
            }

            if (col2) {
                queryBuilder.append("CLOTHINGSIZE, ");
            }

            if (col3) {
                queryBuilder.append("NAME, ");
            }

            if (queryBuilder.charAt(queryBuilder.length() - 1) == ' ') {
                queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
            }
            String query = queryBuilder + " FROM WORKERS";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                WorkerEntity worker = new WorkerEntity(
                        col1 ? rs.getInt("WORKERID"): -1,
                        col2 ? rs.getString("CLOTHINGSIZE"): "",
                        col3 ? rs.getString("NAME"): ""
                );
                result.add(worker);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
//        for (WorkerEntity worker : result) {
//            System.out.println((worker.getWorkerID() == -1 ? "" : worker.getWorkerID()) + " " + worker.getClothingSize() + " " + worker.getName());
//        }
        return result;
    };
    public DefaultTableModel selection(List<String> attributes, String table, String field1, String var1, String type1, String field2, String var2, String type2){
        try {
            StringBuilder query = new StringBuilder();
            query.append("Select ");
            for(int i = 0; i < attributes.size() - 1; i++){
                query.append(attributes.get(i));
                query.append(", ");
            }
            query.append(attributes.get(attributes.size() - 1));
            String select = selectionQuery(query.toString(), table, field1, field2);

            PreparedStatement ps = connection.prepareStatement(select);
            if(type1 != null){
                switch (type1){
                    case "string":
                        ps.setString(1, var1);
                        break;
                    case "number":
                        ps.setInt(1, Integer.parseInt(var1));
                        break;
                    case "date":
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date fromDate = (Date) dateFormat.parse(var1);
                        java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
                        ps.setDate(1, sqlFromDate);
                        break;
                }
                if(type2 != null){
                    switch (type2){
                        case "string":
                            ps.setString(2, var2);
                            break;
                        case "number":
                            ps.setInt(2, Integer.parseInt(var2));
                            break;
                        case "date":
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date fromDate = (Date) dateFormat.parse(var2);
                            java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
                            ps.setDate(2, sqlFromDate);
                            break;
                    }
                }
            }else if(type2 != null){
                switch (type2){
                    case "string":
                        ps.setString(1, var2);
                        break;
                    case "number":
                        ps.setInt(1, Integer.parseInt(var2));
                        break;
                    case "date":
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date fromDate = (Date) dateFormat.parse(var2);
                        java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
                        ps.setDate(1, sqlFromDate);
                        break;
                }
            }
            ResultSet rs = ps.executeQuery();
            DefaultTableModel defaultTableModel = buildTableModel(rs);
            connection.commit();
            rs.close();
            ps.close();
            return defaultTableModel;
        } catch (SQLException | ParseException ex) {
            System.out.println("EXCEPTION: " + " " + ex.getMessage());
            rollbackConnection();
        }
        return null;
    }


    private String selectionQuery(String query, String table, String field1, String field2){
        switch (table){
            case "Warehouse":
            case "Items":
            case "Customer":
            case "Employs":
            case "Deliver":
            case "DeliveryPeople":
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(query);
                stringBuilder.append(" from " + table);
                if((field1 != null) || (field2 != null)){
                    stringBuilder.append(" where");
                }
                if(field1 != null){
                    stringBuilder.append(" "+field1+" = ?");
                    if(field2 != null){
                        stringBuilder.append(" and");
                    }
                }
                if(field2 != null){
                    stringBuilder.append(" "+field2+" > ?");
                }
                return stringBuilder.toString();
        }
    }

    public DefaultTableModel joinQuery(String queryAttribute, String queryVar, String queryType) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from deliver d, items i where i.deliveryP_id = d.deliverypeople_id");
        PreparedStatement ps;
        if(!queryVar.equals("")) {
            stringBuilder.append(" and " + queryAttribute);
            stringBuilder.append(" =");
            stringBuilder.append(" ?");
            ps = connection.prepareStatement(stringBuilder.toString());
            switch (queryType) {
                case "string":
                    ps.setString(1, queryVar);
                    break;
                case "number":
                    ps.setInt(1, Integer.parseInt(queryVar));
                    break;
                case "date":
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fromDate = (Date) dateFormat.parse(queryVar);
                    java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
                    ps.setDate(1, sqlFromDate);
                    break;
            }
        }else{
            ps = connection.prepareStatement(stringBuilder.toString());
        }
        ResultSet rs = ps.executeQuery();
        DefaultTableModel defaultTableModel = buildTableModel(rs);
        connection.commit();
        rs.close();
        ps.close();
        return defaultTableModel;
    }

    public DefaultTableModel itemCountCategory () {
        ArrayList<ItemCountEntity> result = new ArrayList<ItemCountEntity>();
        try {
            StringBuilder query = new StringBuilder();
            query.append("Select Sector, count(*) From ITEMS Group By Sector");
            query.toString();
            PreparedStatement ps = connection.prepareStatement(String.valueOf(query));
            ResultSet rs = ps.executeQuery();

            DefaultTableModel defaultTableModel = buildTableModel(rs);
            rs.close();
            ps.close();
            return defaultTableModel;

        } catch (SQLException ex) {
            System.out.println("EXCEPTION: " + " " + ex.getMessage());
            rollbackConnection();
        }

                return null;

    }

    public DefaultTableModel customerNationaities () {
        ArrayList<CustomerCountryEntity> result = new ArrayList<CustomerCountryEntity>();
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT country, count(*)\n" +
                    "FROM CUSTOMERLOCATION\n" +
                    "GROUP BY Country\n" +
                    "HAVING COUNT(*) > 1\n");
            query.toString();
            PreparedStatement ps = connection.prepareStatement(String.valueOf(query));
            ResultSet rs = ps.executeQuery();

            DefaultTableModel defaultTableModel = buildTableModel(rs);
            rs.close();
            ps.close();
            return defaultTableModel;

        } catch (SQLException ex) {
            System.out.println("EXCEPTION: " + " " + ex.getMessage());
            rollbackConnection();
        }

return null;
    }

    public DefaultTableModel topDeliveryPersonOfTheDay(String day, String month, String year) {

        ArrayList<DeliveryPeopleEntity> result = new ArrayList<DeliveryPeopleEntity>();

        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT DeliveryPeople_ID, name\n" +
                    "FROM DeliveryPeople\n" +
                    "WHERE DeliveryPeople_ID in (SELECT DeliveryPeople_ID\n" +
                    "FROM (SELECT DeliveryPeople_ID, count(DeliveryPeople_ID) counter\n" +
                    "      \t\t\t\tFROM Deliver\n" +
                    "      \t\t\t\tWHERE ETA = TO_DATE('" + year +"-" + month +"-" + day +"', 'YYYY-MM-DD')\n" +
                    "      \t\t\t\tGROUP BY DeliveryPeople_ID)\n" +
                    "WHERE counter = (\tSELECT Max(counter) \n" +
                    "FROM  (\tSELECT DeliveryPeople_ID, count(DeliveryPeople_ID) counter\n" +
                    "                                            \t\t\t\t\tFROM Deliver\n" +
                    "                                            \t\t\t\t\tWHERE ETA = TO_DATE('" + year +"-" + month +"-" + day +"', 'YYYY-MM-DD')\n" +
                    "                                            \t\t\t\t\tGROUP BY DeliveryPeople_ID)))");
            query.toString();
            PreparedStatement ps = connection.prepareStatement(String.valueOf(query));

            ResultSet rs = ps.executeQuery();

            /*ResultSetMetaData rsMetaData = rs.getMetaData();
            //System.out.println("List of column names in the current table: ");
            //Retrieving the list of column names
            int count = rsMetaData.getColumnCount();
            for(int i = 1; i<=count; i++) {
                System.out.print(rsMetaData.getColumnName(i) + "       ");
            }
            System.out.println();*/
            int counting = 0;
            while (rs.next()) {
                counting++;
                DeliveryPeopleEntity DeliveryPerson = new DeliveryPeopleEntity(
                        rs.getInt("DELIVERYPEOPLE_ID"),
                        rs.getString("NAME")
                );
                result.add(DeliveryPerson);
            }

            if(counting == 0) {
                return null;
                //System.out.println("No delivery person delivered anything at this date");
            }
            ResultSet rs2 = ps.executeQuery();

            DefaultTableModel defaultTableModel = buildTableModel(rs2);
            rs.close();
            rs2.close();
            ps.close();
            return defaultTableModel;

        } catch (SQLException ex) {
            System.out.println("EXCEPTION: " + " " + ex.getMessage());
            rollbackConnection();
        }

        for (DeliveryPeopleEntity DeliveryPerson : result) {
            System.out.println(DeliveryPerson.getDeliveryPeople_ID() + " " + DeliveryPerson.getName());
        }
        return null;

    }

    public DefaultTableModel AllWareHousesDeliveryPeople() {


        ArrayList<DeliveryPeopleEntity> result = new ArrayList<DeliveryPeopleEntity>();


        try {
            StringBuilder query = new StringBuilder();
            query.append("\n" +
                    "SELECT D.DeliveryPeople_ID, D.Name\n" +
                    "FROM DeliveryPeople D\n" +
                    "WHERE NOT EXISTS (\n" +
                    "    SELECT W.WarehouseID\n" +
                    "    FROM Warehouse W\n" +
                    "    WHERE NOT EXISTS (\n" +
                    "        SELECT DE.Warehouse_ID\n" +
                    "        FROM Deliver DE\n" +
                    "        WHERE DE.Warehouse_ID = W.WarehouseID AND DE.DeliveryPeople_ID = D.DeliveryPeople_ID))\n");
            query.toString();
            PreparedStatement ps = connection.prepareStatement(String.valueOf(query));
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsMetaData = rs.getMetaData();


            int counting = 0;
            while (rs.next()) {
                counting++;
                DeliveryPeopleEntity DeliveryPerson = new DeliveryPeopleEntity(
                        rs.getInt("DELIVERYPEOPLE_ID"),
                        rs.getString("NAME")
                );
                result.add(DeliveryPerson);
            }

            if(counting == 0) {
                return null;
            }

            ResultSet rs2 = ps.executeQuery();
            DefaultTableModel defaultTableModel = buildTableModel(rs2);
            rs.close();
            rs2.close();
            ps.close();
            return defaultTableModel;

        } catch (SQLException ex) {
            System.out.println("EXCEPTION: " + " " + ex.getMessage());
            rollbackConnection();
        }

        for (DeliveryPeopleEntity DeliveryPerson : result) {
            System.out.println(DeliveryPerson.getDeliveryPeople_ID() + " " + DeliveryPerson.getName());
        }
        return null;

    }

}