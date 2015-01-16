CREATE TRIGGER supprimerComposant on COMPOSANT
INSTEAD OF DELETE
AS BEGIN
	declare @idComposant int;
	SELECT @idComposant=idComposant FROM DELETED
	DELETE COMPOSE WHERE idComposant=@idComposant
	DELETE COMPOSANT WHERE idComposant=@idComposant
END
