-- Tietokantojen perusteet 2017
-- Harjoitukset 1, tehtävä 8
-- Tuomo Ikävalko
-- Ikavalko.Tuomo.J@uta.fi

-- 8

CREATE TABLE stats (
username VARCHAR(18) NOT NULL,
spenttime1 NUMERIC(5),
spenttime2 NUMERIC(5),
win NUMERIC(5),
loss NUMERIC(5),
PRIMARY KEY(username));

INSERT INTO stats VALUES('username1','30','55','24','19');
INSERT INTO stats VALUES('username2','300','40','245','182');
INSERT INTO stats VALUES('username3','127','70','134','137');

SELECT *
FROM stats;

 username  | spenttime1 | spenttime2 | win | loss
-----------+------------+------------+-----+------
 username1 |         30 |         55 |  24 |   19
 username2 |        300 |         40 | 245 |  182
 username3 |        127 |         70 | 134 |  137
(3 rows)
