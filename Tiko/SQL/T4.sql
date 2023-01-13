-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi
SELECT Tilaus.tilaus_id
FROM Tilaus
LEFT OUTER JOIN Asiakas ON Asiakas.asiakas_id = Tilaus.asiakas_id
WHERE ASiakas.nimi = 'Jaska Jokunen'
ORDER BY Tilaus.tilaus_id ASC;