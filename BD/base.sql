CREATE TABLE SITE(
	idSite int PRIMARY KEY,
	nomSite varchar(20) NOT NULL,
	cheminImageSite varchar(200))

CREATE TABLE FABRICANT(
	idFabricant int PRIMARY KEY,
	nomFabricant varchar(20) NOT NULL,
	telFabricant varchar(20),
	adresseFabricant varchar(100))

CREATE TABLE COMPOSANT(
	idComposant int PRIMARY KEY,
	nomComposant varchar(20) NOT NULL,
	caracteristiqueComposant varchar(300),
	idFabricant int FOREIGN KEY REFERENCES FABRICANT(idFabricant))

CREATE TABLE TYPE(
	nomType varchar(20) PRIMARY KEY,
	cheminImageType varchar(200))

CREATE TABLE REVENDEUR(
	idRevendeur int PRIMARY KEY,
	nomRevendeur varchar(20) NOT NULL,
	telRevendeur varchar(20),
	adresseRevendeur varchar(100))

CREATE TABLE FACTURE(
	idFacture int PRIMARY KEY,
	dateFacture DATE NOT NULL,
	montantFacture float,
	idRevendeur int FOREIGN KEY REFERENCES REVENDEUR(idRevendeur))

CREATE TABLE LOGICIEL(
	idLogiciel int PRIMARY KEY,
	nomLogiciel varchar(40) NOT NULL,
	versionLogiciel varchar(50),
	dateExpirationLogiciel DATE,
	idFacture int FOREIGN KEY REFERENCES FACTURE(idFacture))

CREATE TABLE MATERIEL(
	idMateriel int PRIMARY KEY,
	numImmobMateriel varchar(20) NOT NULL,
	nomMateriel varchar(20),
	dateExpirationGarantieMateriel DATE,
	repertoireDrivers varchar(200),
	modeleMateriel varchar(50),
	etat varchar(20),
	idFacture int FOREIGN KEY REFERENCES FACTURE(idFacture),
	idFabricant int FOREIGN KEY REFERENCES FABRICANT(idFabricant),
	idSite int FOREIGN KEY REFERENCES SITE(idSite),
	nomType varchar(20) FOREIGN KEY REFERENCES TYPE(nomType))

CREATE TABLE COMPOSE(
	idComposant int FOREIGN KEY REFERENCES COMPOSANT(idComposant),
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	PRIMARY KEY(idComposant,idMateriel))

CREATE TABLE ESTINSTALLE(
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	idLogiciel int FOREIGN KEY REFERENCES LOGICIEL(idLogiciel),
	PRIMARY KEY(idMateriel,idLogiciel))

CREATE TABLE PRESTATAIRE(
	idPrestataire int PRIMARY KEY,
	nomPrestataire varchar(20) NOT NULL,
	prenomPrestataire varchar(20),
	telPrestataire varchar(20),
	adressePrestataire varchar(200)
	)
	
CREATE TABLE MAINTENANCE(
	idMaintenance int PRIMARY KEY,
	dateMaintenance DATE NOT NULL,
	objetMaintenance varchar(30),
	descriptionMaintenance varchar(400),
	coutMaintenance float)

CREATE TABLE ESTINTERVENU(
	idFacture int FOREIGN KEY REFERENCES FACTURE(idFacture),
	idPrestataire int FOREIGN KEY REFERENCES PRESTATAIRE(idPrestataire),
	idMaintenance int FOREIGN KEY REFERENCES MAINTENANCE(idMaintenance),
	PRIMARY KEY(idFacture,idPrestataire,idMaintenance))

CREATE TABLE ESTMAINTENU(
	idMaintenance int FOREIGN KEY REFERENCES MAINTENANCE(idMaintenance),
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	PRIMARY KEY(idMaintenance,idMateriel))

CREATE TABLE UTILISATEUR(
	idUtilisateur int PRIMARY KEY,
	nomUtilisateur varchar(20) NOT NULL,
	prenomUtilisateur varchar(20) NOT NULL,
	telUtilisateur varchar(20))

CREATE TABLE UTILISE(
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	idUtilisateur int FOREIGN KEY REFERENCES UTILISATEUR(idUtilisateur),
	PRIMARY KEY(idMateriel,idUtilisateur))


INSERT INTO FABRICANT VALUES (1, 'DELL','05.55.66.77.88' , '2 route perdu 87000'),(2, 'HP','05.55.66.77.88' , '2 route troeuve 87000');

INSERT INTO PRESTATAIRE VALUES (1, 'Caillou', 'Pierre', '05.55.69.87.23', 'Caillou et Co.'),(2, 'Noel', 'Papa', '00.36.65.65.65', 'Pole Nord');
INSERT INTO TYPE VALUES ('PC','sources/images/pc.jpg'),('Routeur','sources/images/routeur.png'),('Switch','sources/images/switch.jpg'),('Clef 3G','sources/images/cle3G.PNG');
INSERT INTO SITE VALUES (1, 'Agen', 'sources/images/logo-ville-agen0.png'),(2, 'Bordeaux', 'sources/images/bordeaux.jpg'),(3, 'Chateauroux', 'sources/images/chateauroux.jpg'),(4, 'Gueret', 'sources/images/Gueret.jpg'),(5, 'Limoges', 'sources/images/limoges.jpg'),(6, 'Montlucon', 'sources/images/montlucon.jpg'),(7, 'Saint-Agnant', 'sources/images/saintAgnan.png'),(8, 'Saint-Junien', 'sources/images/saintJunien.jpg');
INSERT INTO REVENDEUR VALUES (1,'Darty','05.55.21.36.54','4 rue nimporte ou'),(2,'Fnac','05.55.68.57.41','5 rue je sais pas ou ');
INSERT INTO FACTURE VALUES (1, '2011-11-11', 123.5,1),(2, '2012-12-12', 99 ,2);

INSERT INTO MATERIEL VALUES (1,'1IMMO','pc-martine','2012-11-11','/driver/pc-martine','XXX1','EN_MARCHE',1,1,1,'PC'),
(2,'2IMMO','pc-gertrude','2012-11-11','/driver/pc-gertrude','XXX2','EN_MARCHE',1,2,1,'PC'),
(3,'3IMMO','PC1','2014-12-31','/driver/PC1','XXX3','EN_MARCHE',1,1,1,'PC'),
(4,'4IMMO','PC2','2015-12-31','/driver/PC2','XXX4','EN_MARCHE',1,1,2,'PC'),
(5,'5IMMO','PC3','2014-02-05','/driver/PC3','XXX5','EN_MARCHE',2,1,3,'PC'),
(6,'6IMMO','Routeur1','2017-02-14','/driver/Routeur1','XXX6','EN_MARCHE',2,1,4,'PC'),
(7,'7IMMO','Routeur2','2012-03-14','/driver/Routeur2','XXX7','EN_MARCHE',2,1,4,'PC')

INSERT INTO LOGICIEL VALUES (1,'Microsoft Office 2012','1.0','2014-10-01',1)

INSERT INTO MAINTENANCE VALUES
(1,'2014-10-01','erreur','une erreur inconnue est survenue',10),
(2,'2012-02-27','orage','tout a grille',5000),
(3,'2012-02-27','neige','il a neige dans la salle des serveurs',999),
(4,'2012-02-27','utilisateur','j''ai besoin d''une grosse description pour voir ce que ca donne alors je cherche des trucs a ecrire mais comme je trouve pas grand chose je continue a dire n''importe quoi voila la je pense que ca suffira',1)

INSERT INTO UTILISATEUR VALUES
(1,'Bon','Jean','055212354'),
(2,'Leroy','Arthur','055684515'),
(3,'Fury','Johanna','0556519819'),
(4,'Garves','Eddy','058749841')

INSERT INTO UTILISE VALUES
(1,1),
(1,2),
(2,2),
(3,3),
(5,4),
(4,4)

INSERT INTO ESTMAINTENU VALUES
(1,1),
(2,1),
(4,2),
(3,3),
(3,4),
(1,4)
