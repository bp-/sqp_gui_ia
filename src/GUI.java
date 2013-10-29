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
	
	public void playerTracking(int id) {
		mainFrame.currentPlayerId = id;
		mainFrame.update();
	}
	
	public void displayTriplette(Carte[] cards) {
		mainFrame.displayTriplette(cards);
	}
	
	public void updatePossibleActions(Coup[] coupsPossibles) {
		mainFrame.updatePossibleActions(coupsPossibles);
	}

	@Override
	public void afficherJeu(SauveQuiPuce arg0) {
		mainFrame.update();
	}
	
	public SauveQuiPuce getGame(){
		return mainFrame.getGame();
	}
}
