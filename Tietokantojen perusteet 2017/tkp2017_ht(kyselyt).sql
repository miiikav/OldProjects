--1
SELECT onnistuminen, enro, maaranpaa, tekninen_vaativuus
FROM vaeltaja, vuori, matka, etappi
WHERE etunimi='vilma'
AND vnimi='Peak Lenin'
ORDER BY enro;
--2
SELECT vatunnus, etunimi, sukunimi
FROM vaeltaja, vuori, matka
WHERE maanosa='Aasia'
ORDER BY vatunnus;
--3a
SELECT mnimi, vuosi, vnimi, korkeus
FROM matka, vuori
WHERE korkeus =< ALL (SELECT korkeus FROM vuori);
--4a
SELECT mnimi, vuosi,
FROM matka, etappi,
	(SELECT MIN(pvm) AS alkamispäivä,
			MAX(pvm) AS loppumispäivä,
			COUNT(enro) AS etappien_lukumäärä
			FROM etappi
			ORDER BY alkamispäivä);
--5a
SELECT mnimi, vuosi, vatunnus, sukunimi
FROM matka, vaeltaja ;
