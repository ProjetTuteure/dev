CREATE TRIGGER supprimerFacture on FACTURE 
AFTER DELETE 
AS BEGIN 
	declare @idFacture
	SELECT @idFacture=idFacture FROM DELETED
	DELETE LOGICIEL WHERE idFacture=@idFacture
	DELETE estIntervenu WHERE idFacture=@idFacture
END
	