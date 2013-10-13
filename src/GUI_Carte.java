import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

import moteur.*;


public class GUI_Carte extends JComponent {
	private Carte carte;
	private static Color[] colors = {
		new Color(255, 58, 58, 255),
		new Color(255, 225, 110, 255),
		new Color(246, 249, 57, 255),
		new Color(94, 255, 58, 255),
		new Color(58, 248, 255, 255),
		new Color(58, 147, 255, 255),
		new Color(239, 239, 239, 255),
		new Color(255, 255, 255, 255),
		new Color(210, 0, 252, 255),
		new Color(219, 0, 40, 255)
	};

	public GUI_Carte(Carte pCarte) {
		super();
		carte = pCarte;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent (g);
		//g.drawString("Carte: " + carte.getValeur() + " " + carte.getCouleur().toString(), 10, 10);
		
		g.setColor(Color.BLACK);
		g.drawRoundRect(10, 10, 67, 100, 20, 20);
		//drawRoundRect(x, y, width, height, arcWidth, arcHeight);
		
		g.setColor( colors[ carte.getCouleur().ordinal() ] );
		g.fillRoundRect(10, 10, 67, 100, 20, 20);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		g.drawString("" + carte.getValeur(),15, 35);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		g.drawString("" + carte.getValeur(),13, 33);
	}
	
	/* Colors:
	 ========= 
	 	ROUGE Color(255, 58, 58, 0)
		ORANGE Color(255, 225, 110, 0)
		JAUNE Color(246, 249, 57, 0)
		VERT Color(94, 255, 58, 0)
		BLEU_CIEL Color(58, 248, 255, 0)
		BLEU_NUIT Color(58, 147, 255, 0)
		GRIS Color(239, 239, 239, 0)
		BLANC Color(255, 255, 255, 0)
		VIOLET Color(210, 0, 252, 0)
		MARRON Color(219, 0, 40, 0)
	 */

}
