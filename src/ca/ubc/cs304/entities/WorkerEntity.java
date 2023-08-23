package ca.ubc.cs304.entities;

public class WorkerEntity {

    private final int WorkerID;
    private final String Name;
    private final String ClothingSize;

    public WorkerEntity(int workerID, String clothingSize, String name){
        this.ClothingSize = clothingSize;
        this.Name = name;
        this.WorkerID = workerID;
    }

    public int getWorkerID() {
        return WorkerID;
    }

    public String getClothingSize() {
        return ClothingSize;
    }

    public String getName() {
        return Name;
    }
}

