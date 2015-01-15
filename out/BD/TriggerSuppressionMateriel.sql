CREATE TRIGGER SuppressionMateriel on MATERIEL
AFTER DELETE
AS BEGIN 
	declare @idMateriel int;
	SELECT @idMateriel=idMateriel FROM deleted
	DELETE FROM UTILISE WHERE idMateriel=@idMateriel
	DELETE FROM ESTMAINTENU WHERE idMateriel=@idMateriel
	DELETE FROM COMPOSE WHERE idMateriel=@idMateriel
END