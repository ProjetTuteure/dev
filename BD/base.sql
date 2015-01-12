CREATE TABLE SITE(
	idSite int PRIMARY KEY,
	nomSite varchar(20) NOT NULL,
	cheminImage varchar(30))

CREATE TABLE FABRICANT(
	idFabricant int PRIMARY KEY,
	nomFabricant varchar(20) NOT NULL,
	telFabricant varchar(20),
	adresseFabricant varchar(50))

CREATE TABLE COMPOSANT(
	idComposant int PRIMARY KEY,
	nomComposant varchar(20) NOT NULL,
	caracteristiqueComposant varchar(200),
	idFabricant int FOREIGN KEY REFERENCES FABRICANT(idFabricant))

CREATE TABLE TYPE(
	nomType varchar(20) PRIMARY KEY,
	cheminImage varchar(30))

CREATE TABLE REVENDEUR(
	idRevendeur int PRIMARY KEY,
	nomRevendeur varchar(20) NOT NULL,
	telRevendeur varchar(20),
	adresseRevendeur varchar(50))

CREATE TABLE FACTURE(
	idFacture int PRIMARY KEY,
	dateFacture DATE NOT NULL,
	montantFacture int,
	idRevendeur int FOREIGN KEY REFERENCES REVENDEUR(idRevendeur))

CREATE TABLE LOGICIEL(
	idLogiciel int PRIMARY KEY,
	nomLogiciel varchar(20) NOT NULL,
	versionLogiciel varchar(20),
	dateExpirationLogiciel DATE,
	idFacture int FOREIGN KEY REFERENCES FACTURE(idFacture))

CREATE TABLE MATERIEL(
	idMateriel int PRIMARY KEY,
	numImmotMateriel varchar(20) NOT NULL,
	nomMateriel varchar(20),
	dateExpirationGarantieMateriel DATE,
	repertoireDrivers varchar(30),
	modeleMateriel varchar(20),
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
	telPrestataire varchar(20))
	
CREATE TABLE MAINTENANCE(
	idMaintenance int PRIMARY KEY,
	dateMaintenance DATE NOT NULL,
	objetMaintenance varchar(30),
	descriptionMaintenance varchar(200),
	coutMaintenance int)

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
	telUtilisateur varchar(20))

CREATE TABLE UTILISE(
	idMateriel int FOREIGN KEY REFERENCES MATERIEL(idMateriel),
	idUtilisateur int FOREIGN KEY REFERENCES UTILISATEUR(idUtilisateur),
	PRIMARY KEY(idMateriel,idUtilisateur))
