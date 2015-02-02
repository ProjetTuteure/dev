CREATE TRIGGER supprimerUtilisateur on UTILISATEUR
INSTEAD OF DELETE
AS BEGIN
	declare @idUtilisateur int
	DELETE UTILISE WHERE idUtilisateur=@idUtilisateur
	DELETE UTILISATEUR WHERE idUtilisateur=@idUtilisateur
END