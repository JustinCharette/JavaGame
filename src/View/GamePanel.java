package View;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.CollisionChecker;
import Model.KeyHandler;
import Model.Player;
import controller.Controller;

import java.awt.Graphics;
import java.awt.Graphics2D;





/**
 * main game controlelr , creates the loop and manages most inner working of the game
 * @author justi
 * main game controller
 */
public class GamePanel extends JPanel implements Runnable{
	
	
	
	// screen settings constants
	final int ORIGINALTILESIZE = 16;
	final int SCALE =3;     
	protected final int TILESIZE = ORIGINALTILESIZE * SCALE; // 48 X 48 pixels tile
	protected final int MAXSCREENCOLLUMN = 16;
	protected final int MAXSCREENROW = 12;
	protected final int SCREENWIDTH = TILESIZE * MAXSCREENCOLLUMN;  // 760 pixels
	protected final int SCREENHEIGHT = TILESIZE *  MAXSCREENROW; // 576 pixlels
	
	
	
	//game player starting postition
		int playerX = 100;
		int playerY = 100;
		int playerSpeed = 4;
		int fps = 60;
	
		Thread gameThread;
		
		
		
		
		
	 public int getPlayerX() {
			return playerX;
		}


		public void setPlayerX(int playerX) {
			this.playerX = playerX;
		}


		public int getPlayerY() {
			return playerY;
		}


		public void setPlayerY(int playerY) {
			this.playerY = playerY;
		}


		public int getFps() {
			return fps;
		}


		public void setFps(int fps) {
			this.fps = fps;
		}


		public int getORIGINALTILESIZE() {
			return ORIGINALTILESIZE;
		}


		public int getTILESIZE() {
			return TILESIZE;
		}


		public int getMAXSCREENCOLLUMN() {
			return MAXSCREENCOLLUMN;
		}


		public int getMAXSCREENROW() {
			return MAXSCREENROW;
		}


		public int getSCREENWIDTH() {
			return SCREENWIDTH;
		}


		public int getSCREENHEIGHT() {
			return SCREENHEIGHT;
		}

	public TileManager tileM = new TileManager(this);

	        //TileManager tileM;
			KeyHandler keyHandler;
			public CollisionChecker checker;
			Player player1 ;
			
	public Controller controller = new Controller(keyHandler,this,checker,player1);
	Player player = new Player(this, controller.keyH);	

	
	/**
	 * 
	 * coinstructor which sets the some setting for the jpannel
	 */
	public GamePanel() {
		this.setPreferredSize(new Dimension(SCREENWIDTH,SCREENHEIGHT)); // sets the size of the Jpanel
	    this.setDoubleBuffered(true);
		this.setFocusable(true); 
		this.addKeyListener(controller.keyH); 
		this.setFocusable(true);
		this.setBounds(0,0,SCREENWIDTH,SCREENHEIGHT); 
		
		
		
		//player.loadLevelData(tileM.mapTileNum);  // tester for collisions
	}


	/**
	 * starts the thread to be used for the jpannel
	 */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

    /**
     * this is the main game loop for the program , all of it is jsut fluff to get update which updates the current position and repaint which redraws the charecter and lastly will put the thred to sleep until the next 1/60th of a nano second occurs 60  fps
     */
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
	
		
	
	
	
	/**
	 * currently only calls update for the player charecter but eventually will have npcs as well
	 */
	public void update() {
	
		player.update();
		
	}
	
	/**
	 * the part that redraws the charecter and tiles as a graphics object
	 */
	public void paintComponent(Graphics g) {
		
		controller.player = player;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		
		//controller.tileM.draw(g2);
		
		tileM.draw(g2);
		//controller.tileM.draw(g2);
		controller.player.draw(g2);
		//player.draw(g2);

		g2.dispose(); 
		
		
	}
	
}
