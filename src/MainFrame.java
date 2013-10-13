import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import moteur.*;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel panelInfos, panelCardsRow, panelPlayerHand, panelSpecial;
	private JButton bouton2;
	private JLabel labelStackState;
	private JLabel labelCurrentPlayer;
	private JButton buttonTakeCard;
	
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
		
		if (e.getSource() == buttonTakeCard){
			//players.get(currentPlayerId).

		} else {
			panelCardsRow.removeAll();			
			getContentPane().validate();
			repaint();
			System.out.println("Clic !");
		}
	
	}
	
	private void init_frame() {
		// General
		this.setTitle("Sauve Qui Puce GUI");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.setResizable(false);
		
		// Content Pane
		Panel panel = new Panel();
		this.setContentPane(panel);
				
		// Define layout manager
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	}
	
	private void init_panels() {
		// Add 3 panels
		panelInfos = new JPanel();
				
		panelCardsRow = new JPanel();
		panelCardsRow.setLayout(new GridLayout(0, 10));
		panelCardsRow.setPreferredSize(new Dimension(0, 300));
				
		panelPlayerHand = new JPanel();
		panelPlayerHand.setPreferredSize(new Dimension(0, 300));
		panelPlayerHand.setLayout(new GridLayout(0, 10));
		
		panelSpecial = new JPanel();
		panelSpecial.setPreferredSize(new Dimension(0, 160));
		panelSpecial.setLayout(new GridLayout(0, 10));
					
		this.getContentPane().add(panelInfos);
		this.getContentPane().add(panelCardsRow);
		this.getContentPane().add(panelSpecial);
		this.getContentPane().add(panelPlayerHand);
				
		panelInfos.setBackground(new Color(20, 20, 0, 100));
		panelCardsRow.setBackground( new Color(20, 40, 0, 100) );
		panelPlayerHand.setBackground(new Color(30, 10, 0, 100));
		panelSpecial.setBackground(new Color (10, 70, 0, 100));	
	}
	
	private void init_components() {
		buttonTakeCard = new JButton("Tirer une carte");
		buttonTakeCard.addActionListener(this);
		
		bouton2 = new JButton("reset");
		bouton2.addActionListener(this);
		
		labelStackState = new JLabel("Cartes restantes: XX");
		labelCurrentPlayer = new JLabel("Joueur courant num XX");
		
		panelInfos.add(labelStackState);
		panelInfos.add(labelCurrentPlayer);
		panelInfos.add(buttonTakeCard);
		panelInfos.add(bouton2);
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
	// Displays the current row.
		panelCardsRow.removeAll();
		
		Carte[] cards = game.getCartesRetournees();
		
		for (int i=0; i<cards.length; i++) {
			panelCardsRow.add(new GUI_Carte( cards[i] ));
		}
	
	}

	private void displayCurrentPlayer() {
	// Displays the current player's hand.
		Carte[] cards = players.get(currentPlayerId).getPlayerHand();
		panelPlayerHand.removeAll();
		
		for (int i=0; i < cards.length; i++) {
			panelPlayerHand.add(new GUI_Carte( cards[i] ));
		}
		
	}

	private void updateInfos() {
	// Various informations about the current game
		labelStackState.setText("Cartes restantes: " + game.taillePioche());
		labelCurrentPlayer.setText("Joueur courant numero " + currentPlayerId);
	}

	public void displayTripletteGala(Carte[] cards) {
		panelSpecial.removeAll();
		
		for (int i=0; i < cards.length; i++) {
			panelSpecial.add(new GUI_Carte( cards[i] ));
		}
	}
}
