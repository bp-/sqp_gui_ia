import java.util.ArrayList;

import moteur.*;

public class Joueur implements moteur.Joueur {
	
	private static GUI gui;
	
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
	
	public Joueur(GUI pGui){
		gui = pGui;
	}
	
	public Coup prochainCoup(Coup[] coupsPossibles){		
		try {
			Thread.currentThread();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		double choix = Math.random()*coupsPossibles.length;
		Coup decision = coupsPossibles[(int )choix];
		
		if (decision instanceof Prendre) {
			mainDuJoueur.add(((Prendre) decision).getCarte());
		}
		
		gui.playerTracking();
		
		System.out.println(decision.getClass());

		return decision;
	}
	
	public Carte[] getMainDuJoueur() {
		return (Carte[]) mainDuJoueur.toArray(new Carte[mainDuJoueur.size()]);
	}
		

}
