CREATE TRIGGER SuppressionRevendeur on REVENDEUR
AFTER DELETE
AS BEGIN 
	declare @idRevendeur int;
	select @idRevendeur= idRevendeur FROM deleted;
	delete from facture where idrevendeur = @idRevendeur;
END