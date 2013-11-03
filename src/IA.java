import java.util.ArrayList;

import moteur.*;

public class IA extends Joueur {
		
	public IA(SauveQuiPuce moteur, Integer num, GUI pGui) {
		super(moteur, num, pGui);
	}
	

	public Coup prochainCoup(Coup[] coupsPossibles){
		gui.playerTracking(this.playerId);
		Coup tmp=null;
		
		//try { Thread.currentThread().sleep(1000); }
		//catch (InterruptedException e) { e.printStackTrace(); }
		
		// Cas trivial
		if (coupsPossibles.length == 1) {
			return coupsPossibles[0]; // Retourner
		}
		
		// Si Gala possible, le jouer
		tmp=verifGala(coupsPossibles);
		if(tmp!=null){ updatePlayerHand(tmp); return tmp; }
		
		// Sinon, si Triplette possible, la jouer
		tmp=verifTriplette(coupsPossibles);
		if(tmp!=null){ updatePlayerHand(tmp); return tmp; }
		
		// Sinon, si future Triplette possible, prendre la bonne carte
		tmp=possibleTriplette(coupsPossibles);
		if(tmp!=null){ updatePlayerHand(tmp); return tmp; }
		
		// Il reste deux actions par defaut: Prendre ou Retourner
		if (Math.random() < 0.5) {
			double cnt = Math.random()*(coupsPossibles.length-1) ;
			
			Coup decision = coupsPossibles[1 + (int)cnt];
			updatePlayerHand(decision);
			
			return decision; // Prendre une carte au hasard
		}
		
		return coupsPossibles[0]; // Retourner
	}
		
	// Verifie si Gala possible
	private Coup verifGala (Coup[] coupsPossibles){
			
		for(int i=0; i<coupsPossibles.length; i++){
				
			if(coupsPossibles[i] instanceof Gala){
				return coupsPossibles[i];				}
			}
		
			return null;
	}
	
	// Verifie si Triplette possible
	private Coup verifTriplette (Coup[] coupsPossibles){
			
		for(int i=0; i<coupsPossibles.length; i++){
			if(coupsPossibles[i] instanceof Triplette){
					return coupsPossibles[i];
			}
		}
		
		return null;		
	}
	
	// Verifie si future Triplette possible
	private Coup possibleTriplette(Coup[] coupsPossibles){
		  
		  Carte[] rangee = gui.getGame().getCartesRetournees();
		  
		  // parcours de la main du joueur
		  for( int i=0; i<this.playerHand.size(); i++){
			// cherche les doublons
			for(int j=i+1; j<this.playerHand.size(); j++){
				if(playerHand.get(i).getValeur()  == playerHand.get(j).getValeur()){
					// cherche une potentielle 3eme carte ds la rangee		  
					for(int k=0; k<rangee.length; k++){
						if(playerHand.get(i).getValeur() == rangee[k].getValeur()){
							return coupsAssocie(rangee[k], coupsPossibles);
						}
					}
				}
			  }
		  }
		  return null;
	  }

	// Associe le coup a la carte choisie
	private Coup coupsAssocie(Carte carte, Coup[] coupsPossibles){
		 
		for(int i=0; i<coupsPossibles.length; i++){
			if(coupsPossibles[i] instanceof Prendre){
				if( ((Prendre )coupsPossibles[i]).getCarte()==carte ){
					return coupsPossibles[i];
				}
			}
		}
		 return null;
	 }
	
}
	
		


