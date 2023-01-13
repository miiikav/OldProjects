-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi
SELECT rypalelajike.nimi
 FROM rypalelajike
 LEFT OUTER JOIN sisaltaa ON rypalelajike.rtunnus = sisaltaa.rtunnus 
 GROUP BY rypalelajike.nimi
 HAVING COUNT(*) > 1;