-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi

--a
CREATE TABLE opiskelija ( 
onro INT,
paa_aine VARCHAR(20) NOT NULL,
onimi VARCHAR(35) NOT NULL,
UNIQUE (onro),
PRIMARY KEY (onro);

CREATE TABLE opettaja ( 
puh INT,
huonenum INT,
openimi VARCHAR(35) NOT NULL,
PRIMARY KEY (openimi);

CREATE TABLE kurssi ( 
kurssinro INT NOT NULL,
knimi VARCHAR(35) NOT NULL,
opettajan_nimi VARCHAR(35) NOT NULL,
UNIQUE (knimi),
PRIMARY KEY (kurssinro);

CREATE TABLE suoritus ( 
FOREIGN KEY(onro) REFERENCES opiskelija),
arvosana INT,
FOREIGN KEY(kurssinro) REFERENCES kurssi);
--b

--c