import java.awt.*;

import javax.swing.*;

import moteur.Carte;
import moteur.Couleur;

public class MainFrame extends JFrame {
	
	private GUI_Carte uneCarte;
	private JPanel panelTop, panelMiddle, panelBottom;
	
	public MainFrame() {
		// General
		this.setTitle("Sauve Qui Puce GUI");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		
		// Content Pane
		Panel panel = new Panel();
		this.setContentPane(panel);
		
		// Define layout manager
		this.setLayout(new BorderLayout());
		
		// Add 3 panels
		panelTop = new JPanel(); panelTop.setPreferredSize(new Dimension(800, 100));
		panelMiddle = new JPanel();
		panelBottom = new JPanel(); panelBottom.setPreferredSize(new Dimension(800, 100));
		
		panelMiddle.setLayout(new GridLayout(2, 5));
		
		this.getContentPane().add(panelTop, BorderLayout.NORTH);
		this.getContentPane().add(panelMiddle, BorderLayout.CENTER);
		this.getContentPane().add(panelBottom, BorderLayout.SOUTH);
		
		panelTop.setBackground(Color.black);
		panelMiddle.setBackground( new Color(255, 255, 0, 70) );
		panelBottom.setBackground(Color.red);
		
		// Add component
		panelMiddle.add(new GUI_Carte( new Carte(1, Couleur.BLEU_NUIT) ));
		panelMiddle.add(new GUI_Carte( new Carte(3, Couleur.JAUNE) ));
		panelMiddle.add(new GUI_Carte( new Carte(3, Couleur.VERT) ));
		panelMiddle.add(new GUI_Carte( new Carte(7, Couleur.VIOLET) ));
		
		// Display
		this.setVisible(true);
	}
}
