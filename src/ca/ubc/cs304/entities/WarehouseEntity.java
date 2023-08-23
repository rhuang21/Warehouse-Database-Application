package ca.ubc.cs304.entities;

public class WarehouseEntity {

    private final int WarehouseID;
    private final String Name;
    private final String Postal;
    private final int BuildingNumber;
    private final String Street;
    private final String Country;
    private final int Capacity;

    public WarehouseEntity(int warehouseID, String name, String postal,
                           int buildingNumber, String street, String country, int capacity) {
        this.WarehouseID = warehouseID;
        this.Country = country;
        this.Name = name;
        this.Postal = postal;
        this.BuildingNumber = buildingNumber;
        this.Capacity = capacity;
        this.Street = street;
    }
    public int getWarehouseID(){
        return WarehouseID;
    }

    public String getCountry(){
        return Country;
    }
    public int getCapacity(){
        return Capacity;
    }
    public int getBuildingNumber(){
        return BuildingNumber;
    }
    public String getName(){
        return Name;
    }
    public String getPostal(){
        return Postal;
    }

    public String getStreet(){
        return Street;
    }
}
