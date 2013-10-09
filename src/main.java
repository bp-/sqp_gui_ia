import moteur.*;

public class main {

	public static void main(String[] args) {
		
		GUI myGUI = new GUI();
		SauveQuiPuce game = new SauveQuiPuce(myGUI, 10, 10);
		
		// create and add players
		Joueur player1 = new Joueur();
		game.addJoueur(player1);
		
		Joueur player2 = new Joueur();
		game.addJoueur(player2);
		
		game.commencerPartie();

	}

}
