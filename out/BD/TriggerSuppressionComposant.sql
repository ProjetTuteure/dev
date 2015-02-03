CREATE TRIGGER supprimerComposant on COMPOSANT
INSTEAD OF DELETE
AS BEGIN
	declare @idComposant int;
	DECLARE @Compose INT
	SELECT @idComposant=idComposant FROM DELETED
	DECLARE CursorCompose CURSOR FOR SELECT idComposant FROM Compose where idComposant=@idComposant
	OPEN CursorCompose
	FETCH CursorCompose INTO @Compose
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE COMPOSE WHERE idComposant=@Compose
		FETCH CursorCompose INTO @Compose
	END
	DELETE COMPOSANT WHERE idComposant=@idComposant
	CLOSE CursorCompose
	DEALLOCATE CursorCompose
END
