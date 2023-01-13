-- Tietokantojen perusteet 2017
-- Harjoitukset 1, tehtävä 1
-- Tuomo Ikävalko
-- Ikavalko.Tuomo.J@uta.fi

-- 1.1

SELECT *
FROM tapahtuma;

      nimi       | paikkakunta | ajankohta
-----------------+-------------+------------
 Tahdit          | Tampere     | 2017-09-25
 Ruokagalleria   | Tampere     | 2017-09-26
 Autokauppa 2017 | Helsinki    | 2017-11-06
 Suomi juoksee   | Helsinki    | 2017-11-28
(4 rows)

--1.2

SELECT nimi
FROM tapahtuma;

      nimi
-----------------
 Tahdit
 Ruokagalleria
 Autokauppa 2017
 Suomi juoksee
(4 rows)

--1.3

SELECT *
FROM tapahtuma
WHERE nimi = 'Ruokagalleria';

     nimi      | paikkakunta | ajankohta
---------------+-------------+------------
 Ruokagalleria | Tampere     | 2017-09-26
(1 row)

--1.4

SELECT DISTINCT paikkakunta
FROM tapahtuma;

 paikkakunta
-------------
 Tampere
 Helsinki
(2 rows)

--1.5

SELECT *
FROM tapahtuma
WHERE ajankohta >= '2017-09-30';

      nimi       | paikkakunta | ajankohta
-----------------+-------------+------------
 Autokauppa 2017 | Helsinki    | 2017-11-06
 Suomi juoksee   | Helsinki    | 2017-11-28
(2 rows)

