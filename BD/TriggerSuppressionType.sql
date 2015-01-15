CREATE TRIGGER supprimerType on TYPE 
AFTER DELETE
AS BEGIN
	declare @idType int;
	SELECT @idType=idType from deleted
	DELETE MATERIEL WHERE idType=@idType
END