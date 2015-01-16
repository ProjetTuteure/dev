CREATE TRIGGER supprimerFabricant on FABRICANT
INSTEAD OF DELETE
AS BEGIN
	declare @idFabricant int;
	SELECT @idFabricant=idFabricant FROM DELETED
	DELETE MATERIEL WHERE idFabricant=@idFabricant
	DELETE COMPOSANT WHERE idFabricant=@idFabricant
	DELETE FABRICANT WHERE idFabricant=@idFabricant
END
