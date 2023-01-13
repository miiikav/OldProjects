-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi

CREATE TABLE vehicle ( 
VehicleId INT,
Price INT,
LicensePlateNo INT,
UNIQUE (VehicleId),
PRIMARY KEY (VehicleId));

CREATE TABLE car (
NoOfPassengers INT,
MaxSpeed INT,
FOREIGN KEY(VehicleId) REFERENCES vehicle,
FOREIGN KEY(LicensePlateNo) REFERENCES vehicle,
PRIMARY KEY (VehicleId));

CREATE TABLE truck ( 
NoOfAxles INT,
Tonnage INT,
FOREIGN KEY(VehicleId) REFERENCES vehicle,
FOREIGN KEY(LicensePlateNo) REFERENCES vehicle,
PRIMARY KEY (VehicleId));