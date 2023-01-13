-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi

SELECT rypalelajike.nimi, rypalelajike.vari,
		(SELECT COUNT(viini.vtunnus) FROM viini WHERE sisaltaa.vtunnus = viini.vtunnus) AS viini_lkm,
		(SELECT COUNT(viinitila.vttunnus) FROM viinitila WHERE viinitila.vttunnus=viini.vttunnus) AS tila_lkm
FROM rypalelajike
LEFT OUTER JOIN sisaltaa ON rypalelajike.rtunnus = sisaltaa.rtunnus
LEFT OUTER JOIN viini ON sisaltaa.vtunnus = viini.vtunnus
LEFT OUTER JOIN viinitila ON viini.vttunnus = viinitila.vttunnus
ORDER BY rypalelajike.nimi ASC;