package ca.ubc.cs304.UI;

import ca.ubc.cs304.delegates.SelectionDelegate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SelectionUI extends InterfaceUI {
    private JComboBox<String> tableDropDown;
    private JTextField attributesTextField;
    private JComboBox<String> field1;
    private JTextField var1;
    private JComboBox<String> field2;
    private JTextField var2;
    private JButton queryButton;
    private InterfaceUI interfaceUI = this;
    private JButton mainMenu;
    private String[] tableNames= {"Employs", "Warehouse", "Items", "DeliveryCompany", "Vehicles", "DeliveryPeople", "Deliver", "Customer"};
    private String[] employAttributes = {"workerId", "sector_name", "warehouseId", "salary", "none"};
    private String[] itemsAttributes = {"itemId", "sector", "receiveDate", "deliveryP_Id", "status", "none"};
    private String[] customerAttributes = {"id", "email", "country", "none"};
    private String[] deliverAttributes = {"worker_Id", "eta", "postalcode", "warehouse_Id", "deliverypeople_id", "none"};
    private String[] deliveryPeopleAttributes = {"DeliveryPeopleId", "Name", "DeliveryCompany_ID", "none"};
    private String[] warehouseAttributes = {"WarehouseId", "Name", "Capacity", "Country", "none"};

    private Map<String, String> attributeType = new HashMap<String, String>() {{
        put("none", null);

        put("workerId", "number");
        put("sector_name", "string");
        put("warehouseId", "number");
        put("salary", "number");

        put("itemId", "number");
        put("sector", "string");
        put("status", "string");
        put("receiveDate", "date");
        put("deliveryP_Id", "number");

        put("id", "number");
        put("email", "string");
        put("country", "string");

        put("worker_Id", "string");
        put("eta", "string");
        put("postalcode", "date");
        put("warehouse_Id", "number");
        put("deliverypeople_id", "string");

        put("DeliveryPeopleId", "number");
        put("Name", "string");
        put("DeliveryCompany_ID", "string");

        put("WarehouseId", "number");
        put("Capacity", "string");
        put("Country", "date");

    }};
    public SelectionUI(SelectionDelegate delegate){
        setTitle("Table Query");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();

        JLabel table = new JLabel("Table");

        tableDropDown = new JComboBox<>(tableNames);
        JLabel attributes = new JLabel("Attributes");
        attributesTextField = new JTextField(20);
        inputPanel.add(table);
        inputPanel.add(tableDropDown);
        inputPanel.add(attributes);
        inputPanel.add(attributesTextField);
        field1 = new JComboBox<>();
        field2 = new JComboBox<>();

        JLabel variable1 = new JLabel("variable1");
        var1 = new JTextField("",20);
        JLabel variable2 = new JLabel("variable2");
        var2 = new JTextField(20);
        JLabel fieldText1 = new JLabel("Field =");
        inputPanel.add(fieldText1);
        inputPanel.add(field1);
        inputPanel.add(variable1);
        inputPanel.add(var1);
        JLabel fieldText2 = new JLabel("Field >");
        inputPanel.add(fieldText2);
        inputPanel.add(field2);
        inputPanel.add(variable2);
        inputPanel.add(var2);

        queryButton = new JButton("Query");
        inputPanel.add(queryButton);

        mainMenu = new JButton("Main Menu");
        inputPanel.add(mainMenu);

        add(inputPanel, BorderLayout.CENTER);
        this.setSize(1500,110);

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel defaultTableModel = selectionQuery(delegate);
                if(defaultTableModel != null){
                    selectionPopulate(defaultTableModel, "Items");
                }
            }
        });

        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.returnToMainMenu(interfaceUI);
            }
        });

        tableDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) tableDropDown.getSelectedItem()){
                    case "Employs":
                        addItemsToDropDown(employAttributes);
                        break;
                    case "Warehouse":
                        addItemsToDropDown(warehouseAttributes);
                        break;
                    case "Items":
                        addItemsToDropDown(itemsAttributes);
                        break;
                    case "Customer":
                        addItemsToDropDown(customerAttributes);
                        break;
                    case "Deliver":
                        addItemsToDropDown(deliverAttributes);
                        break;
                    case "DeliveryPeople":
                        addItemsToDropDown(deliveryPeopleAttributes);
                        break;
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addItemsToDropDown(String[] list){
        field1.removeAllItems();
        field2.removeAllItems();
        for(String field : list){
            field1.addItem(field);
            field2.addItem(field);
        }
    }

    private DefaultTableModel selectionQuery(SelectionDelegate delegate){
        String tableName = (String) tableDropDown.getSelectedItem();
        if(tableName.equals("")){
            JOptionPane.showMessageDialog(this, "Table Cannot be Empty");
            return null;
        }
        ArrayList<String> stringList = null;
        if(!attributesTextField.getText().equals("")){
            String[] stringArray = attributesTextField.getText().split("\\s*,\\s*");
            stringList = new ArrayList<>(Arrays.asList(stringArray));
        }else{
            stringList = new ArrayList<>();
            stringList.add("*");
        }
        String fieldName1 = (String) field1.getSelectedItem();
        String fieldName2 = (String) field2.getSelectedItem();
        String type1 = attributeType.get(fieldName1);
        String type2 = attributeType.get(fieldName2);
        if(fieldName1 == "none"){
            fieldName1 = null;
        }
        if(fieldName2 == "none"){
            fieldName2 = null;
        }
        return delegate.doSelection(stringList, tableName, fieldName1, var1.getText(), type1, fieldName2, var2.getText(), type2);
    }

    private void selectionPopulate(DefaultTableModel defaultTableModel, String tableName){
        JTable table = new JTable(defaultTableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame(tableName);
        frame.add(scrollPane);
        frame.setSize(1000,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

