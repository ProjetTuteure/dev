CREATE TRIGGER SuppressionRevendeur on REVENDEUR
INSTEAD OF DELETE
AS BEGIN 
	declare @idRevendeur int
	DECLARE @idFacture int
	DECLARE CursorFacture CURSOR FOR SELECT idFacture FROM FACTURE WHERE idRevendeur=@idRevendeur
	OPEN CursorFacture
	FETCH CursorFacture INTO @idFacture
	WHILE @@FETCH_STATUS=0
	BEGIN
		DELETE FROM FACTURE WHERE idFacture=@idFacture
		FETCH CursorFacture INTO @idFacture
	END
	CLOSE CursorFacture
	DEALLOCATE CursorFacture
	DELETE REVENDEUR WHERE idrevendeur = @idRevendeur
END