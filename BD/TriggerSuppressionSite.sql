CREATE TRIGGER supprimerSite on SITE
AFTER DELETE
AS BEGIN
	declare @idSite int
	SELECT @idSite=idSite FROM DELETED
	DELETE MATERIEL WHERE idSite=@idSite
END