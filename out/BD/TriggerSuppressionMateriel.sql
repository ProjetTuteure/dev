CREATE TRIGGER SuppressionMateriel on MATERIEL
INSTEAD OF DELETE
AS BEGIN 
	declare @idMateriel int;
	DECLARE @rows int
	DECLARE MyCursor CURSOR FOR SELECT idMateriel FROM DELETED
	OPEN MyCursor
	FETCH MyCursor INTO @idMateriel
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE FROM UTILISE WHERE idMateriel=@idMateriel
		DELETE FROM ESTMAINTENU WHERE idMateriel=@idMateriel
		DELETE FROM COMPOSE WHERE idMateriel=@idMateriel
		DELETE FROM ESTINSTALLE WHERE idMateriel=@idMateriel
		DELETE FROM MATERIEL WHERE idMateriel=@idMateriel
		FETCH MyCursor INTO @idMateriel
	END
	CLOSE MyCursor
	DEALLOCATE MyCursor
END