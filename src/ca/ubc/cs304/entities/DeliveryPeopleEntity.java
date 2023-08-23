package ca.ubc.cs304.entities;

public class DeliveryPeopleEntity {

    private final int DeliveryPeopleID;
    private final String Name;

    public DeliveryPeopleEntity(int deliveryPeopleID, String name) {

        this.DeliveryPeopleID = deliveryPeopleID;
        this.Name = name;

    }

    public int getDeliveryPeople_ID(){
        return DeliveryPeopleID;
    }
    public String getName(){
        return Name;
    }


}
