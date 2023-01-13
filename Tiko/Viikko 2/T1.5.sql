-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi
SELECT viini.nimi, viinitila.nimi AS tila
	FROM viinitila
	LEFT OUTER JOIN viini ON viinitila.vttunnus = viini.vttunnus
	WHERE viini.nimi IS NOT NULL
	ORDER BY viini.nimi;