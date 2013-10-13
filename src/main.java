import moteur.*;

public class main {

	public static void main(String[] args) {
		
		GUI myGUI = new GUI();
		SauveQuiPuce game = new SauveQuiPuce(myGUI, 10, 10);
		myGUI.setGame(game);

		// create and add players
		Joueur player1 = new Joueur(myGUI);
		game.addJoueur(player1);
		myGUI.addJoueur(player1);
		
		Joueur player2 = new Joueur(myGUI);
		game.addJoueur(player2);
		myGUI.addJoueur(player2);
		
		game.commencerPartie();

	}

}
