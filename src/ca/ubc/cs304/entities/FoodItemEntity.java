package ca.ubc.cs304.entities;

import java.sql.Date;

public class FoodItemEntity {
    private final int ItemID;
    private final Date Expiration;
    private final Date ManufactureDate;

    public FoodItemEntity(int itemID, Date expiration, Date manufactureDate) {
        this.ItemID = itemID;
        this.Expiration = expiration;
        this.ManufactureDate = manufactureDate;
    }

    public int getItemID() {
        return ItemID;
    }

    public Date getExpiration() {
        return Expiration;
    }

    public Date getManufactureDate() {
        return ManufactureDate;
    }
}
