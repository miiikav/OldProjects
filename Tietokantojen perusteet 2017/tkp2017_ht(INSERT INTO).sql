INSERT INTO vuori
VALUES (1, 'Peak Lenin', 'Pamir', 'Aasia', 7134);
INSERT INTO vuori
VALUES (2, 'Mera Peak', 'Himalaja', 'Aasia', 6476);
INSERT INTO vuori
VALUES (3, 'Mont Blanc', 'Alpit', 'Eurooppa', 4180);


INSERT INTO matka
VALUES (1, 'Mera Peakin keskihuipulle', 2016, 'vaativa', 'helppo', 2);
INSERT INTO matka
VALUES (2, 'Peak Lenin 7134', 2017, 'erittäin vaativa', 'kohtalainen', 1);
INSERT INTO matka
VALUES (3, 'Tavoitteena Mont Blanc', 2017, 'vaativa', 'kohtalainen', 3);
INSERT INTO matka
VALUES (4, 'Mera Peakin keskihuipulle', 2018, 'vaativa', 'helppo', 2);


INSERT INTO etappi
VALUES (1, 1,  2016-11-06, 'nousu', 'perusleiri', 5250);
INSERT INTO etappi
VALUES (1, 2, 2016-11-07, 'nousu', 'yläleiri', 5800);
INSERT INTO etappi
VALUES (1, 3, 2016-11-08, 'nousu', 'Mera Peak', 6461);
INSERT INTO etappi
VALUES (1, 4, 2016-11-08, 'laskeutuminen', 'perusleiri', 5250);

INSERT INTO etappi
VALUES (2, 1, 2017-07-26, 'nousu', 'Camp 3', 6100);
INSERT INTO etappi
VALUES (2, 2, 2017-07-27, 'nousu', 'Camp 4', 6400);
INSERT INTO etappi
VALUES (2, 3, 2017-07-28, 'lepo', 'Camp 4', 6400);
INSERT INTO etappi
VALUES (2, 4, 2017-07-29, 'nousu', 'Peak Lenin', 7134);
INSERT INTO etappi
VALUES (2, 5, 2017-07-29, 'laskeutuminen', 'Camp 3', 6100);

INSERT INTO etappi
VALUES (3, 1, 2017-09-09, 'nousu', 'Goûter', 3817, 3);
INSERT INTO etappi
VALUES (3, 2, 2017-09-10, 'nousu', 'Mont Blanc', 4810, 3);
INSERT INTO etappi
VALUES (3, 3, 2017-09-10, 'laskeutuminen', 'Chamonix', 1035, 3);


INSERT INTO vaeltaja
VALUES (1, 'Veikko', 'Vaeltaja', 1982-01-21);
INSERT INTO vaeltaja
VALUES (2, 'Heimo', 'Haukka', 1986-06-26);
INSERT INTO vaeltaja
VALUES (3, 'Vilma', 'Vilkas', 1990-03-14);
INSERT INTO vaeltaja
VALUES (4, 'Kimmo', 'Kiipeilijä', 1988-11-01);


INSERT INTO osallistuu
VALUES (1, 1, 'hyvä', 'vähäinen', 'kiitettävä');
INSERT INTO osallistuu
VALUES (1, 4, 'erinomainen', 'erinomainen', 'erinomainen');

INSERT INTO osallistuu
VALUES (2, 3, 'erinomainen', 'erinomainen', 'erinomainen');
INSERT INTO osallistuu
VALUES (2, 4, 'erinomainen', 'erinomainen', 'erinomainen');

INSERT INTO osallistuu
VALUES (3, 2, 'hyvä', 'vähäinen', 'hyvä');
INSERT INTO osallistuu
VALUES (3, 3, 'erinomainen', 'erinomainen', 'kiitettävä');
INSERT INTO osallistuu
VALUES (3, 4, 'erinomainen', 'erinomainen', 'erinomainen');


INSERT INTO kokee
VALUES (1, 1, 1, 'kohtalainen');
INSERT INTO kokee
VALUES (1, 4, 1, 'helppo');

INSERT INTO kokee
VALUES (2, 3, 1, 'kohtalainen');
INSERT INTO kokee
VALUES (2, 4, 1, 'helppo');
INSERT INTO kokee
VALUES (2, 3, 2, 'kohtalainen');
INSERT INTO kokee
VALUES (2, 4, 2, 'kohtalainen');

INSERT INTO kokee
VALUES (3, 2, 1, 'melko vaativa');
INSERT INTO kokee
VALUES (3, 3, 1, 'helppo');
INSERT INTO kokee
VALUES (3, 4, 1, 'helppo');