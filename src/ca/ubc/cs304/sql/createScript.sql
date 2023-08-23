CREATE TABLE Workers(
                        workerID INTEGER PRIMARY KEY,
                        clothingSize VARCHAR(50),
                        name VARCHAR(50) NOT NULL
);

CREATE TABLE Salary(
                       Salary INTEGER PRIMARY KEY,
                       "401K" INTEGER
);


CREATE TABLE WarehouseLocation(
                                  Postal VARCHAR(30),
                                  Country VARCHAR(30),
                                  Street VARCHAR(30),
                                  PRIMARY KEY(Postal, Country)
);

CREATE TABLE Warehouse(
                          WarehouseID INTEGER PRIMARY KEY,
                          Name VARCHAR(30) NOT NULL,
                          Postal VARCHAR(30),
                          Country VARCHAR(30),
                          BuildingNumber INTEGER,
                          Capacity INTEGER,
                          FOREIGN KEY (Postal, Country) REFERENCES WarehouseLocation (Postal, Country) ON DELETE CASCADE
);


CREATE TABLE HasSectors(
                           Name VARCHAR(50),
                           HeadCount INTEGER,
                           WarehouseId INTEGER,
                           PRIMARY KEY(Name, WarehouseID),
                           FOREIGN KEY(WarehouseId) REFERENCES Warehouse(WarehouseId) ON DELETE
                               CASCADE
);


CREATE TABLE Employs(
                        WorkerID INTEGER,
                        Sector_Name VARCHAR(50),
                        WarehouseId INTEGER,
                        Salary INTEGER DEFAULT 0 NOT NULL,
                        PRIMARY KEY(WorkerID, Sector_Name, WarehouseID),
                        FOREIGN KEY(WorkerID) REFERENCES Workers(WorkerID) ON DELETE CASCADE,
                        FOREIGN KEY(Sector_Name, WarehouseId) REFERENCES HasSectors(Name, WarehouseId) ON DELETE CASCADE,
                        FOREIGN KEY(Salary) REFERENCES Salary(Salary) ON DELETE CASCADE
);

ALTER TABLE Employs
MODIFY Salary DEFAULT 0;

create assertion total_participation
CHECK (
    NOT EXISTS (
        SELECT 1
        FROM Students
        WHERE NOT EXISTS (
            SELECT 1
            FROM Enrollments
            WHERE Enrollments.StudentID = Students.StudentID
        )
    )
);

CREATE TABLE DeliveryCompany (
                                 ID INTEGER PRIMARY KEY,
                                 Name VARCHAR(30)
);

CREATE TABLE VehiclesType(
                             Type VARCHAR(30) PRIMARY KEY,
                             WeightLimit INTEGER
);

CREATE TABLE DeliveryPeople(
                               DeliveryPeople_ID INTEGER,
                               Name VARCHAR(30) NOT NULL,
                               DeliveryCompany_ID INTEGER NOT NULL,
                               PRIMARY KEY(DeliveryPeople_ID),
                               FOREIGN KEY(DeliveryCompany_ID) REFERENCES DeliveryCompany(ID) ON DELETE CASCADE
);

CREATE TABLE Vehicles(
                         Vehicle_ID INTEGER,
                         Type VARCHAR(30) NOT NULL,
                         DeliveryCompany_ID INTEGER NOT NULL,
                         DeliveryPeople_ID INTEGER NOT NULL,
                         PRIMARY KEY(Vehicle_ID),
                         FOREIGN KEY(DeliveryCompany_ID) REFERENCES DeliveryCompany(ID) ON DELETE CASCADE,
                         FOREIGN KEY(DeliveryPeople_ID) REFERENCES DeliveryPeople(DeliveryPeople_ID) ON DELETE CASCADE,
                         FOREIGN KEY(type) REFERENCES VehiclesType(Type) ON DELETE CASCADE
);


CREATE TABLE Deliver(
                        DeliveryPeople_ID INTEGER,
                        Warehouse_ID INTEGER,
                        PostalCode VARCHAR(30),
                        Worker_ID INTEGER NOT NULL,
                        ETA DATE,
                        PRIMARY KEY(DeliveryPeople_ID, Warehouse_ID),
                        FOREIGN KEY(Warehouse_ID) REFERENCES Warehouse(WarehouseId) ON DELETE CASCADE,
                        FOREIGN KEY(DeliveryPeople_ID) REFERENCES DeliveryPeople(DeliveryPeople_ID) ON DELETE CASCADE,
                        FOREIGN KEY(Worker_ID) REFERENCES Workers(workerID) ON DELETE CASCADE
);

CREATE TABLE CustomerLocation(
                                 PostalCode VARCHAR(30),
                                 Country VARCHAR(30),
                                 City VARCHAR(30),
                                 Province VARCHAR(30),
                                 PRIMARY KEY(PostalCode, Country)
);

CREATE TABLE CustomerInformation(
                                    Email VARCHAR(30),
                                    Name VARCHAR(30),
                                    Phone INTEGER,
                                    PostalCode VARCHAR(30),
                                    Country VARCHAR(30),
                                    PRIMARY KEY(Email),
                                    FOREIGN KEY (Country, PostalCode) REFERENCES CustomerLocation(Country, PostalCode) ON DELETE CASCADE
);

CREATE TABLE Customer(
                         ID INTEGER,
                         Email VARCHAR(30) UNIQUE,
                         PRIMARY KEY(ID),
                         FOREIGN KEY (Email) REFERENCES CustomerInformation(Email) ON DELETE CASCADE
);

CREATE TABLE ItemStatus(
                           Status VARCHAR(50) PRIMARY KEY,
                           Missing INTEGER
);

CREATE TABLE Items(
                      ItemID INTEGER,
                      Sector VARCHAR(80),
                      Status VARCHAR(50) DEFAULT 'Unknown' NOT NULL,
                      ReceiveDate DATE,
                      Fragile INTEGER,
                      DeliveryP_ID INTEGER,
                      WarehouseID INTEGER NOT NULL,
                      CustomerID INTEGER NOT NULL,
                      PRIMARY KEY(ItemID),
                      FOREIGN KEY(WarehouseId) REFERENCES Warehouse(WarehouseId) ON DELETE
                          CASCADE,
                      FOREIGN KEY(CustomerID) REFERENCES Customer(ID) ON DELETE CASCADE,
                      FOREIGN KEY(Status) REFERENCES ItemStatus(Status) ON DELETE CASCADE
);

ALTER TABLE Items
    MODIFY Status DEFAULT 'Unknown';

CREATE TABLE ElectronicItems(
                                ItemID INTEGER PRIMARY KEY,
                                Warranty INTEGER,
                                Repairs VARCHAR(80),
                                FOREIGN KEY(ItemID) REFERENCES Items(ItemID) ON DELETE
                                    CASCADE
);

CREATE TABLE ClothingItems(
                              ItemID INTEGER PRIMARY KEY,
                              Costs INTEGER,
                              Material VARCHAR(50),
                              FOREIGN KEY(ItemID) REFERENCES Items(ItemID) ON DELETE
                                  CASCADE
);

CREATE TABLE FoodItems(
                          ItemID INTEGER PRIMARY KEY,
                          Expiration DATE,
                          ManufactureDate DATE,
                          FOREIGN KEY(ItemID) REFERENCES Items(ItemID) ON DELETE
                              CASCADE
);
