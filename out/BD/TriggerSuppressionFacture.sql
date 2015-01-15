CREATE TRIGGER supprimerFacture on FACTURE 
AFTER DELETE 
AS BEGIN 
	declare @idFacture int
	SELECT @idFacture=idFacture FROM DELETED
	DELETE LOGICIEL WHERE idFacture=@idFacture
	DELETE estIntervenu WHERE idFacture=@idFacture
END
	