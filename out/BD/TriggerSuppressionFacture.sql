CREATE TRIGGER supprimerFacture on FACTURE 
INSTEAD OF DELETE 
AS BEGIN 
	declare @idFacture int
	DECLARE @idLogiciel int
	DECLARE @idMateriel int
	DECLARE @intervenu int
	SELECT @idFacture=idFacture FROM DELETED

	DECLARE CursorLogiciel CURSOR FOR SELECT idLogiciel FROM LOGICIEL WHERE idFacture=@idFacture
	OPEN CursorLogiciel
	FETCH CursorLogiciel INTO @idLogiciel
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE LOGICIEL WHERE idLogiciel=@idLogiciel
		FETCH CursorLogiciel INTO @idLogiciel
	END
	CLOSE CursorLogiciel
	DEALLOCATE CursorLogiciel

	DECLARE CursorMateriel CURSOR FOR SELECT idMateriel FROM MATERIEL WHERE idFacture=@idFacture
	OPEN CursorMateriel
	FETCH CursorMateriel INTO @idMateriel
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE MATERIEL WHERE idMateriel=@idMateriel
		FETCH CursorMateriel INTO @idMateriel
	END
	CLOSE CursorMateriel
	DEALLOCATE CursorMateriel

	DELETE estIntervenu WHERE idFacture=@idFacture
	DELETE FACTURE WHERE idFacture=@idFacture
END
	