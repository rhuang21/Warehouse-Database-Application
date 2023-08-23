package ca.ubc.cs304.entities;

import java.sql.Date;

public class ElectronicItemEntity {
    private final int ItemID;
    private final int Warranty;
    private final String Repairs;

    public ElectronicItemEntity(int itemID, int warranty, String repairs) {
        this.ItemID = itemID;
        this.Warranty = warranty;
        this.Repairs = repairs;
    }

    public int getItemID() {
        return ItemID;
    }

    public int getWarranty() {
        return Warranty;
    }

    public String getRepairs() {
        return Repairs;
    }
}
