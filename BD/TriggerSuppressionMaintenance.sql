CREATE TRIGGER supprimerMaintenance on MAINTENANCE
INSTEAD OF DELETE
AS BEGIN 
	declare @idMaintenance int;
	SELECT @idMaintenance= idMaintenance FROM DELETED
	DELETE estIntervenu WHERE idMaintenance=@idmaintenance
	DELETE estMaintenu WHERE idMaintenance=@idMaintenance
	DELETE MAINTENACE WHERE idMaintenance=@idMaintenance
END
