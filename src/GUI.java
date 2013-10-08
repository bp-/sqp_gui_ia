import moteur.*;
import javax.swing.*;

public class GUI implements IHM {
	MainFrame window;
	
	public GUI() {
		window = new MainFrame();
	}

	@Override
	public void afficherJeu(SauveQuiPuce arg0) {
		window.update();
	}

}
