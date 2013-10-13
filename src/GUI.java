import moteur.*;

public class GUI implements IHM {
	MainFrame window;
	
	public GUI() {
		window = new MainFrame();
	}
	
	public void setGame(SauveQuiPuce pGame) {
		window.game = pGame;
	}
	
	public void addJoueur(Joueur pJoueur) {
		window.joueurs.add(pJoueur);
	}
	
	
	public void playerTracking() {
		window.currentPlayer++;
		if (window.currentPlayer > window.game.nbJoueurs()-1) {
			window.currentPlayer = 0;
		}
	}

	@Override
	public void afficherJeu(SauveQuiPuce arg0) {
		window.update();
	}

}
