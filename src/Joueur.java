import moteur.*;
import java.math.*;
import moteur.SauveQuiPuce;

public class Joueur implements moteur.Joueur {
	
	public static int nbreJoueurs = 0;
	
	private Carte[] mainDuJoueur;
<<<<<<< HEAD
	public int numeroJoueur;
	private SauveQuiPuce moteur;
	
	public Joueur(SauveQuiPuce pmoteur){
		
		this.moteur=pmoteur;
	}
	
=======
	private int numDuJoueur;
	
	public Joueur() {
		nbreJoueurs++;
	}
>>>>>>> ed1175f456397befbdaabc4788479c333c771863
	
	public Coup prochainCoup(Coup[] coupsPossibles){
		System.out.println("w00t");
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
