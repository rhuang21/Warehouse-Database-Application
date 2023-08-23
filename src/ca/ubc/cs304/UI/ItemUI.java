package ca.ubc.cs304.UI;

import ca.ubc.cs304.delegates.ItemDelegate;
import ca.ubc.cs304.entities.ClothingItemEntity;
import ca.ubc.cs304.entities.ElectronicItemEntity;
import ca.ubc.cs304.entities.FoodItemEntity;
import ca.ubc.cs304.entities.ItemEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

public class ItemUI extends InterfaceUI {
    private JTextField itemId, sector, status, receiveDate, fragile, deliveryP_Id, warehouseId, customerId, attributeOne,
    attributeTwo, itemIDToDelete, updateItemID, updateSector, updateStatus, updateReceiveDate, updateFragile, updateDeliveryP_ID,
    updateWarehouseID, updateCustomerID;
    private JButton showItem, addItem, deleteItem, updateItem, showFoodItem, showClothingItem, showElectronicItem, joinDeliverItem;
    private InterfaceUI interfaceUI = this;
    private JButton mainMenu;
    private JComboBox<String> queryAttribute;
    private JTextField queryVar;

    public ItemUI(ItemDelegate delegate){
        setTitle("Item Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        int verticalSpacing = 4;

        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        showItem = new JButton("Show Items");
        inputPanel.add(showItem);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        showFoodItem = new JButton("Show Food Items");
        inputPanel.add(showFoodItem);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        showClothingItem = new JButton("Show Clothing Items");
        inputPanel.add(showClothingItem);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        showElectronicItem = new JButton("Show Electronic Items");
        inputPanel.add(showElectronicItem);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        itemId = new JTextField("ItemId",20);
        sector = new JTextField("Sector",20);
        status = new JTextField("Status",20);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        receiveDate = new JFormattedTextField(dateFormat);
        receiveDate.setColumns(20);
        receiveDate.setText("Receive Date");
        fragile = new JTextField("Fragile",20);
        deliveryP_Id = new JTextField("Delivery Person",20);
        warehouseId = new JTextField("Warehouse Id",20);
        customerId = new JTextField("Customer Id",20);
        attributeOne = new JTextField("Corresponding Attributes 1",20);
        attributeTwo = new JTextField("Corresponding Attributes 2",20);
        itemIDToDelete = new JTextField("Enter ItemID to Delete", 20);
        updateItemID = new JTextField("Enter ItemID to Update", 20);
        updateSector = new JTextField("Enter Sector to Update", 20);
        updateStatus = new JTextField("Enter Status to Update", 20);
        updateReceiveDate = new JTextField("Enter Receive Date to Update", 20);
        updateFragile = new JTextField("Enter Fragile to Update", 20);
        updateDeliveryP_ID = new JTextField("Enter Delivery Person to Update", 20);
        updateWarehouseID = new JTextField("Enter Warehouse ID to Update", 20);
        updateCustomerID = new JTextField("Enter Customer ID to Update", 20);
        inputPanel.add(itemId);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(sector);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(status);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(receiveDate);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(fragile);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(deliveryP_Id);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(warehouseId);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(customerId);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(attributeOne);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(attributeTwo);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        addItem = new JButton("Add New Item");
        inputPanel.add(addItem);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        inputPanel.add(itemIDToDelete);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        deleteItem = new JButton("Delete an Item");
        inputPanel.add(deleteItem);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        inputPanel.add(updateItemID);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(updateSector);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(updateStatus);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(updateReceiveDate);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(updateFragile);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(updateDeliveryP_ID);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(updateWarehouseID);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));
        inputPanel.add(updateCustomerID);
        inputPanel.add(Box.createVerticalStrut(verticalSpacing));

        updateItem = new JButton("Update an Item");
        inputPanel.add(updateItem);

        queryAttribute = new JComboBox<>(new String[]{"sector", "worker_id", "eta", "postalcode", "status", "customerid"});
        queryVar = new JTextField();
        joinDeliverItem = new JButton("Join Query");
        inputPanel.add(queryAttribute);
        inputPanel.add(queryVar);
        inputPanel.add(joinDeliverItem);

        mainMenu = new JButton("Main Menu");
        inputPanel.add(mainMenu);
        this.setSize(1000,1000);

        joinDeliverItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String attribute = (String)queryAttribute.getSelectedItem();
                String type = null;
                switch(attribute){
                    case "sector":
                        type = "string";
                        break;
                    case "worker_id":
                        type = "number";
                        break;
                    case "eta":
                        type = "date";
                        break;
                    case "postalcode":
                        type = "string";
                        break;
                    case "status":
                        type = "string";
                        break;
                    case "customerid":
                        type = "number";
                        break;
                }
                try {
                    DefaultTableModel defaultTableModel = delegate.joinQuery(attribute, queryVar.getText(), type);
                    JTable table = new JTable(defaultTableModel);

                    JScrollPane scrollPane = new JScrollPane(table);

                    JFrame frame = new JFrame("Items and Deliver");
                    frame.add(scrollPane);
                    frame.setSize(1000,700);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(inputPanel, ex.getMessage());
                }
            }
        });
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.returnToMainMenu(interfaceUI);
            }
        });

        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ItemEntity newItem = new ItemEntity(Integer.parseInt(itemId.getText()), status.getText(), Date.valueOf(receiveDate.getText()),
                            sector.getText(), Integer.parseInt(fragile.getText()), Integer.parseInt(deliveryP_Id.getText()), Integer.parseInt(warehouseId.getText()), Integer.parseInt(customerId.getText()));
                    delegate.insertItem(newItem);
                    String itemType = newItem.getSector();
                    if (itemType.equalsIgnoreCase(("Food"))) {
                        FoodItemEntity newFood = new FoodItemEntity(Integer.parseInt(itemId.getText()),
                                Date.valueOf(attributeOne.getText()), Date.valueOf(attributeTwo.getText()));
                        delegate.insertFoodItem(newFood);
                    } else if (itemType.equalsIgnoreCase(("Clothing"))) {
                        ClothingItemEntity newClothing = new ClothingItemEntity(Integer.parseInt(itemId.getText()),
                                Integer.parseInt(attributeOne.getText()), attributeTwo.getText());
                        delegate.insertClothingItem(newClothing);
                    } else if (itemType.equalsIgnoreCase(("Electronic"))) {
                        ElectronicItemEntity newElectronic = new ElectronicItemEntity(Integer.parseInt(itemId.getText()),
                                Integer.parseInt(attributeOne.getText()), attributeTwo.getText());
                        delegate.insertElectronicItem(newElectronic);
                    } else {
                        JOptionPane.showMessageDialog(inputPanel, "Invalid Item Sector");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(inputPanel, ex.getMessage());
                }
            }
        });

        showItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ItemEntity> listOfItems = delegate.showAllItem();
                String[] column = {"ItemID", "Sector", "Status", "ReceiveDate", "Fragile", "DeliveryP_ID", "WarehouseID", "CustomerID", "Missing"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(column, 0);
                JTable itemTable = new JTable(defaultTableModel);
                JScrollPane scrollPane = new JScrollPane(itemTable);

                JFrame frame = new JFrame("Item Table");
                frame.add(scrollPane);

                for(ItemEntity item : listOfItems){
                    Object[] itemData = {item.getItemID(), item.getSector(), item.getStatus(), item.getRecieveDate(), item.getFragile(), item.getDeliveryP_ID(), item.getWarehouseID(), item.getCustomerID(), item.getMissing()};
                    defaultTableModel.addRow(itemData);
                }

                frame.setSize(1200,500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        showFoodItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<FoodItemEntity> listOfFoods = delegate.showAllFood();
                String[] column = {"ItemID", "Expiration", "Manufacture Date"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(column, 0);
                JTable itemTable = new JTable(defaultTableModel);
                JScrollPane scrollPane = new JScrollPane(itemTable);

                JFrame frame = new JFrame("Food Item Table");
                frame.add(scrollPane);

                for(FoodItemEntity item : listOfFoods){
                    Object[] itemData = {item.getItemID(), item.getExpiration(), item.getManufactureDate()};
                    defaultTableModel.addRow(itemData);
                }

                frame.setSize(1200,500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        showClothingItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ClothingItemEntity> listOfClothes = delegate.showAllClothing();
                String[] column = {"ItemID", "Costs", "Material"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(column, 0);
                JTable itemTable = new JTable(defaultTableModel);
                JScrollPane scrollPane = new JScrollPane(itemTable);

                JFrame frame = new JFrame("Clothing Item Table");
                frame.add(scrollPane);

                for(ClothingItemEntity item : listOfClothes){
                    Object[] itemData = {item.getItemID(), item.getCosts(), item.getMaterial()};
                    defaultTableModel.addRow(itemData);
                }

                frame.setSize(1200,500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        showElectronicItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ElectronicItemEntity> listOfElectronics = delegate.showAllElectronic();
                String[] column = {"ItemID", "Warranty", "Repairs"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(column, 0);
                JTable itemTable = new JTable(defaultTableModel);
                JScrollPane scrollPane = new JScrollPane(itemTable);

                JFrame frame = new JFrame("Electronics Item Table");
                frame.add(scrollPane);

                for(ElectronicItemEntity item : listOfElectronics){
                    Object[] itemData = {item.getItemID(), item.getWarranty(), item.getRepairs()};
                    defaultTableModel.addRow(itemData);
                }

                frame.setSize(1200,500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer toDeleteID = Integer.parseInt(itemIDToDelete.getText());
                    System.out.println(toDeleteID);
                    delegate.deleteItem(toDeleteID);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(inputPanel, ex.getMessage());
                }
            }
        });

        updateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ItemEntity updateItem = new ItemEntity(Integer.parseInt(updateItemID.getText()), updateStatus.getText(), Date.valueOf(updateReceiveDate.getText()),
                            updateSector.getText(), Integer.parseInt(updateFragile.getText()), Integer.parseInt(updateDeliveryP_ID.getText()), Integer.parseInt(updateWarehouseID.getText()), Integer.parseInt(updateCustomerID.getText()));
                    delegate.updateItem(updateItem);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(inputPanel, ex.getMessage());
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
