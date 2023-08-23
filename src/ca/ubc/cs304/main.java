package ca.ubc.cs304;

import ca.ubc.cs304.UI.SelectionUI;
import ca.ubc.cs304.controller.Warehouse;
import ca.ubc.cs304.database.DatabaseService;
import ca.ubc.cs304.entities.ItemEntity;

import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {
         Warehouse warehouse = new Warehouse();
//        DatabaseService d = new DatabaseService();
//        d.establishConnection(args[0], args[1]);
//        d.deleteItem(19);
//        Date newDate = new Date(2022-3-21);
//        ItemEntity updateItem = new ItemEntity(2, "Unknown", newDate, "Electronic", 3,3,3,3);
//        d.updateItem(updateItem);
//        ItemEntity newItem = new ItemEntity(19, "Unknown", newDate, "Electronic", 3,3,3,3);
//        d.insertItem(newItem);
    }
}
