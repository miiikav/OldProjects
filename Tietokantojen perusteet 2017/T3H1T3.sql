-- Tietokantojen perusteet 2017
-- Harjoitukset 1, tehtävä 3
-- Tuomo Ikävalko
-- Ikavalko.Tuomo.J@uta.fi

-- 3

CREATE TABLE juusto (
tunnus INT NOT NULL,
nimi VARCHAR(11) NOT NULL,
kilohinta NUMERIC(6,2),
UNIQUE(nimi),
PRIMARY KEY(tunnus));
 \d juusto;
             Table "public.juusto"
  Column   |         Type          | Modifiers
-----------+-----------------------+-----------
 tunnus    | integer               | not null
 nimi      | character varying(11) | not null
 kilohinta | numeric(4,2)          |
Indexes:
    "juusto_pkey" PRIMARY KEY, btree (tunnus)
    "juusto_nimi_key" UNIQUE CONSTRAINT, btree (nimi)

INSERT INTO juusto VALUES ('1', 'Juusto A', '1001.50');   
 
INSERT INTO juusto VALUES ('11', 'Juusto P', '3.69');   
 
INSERT INTO juusto VALUES ('30', 'Juusto M', '26.50');

SELECT *
FROM juusto;

 tunnus |   nimi   | kilohinta
--------+----------+-----------
      1 | Juusto A |   1001.50
     11 | Juusto P |      3.69
     30 | Juusto M |     26.50
(3 rows)
