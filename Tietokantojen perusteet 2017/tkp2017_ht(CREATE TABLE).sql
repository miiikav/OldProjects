CREATE TABLE vuori (
vtunnus INT,
vnimi VARCHAR(15) NOT NULL,
vuoristo VARCHAR(15),
maanosa VARCHAR(15),
korkeus INT,
PRIMARY KEY (vtunnus),
UNIQUE (vnimi));

CREATE TABLE matka (
mtunnus INT,
mnimi VARCHAR(30),
vuosi INT,
fyysinen VARCHAR(15),
tekninen VARCHAR(15),
vtunnus INT,
PRIMARY KEY (mtunnus),
FOREIGN KEY (vtunnus) REFERENCES vuori,
UNIQUE(mnimi,vuosi));

CREATE TABLE vaeltaja (
vatunnus INT,
etunimi VARCHAR(15),
sukunimi VARCHAR(15),
syntymaaika INT,
PRIMARY KEY (vatunnus));

CREATE TABLE osallistuu (
mtunnus INT,
vatunnus INT,
fyysinenkunto VARCHAR(15),
kiipeilytaito VARCHAR(15),
onnistuminen VARCHAR(15),
PRIMARY KEY (mtunnus,vatunnus),
FOREIGN KEY (mtunnus) REFERENCES matka,
FOREIGN KEY (vatunnus) REFERENCES vaeltaja);

CREATE TABLE etappi (
mtunnus INT,
enro INT,
pvm INT,
etyyppi VARCHAR(15),
maaranpaa VARCHAR(15),
mrpkorkeus INT,
PRIMARY KEY (mtunnus,enro),
PRIMARY KEY (enro),
FOREIGN KEY (mtunnus) REFERENCES matka);

CREATE TABLE kokee (
mtunnus INT,
vatunnus INT,
enro INT,
tekninen_vaativuus VARCHAR(15),
PRIMARY KEY (vatunnus,enro,mtunnus),
FOREIGN KEY (vatunnus) REFERENCES vaeltaja,
FOREIGN KEY (enro) REFERENCES etappi,
FOREIGN KEY (mtunnus) REFERENCES matka);