import moteur.*;

public class Joueur implements moteur.Joueur {
	
	public static int nbreJoueurs = 0;
	
	private Carte[] mainDuJoueur;
	private int numDuJoueur;
	
	public Joueur() {
		nbreJoueurs++;
	}
	
	public Coup prochainCoup(Coup[] coupsPossibles){
		System.out.println("w00t");
		return coupsPossibles[0];
	}
	

}