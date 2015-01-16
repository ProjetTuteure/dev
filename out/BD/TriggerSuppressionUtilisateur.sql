CREATE TRIGGER supprimerUtilisateur on UTILISATEUR
INSTEAD OF DELETE
AS BEGIN
	declare @idUtilisateur int
	SELECT @idUtilisateur=idUtilisateur FROM UTILISATEUR
	DELETE UTILISE WHERE idUtilisateur=@idUtilisateur
	DELETE UTILISATEUR WHERE idUtilisateur=@idUtilisateur
END