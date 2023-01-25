package Main;
import javax.swing.JFrame;

public class DriverMain {

	public static void main(String[] args)  {
			
		
		JFrame frame  = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Our game");
		GamePanel panel = new GamePanel();
		frame.add(panel);
		panel.startGameThread();
		frame.pack();
		frame.setLocationRelativeTo(null); // must be called after pack to work
		frame.setVisible(true);
		panel.startGameThread();

	}

}
