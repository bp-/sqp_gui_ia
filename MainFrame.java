import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		
		// Set the layout manager
		setLayout(new BorderLayout());
		
		// Create components
		final JTextArea textArea = new JTextArea();
		JButton button = new JButton("My button");
		
		// Add components to the content pane
		Container c = getContentPane();
		c.add(textArea, BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		
		// Events
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				textArea.append("OK! \n");
			}
		});
		
	}
}
