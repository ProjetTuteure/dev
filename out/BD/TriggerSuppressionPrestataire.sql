CREATE TRIGGER SuppressionPrestataire on PRESTATAIRE
INSTEAD OF DELETE
AS BEGIN 
	declare @idPrestataire int;
	SELECT @idPrestataire=idPrestataire FROM DELETED
	DELETE FROM ESTINTERVENU WHERE idPrestataire=@idPrestataire
	DELETE FROM PRESTATAIRE WHERE idPrestataire=@idPrestataire
END