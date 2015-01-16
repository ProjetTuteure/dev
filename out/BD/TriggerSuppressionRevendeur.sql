CREATE TRIGGER SuppressionRevendeur on REVENDEUR
INSTEAD OF DELETE
AS BEGIN 
	declare @idRevendeur int;
	select @idRevendeur= idRevendeur FROM deleted;
	DELETE facture where idrevendeur = @idRevendeur;
	DELETE REVENDEUR WHERE idrevendeur = @idRevendeur;
END