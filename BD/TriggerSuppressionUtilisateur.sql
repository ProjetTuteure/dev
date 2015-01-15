CREATE TRIGGER supprimerUtilisateur on UTILISATEUR
AFTER DELETE
AS BEGIN
	declare @idUtilisateur int
	SELECT @idUtilisateur=idUtilisateur FROM UTILISATEUR
	DELETE UTILISE WHERE idUtilisateur=@idUtilisateur
END