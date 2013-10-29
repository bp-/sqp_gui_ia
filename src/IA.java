import java.util.ArrayList;

import moteur.*;


public class IA extends Joueur {
	
	public IA(GUI pGui) {
		super(pGui);
	}

	public Coup prochainCoup(Coup[] coupsPossibles){
		gui.playerTracking(this.playerId);
		Coup tmp=null;
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tmp=verifGala(coupsPossibles);
		if(tmp!=null){
			return tmp; 
		}
		
		
		tmp=verifTriplette(coupsPossibles);
		if(tmp!=null){
			return tmp; 
		}
		
		
		tmp=possibleTriplette(coupsPossibles);
		if(tmp!=null){
			return tmp; 
		}
		
		System.out.println("Retourner");
		return coupsPossibles[0];  //retourner une carte
		
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
		  
		  Carte[] rangee =this.gui.getGame().getCartesRetournees();
		  
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
	
		


