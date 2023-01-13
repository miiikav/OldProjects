-- Tietokantojen perusteet 2017
-- Harjoitukset 1, tehtävä 2
-- Tuomo Ikävalko
-- Ikavalko.Tuomo.J@uta.fi

-- 2.1
INSERT INTO tapahtuma VALUES ('Vuoden Dokumentti 2017', 'Helsinki', NULL);   
-- 2.2
UPDATE tapahtuma SET ajankohta = '12.10.2017' WHERE nimi = 'Vuoden Dokumentti 2017';
--2.3
UPDATE tapahtuma SET paikkakunta = 'Helsingfors' WHERE paikkakunta = 'Helsinki';
--2.4
DELETE FROM tapahtuma WHERE ajankohta < '2017-10-1';