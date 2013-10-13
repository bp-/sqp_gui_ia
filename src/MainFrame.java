import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import moteur.*;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel panelTop, panelMiddle, panelBottom;
	private JButton bouton1;
	private JButton bouton2;
	private JLabel labelStackState;
	private JLabel labelCurrentPlayer;
	
	public SauveQuiPuce game;
	public ArrayList<Joueur> players = new ArrayList<Joueur>();
	public int currentPlayerId = 0;
	
	public MainFrame() {
		init_frame();
		init_panels();
		init_components();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == bouton1){
			panelMiddle.add(new GUI_Carte( new Carte(10, Couleur.BLEU_NUIT) ));
			
			getContentPane().validate();
			repaint();
			System.out.println("Clic !");
		} else {
			panelMiddle.removeAll();			
			getContentPane().validate();
			repaint();
			System.out.println("Clic !");
		}
	
	}
	
	private void init_frame() {
		// General
		this.setTitle("Sauve Qui Puce GUI");
		this.setSize(1280, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.setResizable(false);
		
		// Content Pane
		Panel panel = new Panel();
		this.setContentPane(panel);
				
		// Define layout manager
		this.setLayout(new BorderLayout());
	}
	
	private void init_panels() {
		// Add 3 panels
		panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(1280, 100));
				
		panelMiddle = new JPanel();
		panelMiddle.setLayout(new GridLayout(0, 10));
				
		panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(1280, 200));
		panelBottom.setLayout(new GridLayout(0, 10));
					
		this.getContentPane().add(panelTop, BorderLayout.NORTH);
		this.getContentPane().add(panelMiddle, BorderLayout.CENTER);
		this.getContentPane().add(panelBottom, BorderLayout.SOUTH);
				
		panelTop.setBackground(new Color(0, 0, 0, 0));
		panelMiddle.setBackground( new Color(0, 0, 0, 0) );
		panelBottom.setBackground(new Color(0, 0, 0, 0));
				
	}
	
	private void init_components() {
	    bouton1 = new JButton("Tirer une carte");
		bouton1.addActionListener(this);
		
		bouton2 = new JButton("reset");
		bouton2.addActionListener(this);
		
		labelStackState = new JLabel("Cartes restantes: XX");
		labelCurrentPlayer = new JLabel("Joueur courant num XX");
		
		panelTop.add(labelStackState);
		panelTop.add(labelCurrentPlayer);
		panelTop.add(bouton1);
		panelTop.add(bouton2);
	}
		
	public void update() {
	// Called by the game engine
		displayRow();
		displayCurrentPlayer();
		updateInfos();
		
		getContentPane().validate();
		repaint();
	}
	
	private void displayRow() {
		panelMiddle.removeAll();
		
		Carte[] row = game.getCartesRetournees();
		
		for (int i=0; i<row.length; i++) {
			panelMiddle.add(new GUI_Carte( row[i] ));
		}
	
	}

	private void displayCurrentPlayer() {
		System.out.println("Joueur courant: " + currentPlayerId);
		
		Carte[] cartes = players.get(currentPlayerId).getPlayerHand();
		panelBottom.removeAll();
		
		for (int i=0; i < cartes.length; i++) {
			panelBottom.add(new GUI_Carte( cartes[i] ));
		}
		
	}

	private void updateInfos() {
		labelStackState.setText("Cartes restantes: " + game.taillePioche());
		labelCurrentPlayer.setText("Joueur courant numero " + currentPlayerId);
	}

}
