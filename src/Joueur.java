import java.util.ArrayList;

import moteur.*;

public class Joueur implements moteur.Joueur {

	protected static GUI gui;
	
	protected int playerId;
	protected ArrayList<Carte> playerHand = new ArrayList<Carte>();
	private int decisionIdx;

	
	public Joueur(SauveQuiPuce moteur, Integer num, GUI pGui){
		gui = pGui;
		this.playerId = num;
	}


	public Coup prochainCoup(Coup[] coupsPossibles){
		this.decisionIdx = -1;
		gui.playerTracking(this.playerId);
		
		// request action from GUI
		gui.updatePossibleActions(coupsPossibles);		
		
		while (this.decisionIdx < 0) {
			// wait
			try { Thread.currentThread().sleep(250); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		Coup decision = coupsPossibles[this.decisionIdx];

		// Process decision
		this.updatePlayerHand(decision);
		
		return decision;
	}
	
	public Carte[] getPlayerHand() {
		return (Carte[]) playerHand.toArray(new Carte[playerHand.size()]);
	}
	
	public void setAction(int pDecisionIdx) {
		this.decisionIdx = pDecisionIdx;
	}
	
	protected void updatePlayerHand(Coup coup) {
		
		// Prendre une carte
		if (coup instanceof Prendre) {
			playerHand.add(((Prendre) coup).getCarte());
		}
		
		// Annoncer une Triplette
		else if (coup instanceof Triplette) {
			Carte cards[] = ((Triplette) coup).getCartes();
			
			for (int i=0; i<cards.length; i++) {
				playerHand.remove(cards[i]);
			}
			
			gui.displayTriplette(cards);
		}
	}

}
