package gpi.exception;

public class BDNonTrouveException extends Exception{
	public BDNonTrouveException()
	{
		super("BD non trouvée");
	}
	
	public BDNonTrouveException(String message)
	{
		super(message);
	}
}
