import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import moteur.Carte;
import moteur.Couleur;

public class MainFrame extends JFrame implements ActionListener {
	
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
		
		panelMiddle.setLayout(new GridLayout(0, 6));
		
		this.getContentPane().add(panelTop, BorderLayout.NORTH);
		this.getContentPane().add(panelMiddle, BorderLayout.CENTER);
		this.getContentPane().add(panelBottom, BorderLayout.SOUTH);
		
		panelTop.setBackground(new Color(0, 0, 0, 0));
		panelMiddle.setBackground( new Color(0, 0, 0, 0) );
		panelBottom.setBackground(new Color(0, 0, 0, 0));
		
		JButton bouton = new JButton("Cliquez ici !");
		bouton.addActionListener(this);
		
		// Add component
		panelMiddle.add(new GUI_Carte( new Carte(1, Couleur.BLEU_NUIT) ));
		panelMiddle.add(new GUI_Carte( new Carte(3, Couleur.JAUNE) ));
		panelMiddle.add(new GUI_Carte( new Carte(3, Couleur.VERT) ));
		panelMiddle.add(new GUI_Carte( new Carte(7, Couleur.VIOLET) ));
		
		panelTop.add(bouton);
		
		// Display
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		panelMiddle.removeAll();
		panelMiddle.add(new GUI_Carte( new Carte(10, Couleur.BLEU_NUIT) ));
		
		getContentPane().validate();
		repaint();
		System.out.println("Clic !");
	}
	
	public void update() {
		// Things to do:
		//	- 
	}
}
