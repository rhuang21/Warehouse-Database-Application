package ca.ubc.cs304.entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemEntity implements Entity{

    private final int ItemID;
    private final String Status;
    private final Date ReceiveDate;
    private final String Sector;
    private final int Fragile;
    private final int DeliveryP_ID;
    private final int WarehouseID;
    private final int CustomerID;
    private int Missing;

    public ItemEntity(int itemID, String status, Date receiveDate,
                      String sector, int fragile, int deliveryP_ID, int warehouseID, int customerID) {
        this.ItemID = itemID;
        this.Status = status;
        this.ReceiveDate = receiveDate;
        this.Sector = sector;
        this.Fragile = fragile;
        this.DeliveryP_ID = deliveryP_ID;
        this.WarehouseID = warehouseID;
        this.CustomerID = customerID;
    }

    public int getItemID() {
        return ItemID;
    }

    public String getStatus() {
        return Status;
    }

    public Date getRecieveDate() {
        return ReceiveDate;
    }

    public String getSector() {
        return Sector;
    }

    public int getFragile() {
        return Fragile;
    }

    public int getDeliveryP_ID() {
        return DeliveryP_ID;
    }

    public int getWarehouseID() {
        return WarehouseID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public int getMissing() {
        return Missing;
    }

    public void setMissing(int missing){
        this.Missing = missing;
    }

    public static List<ItemEntity> mapFromResultSet(ResultSet rs) {
        ArrayList<ItemEntity> result = new ArrayList<ItemEntity>();
        try {
            while (rs.next()) {
                ItemEntity item = new ItemEntity(rs.getInt("ItemID"),
                        rs.getString("Status"),
                        rs.getDate("RecieveDate"),
                        rs.getString("Sector"),
                        rs.getInt("Fragile"),
                        rs.getInt("DeliveryP_ID"),
                        rs.getInt("WarehouseID"),
                        rs.getInt("CustomerID")
                );
                result.add(item);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "ItemID=" + ItemID +
                ", Status='" + Status + '\'' +
                ", ReceiveDate=" + ReceiveDate +
                ", Sector='" + Sector + '\'' +
                ", Fragile=" + Fragile +
                ", DeliveryP_ID=" + DeliveryP_ID +
                ", WarehouseID=" + WarehouseID +
                ", CustomerID=" + CustomerID +
                ", Missing=" + Missing +
                '}';
    }
}