-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi
SELECT Tuote.tuote_id, Tuote.nimi
FROM Tuote
LEFT OUTER JOIN Tilaustuote ON Tilaustuote.tuote_id = Tuote.tuote_id
LEFT OUTER JOIN Tilaus ON Tilaustuote.tilaus_id = Tilaus.tilaus_id
LEFT OUTER JOIN Asiakas ON Asiakas.asiakas_id = Tilaus.asiakas_id
WHERE Asiakas.nimi = 'Jaska Jokunen' AND Tilaus.tila = '1'
ORDER BY Tuote.tuote_id ASC;