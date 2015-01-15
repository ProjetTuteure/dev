CREATE TRIGGER supprimer on COMPOSANT
AFTER DELETE
AS BEGIN
	declare @idComposant int;
	SELECT @idComposant=idComposant FROM DELETED
	DELETE COMPOSE WHERE idComposant=@idComposant
END
