import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import moteur.*;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Panel panelGame = new Panel();
	Panel panelInit = new Panel();
	
	private JPanel content = new JPanel();
	private CardLayout contentLayout = new CardLayout();
	
	private JPanel panelInfos, panelCardsRow, panelPlayerHand, panelSpecial;
	private JLabel labelStackState;
	private JLabel labelCurrentPlayer;
	private JComboBox selectAction;
	private JButton buttonValidate;
	private JButton btn;
	
	public SauveQuiPuce game;
	public ArrayList<Joueur> players = new ArrayList<Joueur>();
	public int currentPlayerId = 0;
	
	
	public MainFrame() {
		init_frame();
		
		init_panelInit_content();
		
		init_panelGame_panels();
		init_panelGame_components();
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == buttonValidate) {
			players.get(currentPlayerId).setAction( selectAction.getSelectedIndex() );
		}
		else if (e.getSource() == btn) {
			contentLayout.next(content);
		}
		
		this.update();
	
	}
	
	/*
	 * Initialisation methods
	 */
	public SauveQuiPuce getGame(){
		return game;
	}
	
	private void init_frame() {
		// General
		this.setTitle("Sauve Qui Puce GUI - BETA");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.setResizable(false);
				
		// Define layout managers
		panelGame.setLayout(new BoxLayout(panelGame, BoxLayout.PAGE_AXIS));
		content.setLayout(contentLayout);
		
		content.add(panelGame);
		content.add(panelInit);
		
		// Content Pane
		//this.setContentPane(content);
		this.getContentPane().add(content, BorderLayout.CENTER);
	}
	
	private void init_panelInit_content() {	
		btn = new JButton("Start game !");
		panelInit.add(btn);
		btn.addActionListener(this);
	}
	
	private void init_panelGame_panels() {
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
					
		panelGame.add(panelInfos);
		panelGame.add(panelCardsRow);
		panelGame.add(panelSpecial);
		panelGame.add(panelPlayerHand);
				
		panelInfos.setBackground(new Color(20, 20, 0, 100));
		panelCardsRow.setBackground( new Color(20, 40, 0, 100) );
		panelPlayerHand.setBackground(new Color(30, 10, 0, 100));
		panelSpecial.setBackground(new Color (10, 70, 0, 100));	
	}
	
	private void init_panelGame_components() {
		selectAction = new JComboBox();
		
		buttonValidate = new JButton("Valider");
		buttonValidate.addActionListener(this);
		
		labelStackState = new JLabel("Cartes restantes: XX");
		labelCurrentPlayer = new JLabel("Joueur courant num XX");
		
		panelInfos.add(labelStackState);
		panelInfos.add(selectAction);
		panelInfos.add(buttonValidate);
		panelInfos.add(labelCurrentPlayer);
	}
	
	/*
	 * Display refresh methods
	 */
	public void update() {
	// Called by the game engine
		displayRow();
		displayCurrentPlayer();
		updateInfos();
		
		this.getContentPane().validate();
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

	public void displayTriplette(Carte[] cards) {
		panelSpecial.removeAll();
		
		for (int i=0; i < cards.length; i++) {
			panelSpecial.add(new GUI_Carte( cards[i] ));
		}
	}

	public void updatePossibleActions(Coup[] coupsPossibles) {
		this.selectAction.removeAllItems();
		
		for (int i=0; i<coupsPossibles.length; i++) {
			
			if ( coupsPossibles[i] instanceof Retourner ) {
				this.selectAction.addItem("Retourner une carte");
			}
			else if ( coupsPossibles[i] instanceof Prendre ) {
				this.selectAction.addItem("Prendre " + ((Prendre )coupsPossibles[i]).getCarte().toString() );
			}
			else {
				this.selectAction.addItem( coupsPossibles[i].getClass().toString() );
			}
			
		}
		
		this.update();
	}

}
