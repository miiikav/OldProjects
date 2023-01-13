-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi
SELECT Tilaus.tilaus_id, Asiakas.asiakas_id, Asiakas.nimi
FROM Tilaus
LEFT OUTER JOIN Asiakas ON Asiakas.asiakas_id = Tilaus.asiakas_id
ORDER BY Tilaus.tilaus_id ASC;