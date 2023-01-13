CREATE TABLE asiakas ( 
atunnus INT NOT NULL,
animi VARCHAR(35) NOT NULL,
aosoite VARCHAR(25) NOT NULL,
PRIMARY KEY (atunnus));

CREATE TABLE tyokohde (
tktunnus INT NOT NULL,
tkosoite VARCHAR(25) NOT NULL,
atunnus INT NOT NULL,
PRIMARY KEY (tktunnus),
FOREIGN KEY(atunnus) REFERENCES asiakas);

CREATE TABLE sopimus ( 
stunnus INT NOT NULL,
hyvaksytty BOOLEAN NOT NULL,
laskulkm INT NOT NULL,
styyppi VARCHAR NOT NULL,
lisatietoja VARCHAR(40),
tktunnus INT NOT NULL,
PRIMARY KEY (stunnus),
FOREIGN KEY(tktunnus) REFERENCES tyokohde);

CREATE TABLE kaytetaan (
maara INT NOT NULL,
alennus FLOAT,
pvm DATE NOT NULL,
stunnus INT NOT NULL,
ttunnus INT NOT NULL,
FOREIGN KEY(stunnus) REFERENCES sopimus,
FOREIGN KEY(ttunnus) REFERENCES tarvikkeet);

CREATE TABLE tarvikkeet ( 
ttunnus INT NOT NULL,
tnimi VARCHAR(35) NOT NULL,
sisaanostohinta FLOAT NOT NULL,
yksikko VARCHAR(20) NOT NULL,
varastotilanne INT NOT NULL,
myyntihinta FLOAT,
alv FLOAT NOT NULL,
historia BOOLEAN NOT NULL,
lisatietoja VARCHAR(40),
PRIMARY KEY (ttunnus));

CREATE TABLE tyoskentelee (
tuntilkm INT,
alennus FLOAT,
alv FLOAT NOT NULL,
pvm DATE NOT NULL,
tttunnus INT NOT NULL,
stunnus INT NOT NULL,
FOREIGN KEY(tttunnus) REFERENCES tyotyypit,
FOREIGN KEY(stunnus) REFERENCES sopimus);

CREATE TABLE tyotyypit (
tttunnus INT NOT NULL,
ttnimi VARCHAR(35) NOT NULL,
hinta FLOAT NOT NULL,
UNIQUE (ttnimi));

CREATE TABLE lasku (
ltunnus INT NOT NULL,
moneskolasku INT NOT NULL,
ktvahennys FLOAT,
muistutettukarhuttu BOOLEAN NOT NULL,
maksettupvm DATE,
hinta FLOAT NOT NULL,
alehinta FLOAT NOT NULL,
laskutuspvm DATE NOT NULL,
erapaiva DATE NOT NULL,
eltunnus INT,
moneskolasku INT NOT NULL,
laskutuslisa FLOAT,
viivastuskorko FLOAT,
laskukesken BOOLEAN NOT NULL,
stunnus INT NOT NULL,
atunnus INT NOT NULL,
PRIMARY KEY (ltunnus),
FOREIGN KEY(stunnus) REFERENCES sopimus,
FOREIGN KEY(atunnus) REFERENCES asiakas);