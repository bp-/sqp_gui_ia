import java.awt.Graphics;
import javax.swing.JComponent;
import moteur.Carte;


public class GUI_Carte extends JComponent {
	Carte carte;

	public GUI_Carte(Carte pCarte) {
		super();
		carte = pCarte;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent (g);
		g.drawString("Carte: " + carte.getValeur() + " " + carte.getCouleur().toString(), 50, 60);
	}

}
