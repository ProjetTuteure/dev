CREATE TRIGGER supprimerMaintenance on MAINTENANCE
AFTER DELETE
AS BEGIN 
	declare @idMaintenance int;
	SELECT @idMaintenance= idMaintenance FROM DELETED
	DELETE estIntervenu WHERE idMaintenance=@idmaintenance
	DELETE estMaintenu WHERE idMaintenance=@idMaintenance
END
