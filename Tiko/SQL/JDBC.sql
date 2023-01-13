-- Tuomo Ikävalko
-- ti427620
-- tuomo.ikavalko@tuni.fi

CREATE TABLE tilit ( 
tilinumero INT,
saldo FLOAT,
PRIMARY KEY (tilinumero));
-- Testi tilit
INSERT INTO tilit (tilinumero, saldo)
VALUES
  (12345678, 30),
  (87654321, 50);
-- ohjelman päivityslauseet
UPDATE tilit
SET saldo = saldo - summa
WHERE tilinumero = ltili AND saldo>summa;

UPDATE tilit
SET saldo= saldo + summa
WHERE tilinumero = stili;