package Main;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
public class DriverMain {

	public static void main(String[] args)  {
		JLayeredPane pane = new JLayeredPane();
		GamePanel panel = new GamePanel();
		UIElements labels = new UIElements();

        pane.setLayout(null);
        pane.setPreferredSize(new Dimension(760,576));
 
		JFrame frame  = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Our game");	
		frame.setSize(new Dimension(760,576));
		frame.setLayout(new FlowLayout());

		pane.add(panel, JLayeredPane.DEFAULT_LAYER);
		pane.add(new UIElements(), JLayeredPane.DRAG_LAYER);
		frame.add(pane);
		
		panel.startGameThread();
		
		frame.pack();
		frame.setLocationRelativeTo(null); // must be called after pack to work
		
		frame.setVisible(true);
		panel.startGameThread();

	}

}
