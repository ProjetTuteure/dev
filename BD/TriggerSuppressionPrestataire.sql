CREATE TRIGGER SuppressionPrestataire on PRESTATAIRE
INSTEAD OF DELETE
AS BEGIN 
	declare @idPrestataire int;
	DECLARE MyCursor CURSOR FOR SELECT idPrestataire FROM DELETED
	OPEN MyCursor
	FETCH MyCursor INTO @idPrestataire
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE FROM ESTINTERVENU WHERE idPrestataire=@idPrestataire
		FETCH MyCursor INTO @idPrestataire
	END
	DELETE FROM PRESTATAIRE WHERE idPrestataire=@idPrestataire
	CLOSE MyCursor
	DEALLOCATE MyCursor
END