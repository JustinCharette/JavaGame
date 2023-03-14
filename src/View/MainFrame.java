package View;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class MainFrame {

	public MainFrame()
	{
		
		JLayeredPane pane = new JLayeredPane();
		GamePanel panel = new GamePanel();

        pane.setLayout(null);
        pane.setPreferredSize(new Dimension(760,576));

		JFrame frame  = new JFrame("Mario Bros Overworld 1-1 recreation by Justin Charette and Thi Thanh Van Le");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(new Dimension(760,576));
		frame.setLayout(new FlowLayout());

		pane.add(panel, JLayeredPane.DEFAULT_LAYER);
		pane.add(new UIElements(), JLayeredPane.DRAG_LAYER);
		frame.add(pane);
		
		panel.startGameThread();
		
		frame.pack();
		frame.setLocationRelativeTo(null); // must be called after pack to work
		
		frame.setVisible(true);
		
		
		
	}
	
	
	
	
	
}
