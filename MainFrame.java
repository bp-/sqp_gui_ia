import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainFrame extends JFrame {
	
	public MainFrame() {
		this.setTitle("Sauve Qui Puce GUI");
		this.setVisible(true);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the layout manager
		setLayout(new BorderLayout());
		
		// Create components
		JButton button = new JButton("Click me !");
		
		// Add components to the content pane
		Container c = getContentPane();
		c.add(button, BorderLayout.SOUTH);
		
		// Handle events
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				// action onclick
			}
		});
		
	}
}
