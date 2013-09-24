import moteur.SauveQuiPuce;
import moteur.Carte;
import moteur.Couleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class tests {

	public static void main(String[] args) {
		
		//SauveQuiPuce game = new SauveQuiPuce();
		
/*		SwingUtilities.invokeLater(new Runnable() {
			public void run() {		
				// Main window
				JFrame frame = new MainFrame("Sauve Qui Puce GUI");
				// Set size
				frame.setSize(800, 600);
				// Make visible
				frame.setVisible(true);
				// make red cross active
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});*/
		
		Carte maCarte = new Carte(20, Couleur.BLEU_NUIT);
		
		System.out.println("maCarte a pour couleur: " + maCarte.getCouleur());

	}

}
