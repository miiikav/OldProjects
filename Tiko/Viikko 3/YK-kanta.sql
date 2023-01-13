-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi

--a
CREATE TABLE opiskelija ( 
onro INT,
paa_aine VARCHAR(20) NOT NULL,
onimi VARCHAR(35) NOT NULL,
PRIMARY KEY (onro));

CREATE TABLE kurssi ( 
kurssinro INT NOT NULL,
knimi VARCHAR(35) NOT NULL,
openimi VARCHAR(35) NOT NULL,
PRIMARY KEY (kurssinro));

CREATE TABLE suoritus (
onro INT,
kurssinro INT NOT NULL,
arvosana INT,
suorituspvm DATE NOT NULL,
FOREIGN KEY(onro) REFERENCES opiskelija,
FOREIGN KEY(kurssinro) REFERENCES kurssi);
--b
SELECT suoritus.arvosana , kurssi.openimi
FROM suoritus
LEFT OUTER JOIN kurssi ON suoritus.kurssinro = kurssi.kurssinro;
--c
SELECT kurssi.kurssinro, suoritus.suorituspvm
FROM kurssi
LEFT OUTER JOIN suoritus ON suoritus.kurssinro = kurssi.kurssinro
ORDER BY kurssi.kurssinro ASC;

SELECT kurssi.kurssinro, suoritus.suorituspvm
FROM kurssi
LEFT OUTER JOIN suoritus ON suoritus.kurssinro = kurssi.kurssinro
WHERE suoritus.arvosana > 3
ORDER BY kurssi.kurssinro ASC;