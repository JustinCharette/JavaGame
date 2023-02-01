package Main;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Entity.Player;
import tile.TileManager;

import java.awt.Graphics;
import java.awt.Graphics2D;





public class GamePanel extends JPanel implements Runnable{
	
	// screen settings constants
	final int ORIGINALTILESIZE = 16;
	final int SCALE =3;     
	public final int TILESIZE = ORIGINALTILESIZE * SCALE; // 48 X 48 pixels tile
	public final int MAXSCREENCOLLUMN = 16;
	public final int MAXSCREENROW = 12;
	public final int SCREENWIDTH = TILESIZE * MAXSCREENCOLLUMN;  // 760 pixels
	public final int SCREENHEIGHT = TILESIZE *  MAXSCREENROW; // 576 pixlels
	
	
	
	//game player starting postition
		int playerX = 100;
		int playerY = 100;
		int playerSpeed = 4;
		
		
		int fps = 60;
	
	TileManager tileM = new TileManager(this);
	Thread gameThread; 
	KeyHandler keyHandler = new KeyHandler();
	Player player = new Player(this, keyHandler);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(SCREENWIDTH,SCREENHEIGHT)); // sets the size of the Jpanel
		//this.setBackground(Color.black);
	   this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(keyHandler);   // this id the line causing an error
		this.setFocusable(true);
		this.setBounds(0,0,760,576); //it won't show up in layeredPane without this line
	}


	void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000 / fps; // devides the total time in 1 sec in nanotime by the frame rate selected which is 60 fps
		double nextDrawTime = System.nanoTime() + drawInterval;

		while(gameThread != null) {
			// updates information for the game
			
			update();
			// re draws the game with the new information
			repaint();
			
			
			try {                    // used to make the thread "sleep" until the next draw time to keep the game at 60fps
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000; // since thread .sleep is in milis need to convert to nanotime
				
				if(remainingTime <0) {
					remainingTime =0;
				}
				
				
				Thread.sleep((long)remainingTime);
				
				nextDrawTime += drawInterval;
			}
				catch(Exception e) {
			e.printStackTrace();	
			}
		}
		
	}
	
		
	
	
	
	public void update() {
	
	
		player.update();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		tileM.draw(g2);

		player.draw(g2);

		g2.dispose(); 
		
		
	}
	
}
