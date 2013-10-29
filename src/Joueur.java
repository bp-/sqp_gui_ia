import java.util.ArrayList;

import moteur.*;

public class Joueur implements moteur.Joueur {

	protected static GUI gui;
	private static int playerCnt = 0;
	
	protected int playerId;
	protected ArrayList<Carte> playerHand = new ArrayList<Carte>();
	private int decisionIdx;

	
	public Joueur(GUI pGui){
		gui = pGui;
		this.playerId = playerCnt;
		playerCnt++;
	}


	public Coup prochainCoup(Coup[] coupsPossibles){
		this.decisionIdx = -1;
		gui.playerTracking(this.playerId);
		
		// request action from GUI
		gui.updatePossibleActions(coupsPossibles);		
		
		while (this.decisionIdx < 0) {
			// wait
			try {
				Thread.currentThread().sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Coup decision = coupsPossibles[this.decisionIdx];

		// Process decision
		if (decision instanceof Prendre) {
			playerHand.add(((Prendre) decision).getCarte());
		}
		else if (decision instanceof Triplette) {
			Carte cards[] = ((Triplette) decision).getCartes();
			
			for (int i=0; i<cards.length; i++) {
				playerHand.remove(cards[i]);
			}
			
			gui.displayTriplette(cards);
		}
		else if (decision instanceof Gala) {
			// FIN !
		}
		
		return decision;
	}
	
	public Carte[] getPlayerHand() {
		return (Carte[]) playerHand.toArray(new Carte[playerHand.size()]);
	}
	
	public void setAction(int pDecisionIdx) {
		this.decisionIdx = pDecisionIdx;
	}

}
