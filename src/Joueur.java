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
		else if (decision instanceof Triplette || decision instanceof Gala) {
			// pops out cards from player's hand
			System.out.println("Triplette/Gala !");
			
			Carte cards[] = ((Triplette) decision).getCartes();
			for (int i=0; i<cards.length; i++) {
				playerHand.remove(cards[i]);
			}
			// and display them (todo)
			gui.displayTripletteGala(cards);
		}
		
		gui.playerTracking(); // increment cur player number

		return decision;
	}
	
	public Carte[] getPlayerHand() {
		return (Carte[]) playerHand.toArray(new Carte[playerHand.size()]);
	}
		

}
