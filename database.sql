CREATE DATABASE restaurantReservation;
USE restaurantReservation;

CREATE TABLE admin (
	AdminID INT NOT NULL PRIMARY KEY, 
    AdminName VARCHAR(50) NOT NULL, 
    AdminEmail VARCHAR(50) NOT NULL,
    AdminPassword VARCHAR(50) NOT NULL
);

CREATE TABLE staff (
	StaffID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    StaffName VARCHAR(50) NOT NULL, 
    StaffPhone VARCHAR(12) NOT NULL, 
    StaffRole VARCHAR(50) NOT NULL
);

CREATE TABLE customer (
	CustomerID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(50) NOT NULL, 
	CustomerEmail VARCHAR(50) NOT NULL, 
    CustomerPhone VARCHAR(12) NOT NULL
);

CREATE TABLE restaurant (
	RestaurantID INT NOT NULL PRIMARY KEY,
    RestaurantName VARCHAR(512) NOT NULL, 
    Address VARCHAR(512) NOT NULL,
    RestaurantPhone VARCHAR(12) NOT NULL, 
    RestaurantDescription VARCHAR(1024) NOT NULL, 
    OpenTime TIME NOT NULL, 
    CloseTime TIME NOT NULL,
    AdminID INT NOT NULL, 
    FOREIGN KEY (AdminID) REFERENCES Admin (AdminID)
);

CREATE TABLE reservation (
	ReservationID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FullName VARCHAR(50) NOT NULL, 
    Email VARCHAR(128) NOT NULL, 
	Phone VARCHAR(12) NOT NULL, 
    BookingDate DATE NOT NULL,
    BookingTime TIME NOT NULL,
    NumberOfPeople INT NOT NULL, 
    Requirement VARCHAR(1024),
    CustomerID INT NOT NULL, 
    FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID)
);

CREATE TABLE tableOfRestaurant (
	TableID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    Capacity INT NOT NULL, 
    TableType VARCHAR(50) NOT NULL, 
    TableStatus VARCHAR(50) NOT NULL
);

CREATE TABLE tableReservation (
	tableReservationID INT PRIMARY KEY, 
    TableID INT NOT NULL, 
    ReservationID INT NOT NULL, 
    FOREIGN KEY (TableID) REFERENCES tableofrestaurant (TableID), 
    FOREIGN KEY (ReservationID) REFERENCES Reservation (ReservationID)
);

CREATE TABLE Dish (
	DishID 	INT PRIMARY KEY AUTO_INCREMENT, 
    DishName VARCHAR(512) NOT NULL, 
    DishPrice FLOAT NOT NULL, 
    DishDescription VARCHAR(1024) NOT NULL, 
    DishRate FLOAT DEFAULT 0
);

CREATE TABLE Bill (
	BillID INT PRIMARY KEY AUTO_INCREMENT, 
    DateTimeOut DATETIME NOT NULL, 
    totalPrice FLOAT NOT NULL, 
    ReservationID INT NOT NULL, 
    DishID INT NOT NULL, 
    FOREIGN KEY (DishID) REFERENCES Dish (DishID),
    FOREIGN KEY (ReservationID) REFERENCES Reservation (ReservationID)
);

CREATE TABLE BillDish (
	BillDishID INT PRIMARY KEY AUTO_INCREMENT, 
    DishID INT NOT NULL, 
    BillID INT NOT NULL, 
    FOREIGN KEY (DishID) REFERENCES Dish (DishID), 
    FOREIGN KEY (BillID) REFERENCES Bill (BillID)
);

CREATE TABLE payment (
	PaymentID INT PRIMARY KEY AUTO_INCREMENT, 
    amount FLOAT NOT NULL, 
    DateTimePay DATETIME NOT NULL, 
    method VARCHAR(512) NOT NULL, 
    BillID INT NOT NULL, 
    FOREIGN KEY (BillID) REFERENCES Bill (BillID)
);


