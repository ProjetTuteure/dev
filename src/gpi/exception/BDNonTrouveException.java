package gpi.exception;

public class BDNonTrouveException extends Exception{
	public BDNonTrouveException()
	{
		super("BD non trouv�e");
	}
	
	public BDNonTrouveException(String message)
	{
		super(message);
	}
}
