CREATE TRIGGER supprimerMaintenance on MAINTENACE
AFTER DELETE
AS BEGIN 
	declare @idMaintenance int;
	SELECT @idMaintenance= idMaintenance FROM DELETED
	DELETE estIntervenue WHERE idMaintenance=@idmaintenance
	DELETE estMaintenue WHERE idMaintenance=@idMaintenance
END
