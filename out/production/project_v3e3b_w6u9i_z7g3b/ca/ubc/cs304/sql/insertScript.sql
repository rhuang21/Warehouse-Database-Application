INSERT INTO Workers (workerID , clothingSize , name ) VALUES (1, 's', 'Kristen Cox');
INSERT INTO Workers (workerID , clothingSize , name ) VALUES (2, 's', 'Harley Gibbs');
INSERT INTO Workers (workerID , clothingSize , name ) VALUES (3, 'm', 'Emre Matthams');
INSERT INTO Workers (workerID , clothingSize , name ) VALUES (4, 'l', 'Richie Cervantes');
INSERT INTO Workers (workerID , clothingSize , name ) VALUES (5, 'xl', 'Kylie Dawson');

INSERT INTO Salary (Salary , "401K" ) VALUES (50000, 5000);
INSERT INTO Salary (Salary , "401K" ) VALUES (40000, 4000);
INSERT INTO Salary (Salary , "401K" ) VALUES (55000, 5500);
INSERT INTO Salary (Salary , "401K" ) VALUES (30000, 3000);
INSERT INTO Salary (Salary , "401K" ) VALUES (45000, 4500);

INSERT INTO WarehouseLocation (Postal , Country , Street) VALUES ('E6J 4N9', 'Canada', 'Thorne Oval');
INSERT INTO WarehouseLocation (Postal , Country , Street) VALUES ('J8B 7M8', 'America', 'Hampstead Willows');
INSERT INTO WarehouseLocation (Postal , Country , Street) VALUES ('L4G 2N8', 'Belgium', 'Elan Place ');
INSERT INTO WarehouseLocation (Postal , Country , Street) VALUES ('J2N 1H3', 'France', 'Hudson Leas');
INSERT INTO WarehouseLocation (Postal , Country , Street) VALUES ('N4L 9C1', 'Japan', 'Kimberley Banks');

INSERT INTO Warehouse (WarehouseID , Name , Postal , BuildingNumber , Country , Capacity ) VALUES (1, 'AW Warehouse', 'E6J 4N9', 1321, 'Canada', 20000);
INSERT INTO Warehouse (WarehouseID , Name , Postal , BuildingNumber , Country , Capacity ) VALUES (2, 'AB Warehouse', 'J8B 7M8', 2341, 'America', 12234);
INSERT INTO Warehouse (WarehouseID , Name , Postal , BuildingNumber , Country , Capacity ) VALUES (3, 'AC Warehouse', 'L4G 2N8', 3432, 'Belgium', 2122);
INSERT INTO Warehouse (WarehouseID , Name , Postal , BuildingNumber , Country , Capacity ) VALUES (4, 'AD Warehouse', 'J2N 1H3', 1231, 'France', 33321);
INSERT INTO Warehouse (WarehouseID , Name , Postal , BuildingNumber , Country , Capacity ) VALUES (5, 'AE Warehouse', 'N4L 9C1', 3425, 'Japan', 31112);

INSERT INTO HasSectors (Name , WarehouseId , HeadCount ) VALUES ('Food', 1, 10);
INSERT INTO HasSectors (Name , WarehouseId , HeadCount ) VALUES ('Electronic', 2, 20);
INSERT INTO HasSectors (Name , WarehouseId , HeadCount ) VALUES ('Clothing', 3, 32);
INSERT INTO HasSectors (Name , WarehouseId , HeadCount ) VALUES ('Electronic', 4, 12);
INSERT INTO HasSectors (Name , WarehouseId , HeadCount ) VALUES ('Clothing', 5, 34);

INSERT INTO Employs (workerID , Sector_Name , WarehouseId , Salary ) VALUES (1, 'Electronic', 2, 50000);
INSERT INTO Employs (workerID , Sector_Name , WarehouseId , Salary ) VALUES (2, 'Clothing', 3, 40000);
INSERT INTO Employs (workerID , Sector_Name , WarehouseId , Salary ) VALUES (3, 'Food', 1, 55000);
INSERT INTO Employs (workerID , Sector_Name , WarehouseId , Salary ) VALUES (4, 'Electronic', 4, 50000);
INSERT INTO Employs (workerID , Sector_Name , WarehouseId , Salary ) VALUES (5, 'Food', 1, 55000);

INSERT INTO DeliveryCompany (ID, Name) VALUES (1, 'Best Transport');
INSERT INTO DeliveryCompany (ID, Name) VALUES (2, 'Quick Company');
INSERT INTO DeliveryCompany (ID, Name) VALUES (3, 'Howards');
INSERT INTO DeliveryCompany (ID, Name) VALUES (4, 'Fast and Reliable');
INSERT INTO DeliveryCompany (ID, Name) VALUES (5, 'Canadia Post');

INSERT INTO VehiclesType (Type , WeightLimit ) VALUES ('Bike', 10);
INSERT INTO VehiclesType (Type , WeightLimit ) VALUES ('SUV', 100);
INSERT INTO VehiclesType (Type , WeightLimit ) VALUES ('Van', 200);
INSERT INTO VehiclesType (Type , WeightLimit ) VALUES ('Truck', 300);
INSERT INTO VehiclesType (Type , WeightLimit ) VALUES ('Sedan', 50);

INSERT INTO DeliveryPeople (DeliveryPeople_ID, Name, DeliveryCompany_ID) VALUES (1, 'Carlos Bean', 1);
INSERT INTO DeliveryPeople (DeliveryPeople_ID, Name, DeliveryCompany_ID) VALUES (2, 'Hans Ziegler', 2);
INSERT INTO DeliveryPeople (DeliveryPeople_ID, Name, DeliveryCompany_ID) VALUES (3, 'Bob Marker', 3);
INSERT INTO DeliveryPeople (DeliveryPeople_ID, Name, DeliveryCompany_ID) VALUES (4, 'Kayla Scofield', 3);
INSERT INTO DeliveryPeople (DeliveryPeople_ID, Name, DeliveryCompany_ID) VALUES (5, 'Barney Juan Vasquez', 4);
INSERT INTO DeliveryPeople (DeliveryPeople_ID, Name, DeliveryCompany_ID) VALUES (6, 'Jack Taylor', 5);

INSERT INTO Vehicles (Vehicle_ID , Type , DeliveryCompany_ID , DeliveryPeople_ID ) VALUES (1, 'SUV', 1, 1);
INSERT INTO Vehicles (Vehicle_ID , Type , DeliveryCompany_ID , DeliveryPeople_ID ) VALUES (2, 'Truck', 3, 2);
INSERT INTO Vehicles (Vehicle_ID , Type , DeliveryCompany_ID , DeliveryPeople_ID ) VALUES (3, 'Sedan', 2, 4);
INSERT INTO Vehicles (Vehicle_ID , Type , DeliveryCompany_ID , DeliveryPeople_ID ) VALUES (4, 'Bike', 4, 5);
INSERT INTO Vehicles (Vehicle_ID , Type , DeliveryCompany_ID , DeliveryPeople_ID ) VALUES (5, 'Van', 5, 3);


INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 1, 'G0B 6R1', 1, TO_DATE('01/30/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (2, 3, 'G0C 6E9', 2, TO_DATE('02/18/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (3, 3, 'V1C 1G4', 3, TO_DATE('02/17/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (4, 3, 'L7G 8J0', 4, TO_DATE('01/30/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (5, 4, 'V9A 7Y9', 5, TO_DATE('02/02/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 2, 'Y4A B2C', 2, TO_DATE('02/22/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 3, 'C8S ADS', 4, TO_DATE('01/15/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 4, 'BY4 ABC', 4, TO_DATE('01/15/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 5, 'D4S S4A', 3, TO_DATE('04/17/2023', 'MM/DD/YYYY'));

INSERT INTO CustomerLocation (PostalCode, Country, City, Province) VALUES ('V5K 0A1', 'Canada', 'Vancouver', 'BC');
INSERT INTO CustomerLocation (PostalCode, Country, City, Province) VALUES ('V6Z 1R7', 'Canada', 'Vancouver', 'BC');
INSERT INTO CustomerLocation (PostalCode, Country, City, Province) VALUES ('V6Z 1R8', 'Canada', 'Vancouver ', 'BC');
INSERT INTO CustomerLocation (PostalCode, Country, City, Province) VALUES ('98102', 'USA', 'Seattle', 'Washington');
INSERT INTO CustomerLocation (PostalCode, Country, City, Province) VALUES ('99352', 'USA', 'Richland', 'Washington');
INSERT INTO CustomerLocation (PostalCode, Country, City, Province) VALUES ('23142', 'India', 'Asansol', 'Bengal');


INSERT INTO CustomerInformation (Email, Name, Phone, PostalCode, Country) VALUES ('george_braun30@gmail.com', 'George Braun', 2317648181, 'V5K 0A1', 'Canada');
INSERT INTO CustomerInformation (Email, Name, Phone, PostalCode, Country) VALUES ('MelissaW@hotmail.com', 'Melissa Woody', 2344234244, 'V6Z 1R7', 'Canada');
INSERT INTO CustomerInformation (Email, Name, Phone, PostalCode, Country) VALUES ( 'Marco75@gmail.com', 'Marceline Avila', 2242436754, 'V6Z 1R7', 'Canada');
INSERT INTO CustomerInformation (Email, Name, Phone, PostalCode, Country) VALUES ('Mikey55@gmail.com', 'Michael Lara', 2635532345, '98102', 'USA');
INSERT INTO CustomerInformation (Email, Name, Phone, PostalCode, Country) VALUES ('JoeEins1999@gmail.com', 'Joe Eins', 2885677744, '99352', 'USA');
INSERT INTO CustomerInformation (Email, Name, Phone, PostalCode, Country) VALUES ('vald@gmail.com', 'Vald Sa', 132214524, '23142', 'India');


INSERT INTO Customer (ID, Email) VALUES (1, 'george_braun30@gmail.com');
INSERT INTO Customer (ID, Email) VALUES (2, 'MelissaW@hotmail.com');
INSERT INTO Customer (ID, Email)  VALUES (3, 'Marco75@gmail.com');
INSERT INTO Customer (ID, Email) VALUES (4, 'Mikey55@gmail.com');
INSERT INTO Customer(ID, Email) VALUES (5, 'JoeEins1999@gmail.com');
INSERT INTO Customer(ID, Email) VALUES (6, 'vald@gmail.com');

INSERT INTO ItemStatus (Status , Missing ) VALUES ('In transit', 0);
INSERT INTO ItemStatus (Status , Missing ) VALUES ('In Warehouse', 0);
INSERT INTO ItemStatus (Status , Missing ) VALUES ('Unknown', 1);
INSERT INTO ItemStatus (Status , Missing ) VALUES ('Delivering', 0);
INSERT INTO ItemStatus (Status , Missing ) VALUES ('Destroyed', 0);


INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (2, 'Electronic', 'In transit', TO_DATE('03/31/2022', 'MM/DD/YYYY'), 1, 1, 1, 1);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (3, 'Electronic', 'In Warehouse', TO_DATE('06/18/2022', 'MM/DD/YYYY'), 1, 2, 2, 2);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (4, 'Electronic', 'Delivering', TO_DATE('01/10/2023', 'MM/DD/YYYY'), 1, 3, 2, 2);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (5, 'Electronic', 'Unknown', TO_DATE('08/22/2022', 'MM/DD/YYYY'), 1, 3, 3, 4);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (6, 'Electronic', 'Unknown', TO_DATE('02/18/2021', 'MM/DD/YYYY'), 1, 3, 3, 3);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (7, 'Food', 'Delivering', TO_DATE('01/04/2023', 'MM/DD/YYYY'), 1, 1, 3, 5);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (8, 'Food', 'Unknown', TO_DATE('04/25/2021', 'MM/DD/YYYY'), 0, 5, 4, 4);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (9, 'Food', 'In Warehouse', TO_DATE('01/09/2022', 'MM/DD/YYYY'), 0, 3, 4, 2);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (10, 'Food', 'Delivering', TO_DATE('05/15/2021', 'MM/DD/YYYY'), 1, 2, 5, 2);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (11, 'Food', 'In Warehouse', TO_DATE('11/13/2021', 'MM/DD/YYYY'), 0, 1, 1, '1');

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (12, 'Clothing', 'Unknown', TO_DATE('10/03/2022', 'MM/DD/YYYY'), 0, NULL, 3, 3);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (13, 'Clothing', 'Delivering', TO_DATE('11/23/2022', 'MM/DD/YYYY'), 0, 4, 3, '1');

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (14, 'Clothing', 'In Warehouse', TO_DATE('04/28/2022', 'MM/DD/YYYY'), '1', '3', '2', '4');

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (15, 'Clothing', 'Unknown', TO_DATE('12/20/2021', 'MM/DD/YYYY'), 0, NULL, 2, 3);

INSERT INTO Items (ItemID, Sector, Status, ReceiveDate, Fragile, DeliveryP_ID, WarehouseID, CustomerID)
VALUES (16, 'Clothing', 'In transit', TO_DATE('09/15/2022', 'MM/DD/YYYY'), 1, NULL, 4, 2);

INSERT INTO ElectronicItems (ItemID, Warranty, Repairs) VALUES (2, 5, 'Software Troubleshooting');
INSERT INTO ElectronicItems (ItemID, Warranty, Repairs) VALUES (3, 4, 'Faulty Switch');
INSERT INTO ElectronicItems (ItemID, Warranty, Repairs) VALUES (4, 3, 'Bulb Burnout');
INSERT INTO ElectronicItems (ItemID, Warranty, Repairs) VALUES (5, 2, 'Short Circuit Breaker');
INSERT INTO ElectronicItems (ItemID, Warranty, Repairs) VALUES (6, 5, 'Broken Wires');


INSERT INTO FoodItems (ItemID, Expiration, ManufactureDate)
VALUES (7, TO_DATE('2/17/2023', 'MM/DD/YYYY'), TO_DATE('2/17/2019', 'MM/DD/YYYY'));

INSERT INTO FoodItems (ItemID, Expiration, ManufactureDate)
VALUES (8, TO_DATE('2/18/2023', 'MM/DD/YYYY'), TO_DATE('2/17/2020', 'MM/DD/YYYY'));

INSERT INTO FoodItems (ItemID, Expiration, ManufactureDate)
VALUES (9, TO_DATE('2/17/2024', 'MM/DD/YYYY'), TO_DATE('2/17/2023', 'MM/DD/YYYY'));

INSERT INTO FoodItems (ItemID, Expiration, ManufactureDate)
VALUES (10, TO_DATE('6/17/2025', 'MM/DD/YYYY'), TO_DATE('2/17/2023', 'MM/DD/YYYY'));

INSERT INTO FoodItems (ItemID, Expiration, ManufactureDate)
VALUES (11, TO_DATE('2/17/2022', 'MM/DD/YYYY'), TO_DATE('2/17/2021', 'MM/DD/YYYY'));

INSERT INTO ClothingItems (ItemID, Costs, Material) VALUES (12, 45, 'Wool');
INSERT INTO ClothingItems (ItemID, Costs, Material) VALUES (13, 60, 'Cotton');
INSERT INTO ClothingItems (ItemID, Costs, Material) VALUES (14, 35, 'Polyester');
INSERT INTO ClothingItems (ItemID, Costs, Material) VALUES (15, 55, 'Mesh');
INSERT INTO ClothingItems (ItemID, Costs, Material) VALUES (16, 50, 'Hemp');

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 2, 'Y4A B2C', 2, TO_DATE('02/22/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 3, 'C8S ADS', 4, TO_DATE('01/15/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 4, 'BY4 ABC', 4, TO_DATE('01/15/2023', 'MM/DD/YYYY'));

INSERT INTO Deliver (DeliveryPeople_ID, Warehouse_ID, PostalCode, Worker_ID, ETA)
VALUES (1, 5, 'D4S S4A', 3, TO_DATE('04/17/2023', 'MM/DD/YYYY'));

