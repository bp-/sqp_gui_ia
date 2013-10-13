import java.util.ArrayList;

import moteur.*;

public class Joueur implements moteur.Joueur {
	
	private static GUI gui;
	
	private ArrayList<Carte> playerHand = new ArrayList<Carte>();
	
	public Joueur(GUI pGui){
		gui = pGui;
	}
	
	public Coup prochainCoup(Coup[] coupsPossibles){		
		try {
			Thread.currentThread();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		double choix = Math.random()*coupsPossibles.length;
		Coup decision = coupsPossibles[(int )choix];
		
		if (decision instanceof Prendre) {
			playerHand.add(((Prendre) decision).getCarte());
		}
		else if (decision instanceof Triplette) {
			// pops out3 cards from player's hand
			// and display them
		}
		
		gui.playerTracking(); // increment cur player number

		return decision;
	}
	
	public Carte[] getPlayerHand() {
		return (Carte[]) playerHand.toArray(new Carte[playerHand.size()]);
	}
		

}
