package ca.ubc.cs304.controller;

import ca.ubc.cs304.UI.*;
import ca.ubc.cs304.database.DatabaseService;
import ca.ubc.cs304.delegates.ItemDelegate;
import ca.ubc.cs304.delegates.LoginDelegate;
import ca.ubc.cs304.delegates.MainMenuDelegate;
import ca.ubc.cs304.delegates.SelectionDelegate;
import ca.ubc.cs304.delegates.WorkerDelegate;
import ca.ubc.cs304.delegates.*;
import ca.ubc.cs304.entities.*;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;


public class Warehouse implements LoginDelegate, SelectionDelegate, ItemDelegate, WorkerDelegate, MainMenuDelegate,AggregationDelegate {

    private DatabaseService databaseService;
    private WelcomeUI welcomeUI;

    private SelectionUI selectionUI;
    private ItemUI itemUI;
    private WorkerUI workerUI;
    private AggregationUI aggregationUI;

    private MainMenuUI mainMenuUI;

    public Warehouse() {
        databaseService = new DatabaseService();
        init();
    }

    private void init() {
        welcomeUI = new WelcomeUI(this);
        //aggregationUI = new AggregationUI(databaseService);
        // itemUI = new ItemUI(this);
    }

    @Override
    public void login(String username, String password) {
        boolean connected = databaseService.establishConnection(username, password);

        if (connected) {
            welcomeUI.dispose();
            mainMenuUI = new MainMenuUI(this);
        } else {
            welcomeUI.retryLogin();
        }
    }

    @Override
    public List<ItemEntity> showAllItem(){
        return databaseService.getItemInfo();
    }
    @Override
    public List<FoodItemEntity> showAllFood() {
        return databaseService.getSubFoodItemInfo();
    }

    @Override
    public List<ElectronicItemEntity> showAllElectronic() {
        return databaseService.getSubElectronicItemInfo();
    }

    @Override
    public List<ClothingItemEntity> showAllClothing() {
        return databaseService.getSubClothingItemInfo();
    }

    @Override
    public void insertItem(ItemEntity item) throws SQLException {
        databaseService.insertItem(item);
    }
    @Override
    public void insertClothingItem(ClothingItemEntity clothingItem) throws SQLException {
        databaseService.insertClothingItem(clothingItem);
    }
    @Override
    public void insertFoodItem(FoodItemEntity foodItem) throws SQLException {
        databaseService.insertFoodItem(foodItem);
    }
    @Override
    public void insertElectronicItem(ElectronicItemEntity electronicItem) throws SQLException {
        databaseService.insertElectronicItem(electronicItem);
    }
    @Override
    public void updateItem(ItemEntity item) {
        databaseService.updateItem(item);
    }

    @Override
    public void deleteItem(Integer itemId) {
        System.out.println(itemId);
        databaseService.deleteItem(itemId);
    }

    @Override
    public List<WorkerEntity> projectSelectedWorkerAttributes(Boolean col1, Boolean col2, Boolean col3) {
        return databaseService.projectWorkers(col1, col2, col3);
    };


    @Override
    public DefaultTableModel joinQuery(String queryAttribute, String queryVar, String queryType) throws Exception{
        return databaseService.joinQuery(queryAttribute, queryVar, queryType);
    }

    @Override
    public DefaultTableModel doSelection(List<String> attributes, String table, String field1, String var1, String type1, String field2, String var2, String type2) {
        return databaseService.selection(attributes,table,field1,var1,type1,field2,var2,type2);
    }
    @Override
    public void returnToMainMenu(InterfaceUI ui) {
        ui.dispose();
        mainMenuUI = new MainMenuUI(this);
    }

    @Override
    public void chooseUI(String ui) {
        mainMenuUI.dispose();
        switch(ui){
            case "item":
                itemUI = new ItemUI(this);
                break;
            case "aggregation":
                aggregationUI = new AggregationUI(this, databaseService);
                break;
            case "selection":
                selectionUI = new SelectionUI( this);
                break;
            case "worker":
                workerUI = new WorkerUI( this);
                break;
        }
    }
}