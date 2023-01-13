-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi

CREATE TABLE car (
VehicleId INT,
LicensePlateNo INT,
NoOfPassengers INT,
MaxSpeed INT,
Price INT,
PRIMARY KEY (VehicleId));

CREATE TABLE truck ( 
VehicleId INT,
LicensePlateNo INT,
NoOfAxles INT,
Tonnage INT,
Price INT,
PRIMARY KEY (VehicleId));