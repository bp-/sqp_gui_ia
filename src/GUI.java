import moteur.*;

import javax.swing.*;

public class GUI implements IHM {
	MainFrame window;
	
	public GUI() {
		window = new MainFrame();
	}
	
	public void setGame(SauveQuiPuce pGame) {
		window.game = pGame;
	}

	@Override
	public void afficherJeu(SauveQuiPuce arg0) {
		window.update();
	}

}
