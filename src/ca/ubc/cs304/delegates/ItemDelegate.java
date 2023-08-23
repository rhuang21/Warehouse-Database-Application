package ca.ubc.cs304.delegates;

import ca.ubc.cs304.UI.InterfaceUI;
import ca.ubc.cs304.entities.ClothingItemEntity;
import ca.ubc.cs304.entities.ElectronicItemEntity;
import ca.ubc.cs304.entities.FoodItemEntity;
import ca.ubc.cs304.entities.ItemEntity;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public interface ItemDelegate {
    void insertItem(ItemEntity item) throws SQLException;

    void updateItem(ItemEntity item);

    void deleteItem(Integer itemId);

    void insertFoodItem(FoodItemEntity foodItem) throws SQLException;

    void insertElectronicItem(ElectronicItemEntity electronicItem) throws SQLException;
    void insertClothingItem(ClothingItemEntity clothingItem) throws SQLException;

    List<ItemEntity> showAllItem();

    List<FoodItemEntity> showAllFood();

    List<ElectronicItemEntity> showAllElectronic();

    List<ClothingItemEntity> showAllClothing();

    void returnToMainMenu(InterfaceUI ui);

    DefaultTableModel joinQuery(String queryAttribute, String queryVar, String queryType) throws Exception;


}
