CREATE TRIGGER [dbo].[supprimerFabricant] on [dbo].[FABRICANT]
INSTEAD OF DELETE
AS BEGIN
	declare @idFabricant int;
	DECLARE @idMateriel int
	DECLARE @idComposant int
	SELECT @idFabricant=idFabricant FROM DELETED

	DECLARE CursorMateriel CURSOR FOR SELECT idMateriel FROM MATERIEL WHERE idFabricant=@idFabricant
	OPEN CursorMateriel
	FETCH CursorMateriel INTO @idMateriel
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE MATERIEL WHERE idMateriel=@idMateriel
		FETCH CursorMateriel INTO @idMateriel
	END
	CLOSE CursorMateriel
	DEALLOCATE CursorMateriel

	DECLARE CursorComposant CURSOR FOR SELECT idComposant FROM COMPOSANT WHERE idFabricant=@idFabricant
	OPEN CursorComposant
	FETCH CursorComposant INTO @idComposant
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE FROM COMPOSANT WHERE idComposant=@idComposant
		FETCH CursorComposant INTO @idComposant
	END
	CLOSE CursorComposant
	DEALLOCATE CursorComposant
	DELETE FABRICANT WHERE idFabricant=@idFabricant
END
