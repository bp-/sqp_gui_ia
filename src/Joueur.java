import moteur.*;



public class Joueur implements moteur.Joueur {
	
	private Carte[] mainDuJoueur;
	
	public Coup prochainCoup(Coup[] coupsPossibles){
		
		return coupsPossibles[0];
	}
	

}
