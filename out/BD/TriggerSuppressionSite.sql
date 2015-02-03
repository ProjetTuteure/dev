CREATE TRIGGER supprimerSite ON SITE
INSTEAD OF DELETE AS
BEGIN
	DECLARE @idSite int
	DECLARE @idMateriel INT
	SELECT @idSite=idSite FROM DELETED
	DECLARE CursorMateriel CURSOR FOR SELECT idMateriel FROM MATERIEL WHERE idSite=@idSite
	OPEN CursorMateriel
	FETCH CursorMateriel INTO @idMateriel
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE FROM MATERIEL WHERE idMateriel=@idMateriel
		FETCH CursorMateriel INTO @idMateriel
	END
	CLOSE CursorMateriel
	DEALLOCATE CursorMateriel
	DELETE FROM SITE WHERE idSite=@idSite
END