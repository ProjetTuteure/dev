CREATE TABLE SITE(
	idSite int IDENTITY(1,1) PRIMARY KEY ,
	nomSite varchar(20) NOT NULL,
	cheminImageSite varchar(60))

CREATE TABLE FABRICANT(
	nomFabricant varchar(20) PRIMARY KEY NOT NULL,
	telFabricant varchar(20),
	adresseFabricant varchar(50))

CREATE TABLE COMPOSANT(
	idComposant int IDENTITY(1,1) PRIMARY KEY ,
	nomComposant varchar(20) NOT NULL,
	caracteristiqueComposant varchar(200),
	idFabricant int FOREIGN KEY REFERENCES FABRICANT(idFabricant))

CREATE TABLE TYPE(
	nomType varchar(20) PRIMARY KEY,
	cheminImageType varchar(60))


CREATE TABLE REVENDEUR(
	nomRevendeur varchar(20) PRIMARY KEY NOT NULL,
	telRevendeur varchar(20),
	adresseRevendeur varchar(50))

CREATE TABLE FACTURE(
	numFacture varchar(10) IDENTITY(1,1) PRIMARY KEY ,
	dateFacture DATE NOT NULL,
	montantFacture float,
	idRevendeur int FOREIGN KEY REFERENCES REVENDEUR(idRevendeur))

CREATE TABLE LOGICIEL(
	idLogiciel int IDENTITY(1,1) PRIMARY KEY ,
	nomLogiciel varchar(40) NOT NULL,
	versionLogiciel varchar(20),
	dateExpirationLogiciel DATE,
	idFacture int FOREIGN KEY REFERENCES FACTURE(idFacture))

CREATE TABLE ETAT(
	etat varchar(20) PRIMARY KEY
)

CREATE TABLE MATERIEL(
	idMateriel int IDENTITY(1,1) PRIMARY KEY ,
	numImmobMateriel varchar(20) NOT NULL,
	nomMateriel varchar(20),
	dateExpirationGarantieMateriel DATE,
	repertoireDrivers varchar(30),
	modeleMateriel varchar(20),
	etat varchar(20),
	idFacture int FOREIGN KEY REFERENCES FACTURE(idFacture),
	idFabricant int FOREIGN KEY REFERENCES FABRICANT(idFabricant),
	idSite int FOREIGN KEY REFERENCES SITE(idSite),
	nomType varchar(20) FOREIGN KEY REFERENCES TYPE(nomType))

CREATE TABLE COMPOSE(
	idComposant int IDENTITY(1,1) FOREIGN KEY REFERENCES COMPOSANT(idComposant),
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	PRIMARY KEY(idComposant,idMateriel))

CREATE TABLE ESTINSTALLE(
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	idLogiciel int FOREIGN KEY REFERENCES LOGICIEL(idLogiciel),
	PRIMARY KEY(idMateriel,idLogiciel))

CREATE TABLE PRESTATAIRE(
	nomPrestataire varchar(20) PRIMARY KEY NOT NULL,
	prenomPrestataire varchar(20),
	telPrestataire varchar(20),
	adressePrestataire varchar(50)
	)
	
CREATE TABLE MAINTENANCE(
	idMaintenance int IDENTITY(1,1) PRIMARY KEY ,
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
	idUtilisateur int IDENTITY(1,1) PRIMARY KEY ,
	nomUtilisateur varchar(20) NOT NULL,
	prenomUtilisateur varchar(20) NOT NULL,
	telUtilisateur varchar(20))

CREATE TABLE UTILISE(
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	idUtilisateur int FOREIGN KEY REFERENCES UTILISATEUR(idUtilisateur),
	PRIMARY KEY(idMateriel,idUtilisateur))
	

INSERT INTO FABRICANT VALUES ( 'DELL','05.55.66.77.88' , '2 route perdu 87000'),( 'HP','05.55.66.77.88' , '2 route troeuve 87000');

INSERT INTO PRESTATAIRE VALUES ( 'Caillou', 'Pierre', '05.55.69.87.23', 'Caillou et Co.'),( 'Noel', 'Papa', '00.36.65.65.65', 'Pole Nord');
INSERT INTO TYPE VALUES ('PC','sources/images/pc.jpg'),('Routeur','sources/images/routeur.png'),('Switch','sources/images/switch.jpg'),('Clef 3G','sources/images/cle3G.PNG');
INSERT INTO SITE VALUES ('Agen', 'sources/images/logo-ville-agen0.png'),('Bordeaux', 'sources/images/bordeaux.jpg'),('Chateauroux', 'sources/images/chateauroux.jpg'),('Gueret', 'sources/images/Gueret.jpg'),('Limoges', 'sources/images/limoges.jpg'),('Montlucon', 'sources/images/montlucon.jpg'),('Saint-Agnant', 'sources/images/saintAgnan.png'),('Saint-Junien', 'sources/images/saintJunien.jpg');
INSERT INTO REVENDEUR VALUES ('Darty','05.55.21.36.54','4 rue nimporte ou'),('Fnac','05.55.68.57.41','5 rue je sais pas ou ');
INSERT INTO FACTURE VALUES ('2011-11-11', 123.5,1),('2012-12-12', 99 ,2);
INSERT INTO ETAT VALUES ('EN_MARCHE'),('HS'),('EN_PANNE')

INSERT INTO MATERIEL VALUES ('1IMMO','pc-martine','2012-11-11','/driver/pc-martine','XXX1','EN_MARCHE',1,1,1,'PC'),
('2IMMO','pc-gertrude','2012-11-11','/driver/pc-gertrude','XXX2','EN_MARCHE',1,2,1,'PC'),
('3IMMO','PC1','2014-12-31','/driver/PC1','XXX3','EN_MARCHE',1,1,1,'PC'),
('4IMMO','PC2','2015-12-31','/driver/PC2','XXX4','EN_MARCHE',1,1,2,'PC'),
('5IMMO','PC3','2014-02-05','/driver/PC3','XXX5','HS',2,1,3,'PC'),
('6IMMO','Routeur1','2017-02-14','/driver/Routeur1','XXX6','EN_MARCHE',2,1,4,'PC'),
('7IMMO','Routeur2','2012-03-14','/driver/Routeur2','XXX7','EN_PANNE',2,1,4,'PC')

INSERT INTO LOGICIEL VALUES ('Microsoft Office 2012','1.0','2014-10-01',1)

INSERT INTO MAINTENANCE VALUES
('2014-10-01','erreur','une erreur inconnue est survenue',10),
('2012-02-27','orage','tout a grille',5000),
('2012-02-27','neige','il a neige dans la salle des serveurs',999),
('2012-02-27','utilisateur','j''ai besoin d''une grosse description pour voir ce que ca donne alors je cherche des trucs a ecrire mais comme je trouve pas grand chose je continue a dire n''importe quoi voila la je pense que ca suffira',1)

INSERT INTO UTILISATEUR VALUES
('Bon','Jean','055212354'),
('Leroy','Arthur','055684515'),
('Fury','Johanna','0556519819'),
('Garves','Eddy','058749841')

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
