CREATE TRIGGER supprimerType on TYPE 
INSTEAD OF DELETE
AS BEGIN
	declare @idType int;
	DECLARE @idMateriel int
	SELECT @idType=idType FROM DELETED
	DECLARE CursorMateriel CURSOR FOR SELECT idMateriel FROM Materiel WHERE idType=@idType
	OPEN CursorMateriel
	FETCH CursorMateriel INTO @idMateriel
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE MATERIEL WHERE idMateriel=@idMateriel
		FETCH CursorMateriel INTO @idMateriel
	END
	DELETE TYPE WHERE idType=@idType
	CLOSE CursorMateriel
	DEALLOCATE CursorMateriel
END