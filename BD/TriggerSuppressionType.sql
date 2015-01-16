CREATE TRIGGER supprimerType on TYPE 
INSTEAD OF DELETE
AS BEGIN
	declare @idType int;
	SELECT @idType=idType from deleted
	DELETE MATERIEL WHERE idType=@idType
	DELETE TYPE WHERE idType=@idType
END