package ping;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ChangerCouleurPastille implements Runnable{

	@FXML
	private Circle pastille;
	
	private PingWindows pingWindows;
	
	public ChangerCouleurPastille(Circle pastille,PingWindows pingWindows)
	{
		this.pastille=pastille;
		this.pingWindows=pingWindows;
	}
	
	@Override
	public void run() {
		synchronized(this)
		{
			if(pingWindows.getResultatPing()==true)
			{
				System.out.println("Vert");
				pastille.setFill(Color.GREEN);
			}
			else
			{
				System.out.println("Orange");
				pastille.setFill(Color.ORANGE);
			}
		}
	}
}
