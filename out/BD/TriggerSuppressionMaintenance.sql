CREATE TRIGGER supprimerMaintenance on MAINTENANCE
INSTEAD OF DELETE
AS BEGIN 
	declare @idMaintenance int
	SELECT @idMaintenance=idMaintenance FROM DELETED
	DELETE estIntervenu WHERE idMaintenance=@idMaintenance
	DELETE estMaintenu WHERE idMaintenance=@idMaintenance
	DELETE MAINTENANCE WHERE idMaintenance=@idMaintenance
END