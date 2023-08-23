package ca.ubc.cs304.entities;

public class ClothingItemEntity {

    private final int ItemID;
    private final int Costs;
    private final String Material;

    public ClothingItemEntity(int itemID, int costs, String material) {
        this.ItemID = itemID;
        this.Costs = costs;
        this.Material = material;
    }

    public int getItemID() {
        return ItemID;
    }

    public int getCosts() {
        return Costs;
    }

    public String getMaterial() {
        return Material;
    }
}
