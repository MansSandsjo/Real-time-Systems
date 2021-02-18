import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 *  class SimpleGUI:
 *
 * Playground for the swing environment
 */
public class SimpleGUI {

	private String name;
	private String textButton = "testa mig";
	/*
	 * Constructor for the class SimpleGUI
	 */
	public SimpleGUI(String name) {
		this.name = name;
	}

	public void initializeGUI() {
		// TODO C4.E1: Write your GUI code here //
		JFrame frame = new JFrame("simpleGUI");
		frame.pack();
		frame.setVisible(true);
		JButton button = new JButton("en knapp");
		JLabel label = new JLabel(" ");
		JPanel pane = new JPanel();
		pane.add(button, BorderLayout.SOUTH);
		pane.add(label,BorderLayout.NORTH);
		
		frame.setBounds(300,300,300,300);
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		
		
		button.addActionListener(new ActionListener() {
		    public  void actionPerformed(ActionEvent e) {
		    	label.setText("click");
		    	System.out.println(Thread.currentThread().getPriority());
		    }
		  });
		// ActionListener
		// TODO C4.E2: Write your anonymous listener here //
		// TODO C4.E3: Write code to find the event-dispatching thread's priority, here
		// //
	}

	public static void main(String[] args) {
		new SimpleGUI("My GUI").initializeGUI();
	}
}
