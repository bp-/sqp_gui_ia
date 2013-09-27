import java.awt.Color;
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
		//g.drawString("Carte: " + carte.getValeur() + " " + carte.getCouleur().toString(), 10, 10);
		
		g.setColor(Color.BLACK);
		g.drawRoundRect(10, 10, 100, 150, 10, 10);
		g.setColor(Color.WHITE);
		g.fillRoundRect(10, 10, 100, 150, 10, 10);
		
	}

}
