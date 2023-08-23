package ca.ubc.cs304.delegates;

import ca.ubc.cs304.UI.InterfaceUI;
import ca.ubc.cs304.entities.ClothingItemEntity;
import ca.ubc.cs304.entities.ElectronicItemEntity;
import ca.ubc.cs304.entities.FoodItemEntity;
import ca.ubc.cs304.entities.ItemEntity;

import java.sql.SQLException;
import java.util.List;

public interface AggregationDelegate {

    void returnToMainMenu(InterfaceUI ui);

}
