import moteur.*;
import java.math.*;
import moteur.SauveQuiPuce;



public class Joueur implements moteur.Joueur {
	
	private Carte[] mainDuJoueur;
	public int numeroJoueur;
	private SauveQuiPuce moteur;
	
	public Joueur(SauveQuiPuce pmoteur){
		
		this.moteur=pmoteur;
	}
	
	
	public Coup prochainCoup(Coup[] coupsPossibles){
		
		
		return coupsPossibles[(int)(Math.random() * (coupsPossibles.length+1)) ];
	}
   
	private Carte[] nouvelleMain(Carte[] mainDuJoeur){
		
		
		Carte[] carte2= new Carte[mainDuJoueur.length+1];
	    Coup coup=moteur.getDernierCoup(numeroJoueur);
		
		if (moteur.getDernierCoup(numeroJoueur) instanceof Prendre){
			
			Prendre temp= (Prendre) coup;
			
			
			
			carte2[carte2.length+1]=temp.getCarte();
			
		}
		return carte2;
	}

}
