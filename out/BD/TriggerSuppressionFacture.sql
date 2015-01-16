CREATE TRIGGER supprimerFacture on FACTURE 
INSTEAD OF DELETE 
AS BEGIN 
	declare @idFacture int
	SELECT @idFacture=idFacture FROM DELETED
	DELETE LOGICIEL WHERE idFacture=@idFacture
	DELETE estIntervenu WHERE idFacture=@idFacture
	DELETE FACTURE WHERE idFacture=@idFacture
END
	