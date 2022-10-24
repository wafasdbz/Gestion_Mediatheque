
insert into UTILISATEUR (LOGIN, PASSE_WORD,NOM, PRENOM) values ('margot@yahoo.fr','mdpmargot','blanc','margot');
insert into UTILISATEUR (LOGIN, PASSE_WORD,NOM, PRENOM) values ('david@yahoo.fr','mdpdavid','thibau','david');
insert into UTILISATEUR (LOGIN, PASSE_WORD,NOM, PRENOM) values ('wafa@yahoo.fr','mdpwafa','bouzouita','wafa');
insert into UTILISATEUR (LOGIN, PASSE_WORD,NOM, PRENOM) values ('zeyna@yahoo.fr','mdpzeyna','sane','zeyna');

insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (1,'La vie',10,'2018-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (2,'La mer',20,'2017-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (3,'La terre',12,'2011-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (4,'Le feu',0,'2018-01-22');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (5,'La ciel',4,'2020-09-02');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (6,'Sixième sens',3,'2001-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (7,'Titanic',0,'1999-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (8,'Kill Bill',6,'2017-10-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (9,'La vie',30,'2018-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (10,'Week-end',10,'2018-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (11,'La grâce',2,'2022-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (12,'La liberté',6,'1990-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (13,'La beauté',0,'1984-09-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (14,'La sérénité',15,'2018-12-12');
insert into ITEM (ID,TITRE, NBRE_EXEMPLAIRE,DATE_PARUTION) values (15,'L''école',3,'2000-12-12');

insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE, ID) values ('YOUSSOU',30,15,1);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE, ID) values ('ANGELE',40,12,2);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE, ID) values ('SOPRANO',35,10,3);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE, ID) values ('FAYROUZ',40,13,4);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE, ID) values ('KENGI',45,15,5);

insert into DVD (REALISATEUR, DUREE,TYPE, ID) values ('LUC BESSON',120,'blueRay',6);
insert into DVD (REALISATEUR, DUREE,TYPE, ID) values ('spielberg',125,'blueRay',7);
insert into DVD (REALISATEUR, DUREE,TYPE, ID) values ('Tarantino',115,'normal',8);
insert into DVD (REALISATEUR, DUREE,TYPE, ID) values ('Polinsky',100,'blueRay',9);
insert into DVD (REALISATEUR, DUREE,TYPE, ID) values ('Godard',128,'normal',10);

insert into LIVRE (ECRIVAIN, NUM_ISBN, ID) values ('Jean',1234,11);
insert into LIVRE (ECRIVAIN, NUM_ISBN, ID) values ('Pierre',5678,12);
insert into LIVRE (ECRIVAIN, NUM_ISBN, ID) values ('Patrice',1432,13);
insert into LIVRE (ECRIVAIN, NUM_ISBN, ID) values ('Amine',6475,14);
insert into LIVRE (ECRIVAIN, NUM_ISBN, ID) values ('Xavier',4356,15);

insert into EMPRUNT (DATE_EMPRUNT,DATE_RETOUR,USER_ID) values ('2022-09-12','2022-09-22',1);
insert into EMPRUNT (DATE_EMPRUNT,DATE_RETOUR,USER_ID) values ('2022-08-12','2022-08-22',2);
insert into EMPRUNT (DATE_EMPRUNT,DATE_RETOUR,USER_ID) values ('2022-01-12','2022-01-22',3);
insert into EMPRUNT (DATE_EMPRUNT,DATE_RETOUR,USER_ID) values ('2022-03-12','2022-03-22',1);
insert into EMPRUNT (DATE_EMPRUNT,DATE_RETOUR,USER_ID) values ('2022-05-12','2022-05-22',4);

insert into ITEM_EMPRUNT (item_id , emprunt_id) values (1 ,1);
insert into ITEM_EMPRUNT (item_id , emprunt_id) values (2 ,1);
insert into ITEM_EMPRUNT (item_id , emprunt_id) values (3 ,2);
insert into ITEM_EMPRUNT (item_id , emprunt_id) values (6 ,2);
insert into ITEM_EMPRUNT (item_id , emprunt_id) values (11 ,2);
insert into ITEM_EMPRUNT (item_id , emprunt_id) values (11 ,3);
insert into ITEM_EMPRUNT (item_id , emprunt_id) values (13 ,4);
insert into ITEM_EMPRUNT (item_id , emprunt_id) values (5 ,5);



