import moteur.*;
import java.math.*;




public class Joueur implements moteur.Joueur {
	
	private Carte[] mainDuJoueur;
	
	public Coup prochainCoup(Coup[] coupsPossibles){
		
		
		return coupsPossibles[(int)(Math.random() * (coupsPossibles.length+1)) ];
	}
	

}
