CREATE TRIGGER supprimerFabricant on FABRICANT
AFTER DELETE
AS BEGIN
	declare @idFabricant int;
	SELECT @idFabricant=idFabricant FROM DELETED
	DELETE MATERIEL WHERE idFabricant=@idFabricant
	DELETE COMPOSANT WHERE idFabricant=@idFabricant
END
