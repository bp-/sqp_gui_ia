import moteur.*;
import java.math.*;


public class Joueur implements moteur.Joueur {
	
	public static int nbreJoueurs = 0;
	
	private Carte[] mainDuJoueur;
	private int numDuJoueur;
	
	public Joueur() {
		nbreJoueurs++;
	}
	
	public Coup prochainCoup(Coup[] coupsPossibles){
<<<<<<< HEAD
		System.out.println("w00t");
		return coupsPossibles[0];
=======
		
		
		return coupsPossibles[(int)(Math.random() * (coupsPossibles.length+1)) ];
>>>>>>> 063d60a9dfef78132f2d952351cfbffeb8e8e5a5
	}
	

}
