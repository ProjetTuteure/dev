CREATE TRIGGER SuppressionPrestataire on Facture
AFTER DELETE
AS BEGIN 
	declare @idPrestataire int;
	SELECT @idPrestataire=idPrestataire FROM DELETE
	DELETE FROM ESTINTERVENU WHERE idPrestataire=@idPrestataire
END