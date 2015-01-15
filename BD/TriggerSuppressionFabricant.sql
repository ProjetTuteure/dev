CREATE TRIGGER supprimerFabricant on FABRICANT
AFTER DELETE
AS BEGIN
	declare @idFacture int;
	SELECT @idFacture=idFacture FROM DELETED
	DELETE MATERIEL WHERE idFacture=@idFacture
	DELETE COMPOSANT WHERE idFacture=@idFacture
END
