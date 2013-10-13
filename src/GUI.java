import moteur.*;

public class GUI implements IHM {
	MainFrame mainFrame;
	
	public GUI() {
		mainFrame = new MainFrame();
	}
	
	public void setGame(SauveQuiPuce pGame) {
		mainFrame.game = pGame;
	}
	
	public void addPlayer(Joueur pJoueur) {
		mainFrame.players.add(pJoueur);
	}
	
	public void playerTracking() {
		mainFrame.currentPlayerId++;
		if (mainFrame.currentPlayerId > mainFrame.game.nbJoueurs()-1) {
			mainFrame.currentPlayerId = 0;
		}
	}
	
	public void displayTripletteGala(Carte[] cards) {
		mainFrame.displayTripletteGala(cards);
	}

	@Override
	public void afficherJeu(SauveQuiPuce arg0) {
		mainFrame.update();
	}

}
