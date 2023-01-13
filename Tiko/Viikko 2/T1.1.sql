-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi

SELECT viinitila.nimi AS vtnimi, viinitila.maa, viini.nimi AS vnimi
 FROM viinitila
      LEFT OUTER JOIN viini ON viinitila.vttunnus = viini.vttunnus
	  WHERE viinitila.maa = 'Ranska'
	  ORDER BY viinitila.nimi, viini.nimi;