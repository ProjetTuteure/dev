CREATE TRIGGER SuppressionMateriel on MATERIEL
INSTEAD OF DELETE
AS BEGIN 
	declare @idMateriel int;
	SELECT @idMateriel=idMateriel FROM deleted
	DELETE FROM UTILISE WHERE idMateriel=@idMateriel
	DELETE FROM ESTMAINTENU WHERE idMateriel=@idMateriel
	DELETE FROM COMPOSE WHERE idMateriel=@idMateriel
	DELETE FROM MATERIEL WHERE idMateriel=@idMateriel
END