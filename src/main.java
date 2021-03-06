import moteur.*;

public class main {

	public static void main(String[] args) {
		
		GUI myGUI = new GUI();
		SauveQuiPuce game = new SauveQuiPuce(myGUI, 10, 10);
		myGUI.setGame(game);

		// create and add players
		Joueur player1 = new IA(game, 0, myGUI);
		game.addJoueur(player1);
		myGUI.addPlayer(player1);
		
		Joueur player2 = new IA(game, 1, myGUI);
		game.addJoueur(player2);
		myGUI.addPlayer(player2);
		
		Joueur player3 = new IA(game, 2, myGUI);
		game.addJoueur(player3);
		myGUI.addPlayer(player3);
		
		game.commencerPartie();

	}

}
