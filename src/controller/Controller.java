package controller;

import Model.CollisionChecker;
import Model.KeyHandler;
import Model.Player;
import View.GamePanel;
import View.TileManager;

public class Controller {

    public TileManager tileM;
	public GamePanel gameP;
	public KeyHandler keyH;
	public CollisionChecker collCh;
	public Player player;
	

	
	public Controller(KeyHandler keyH,GamePanel gameP,CollisionChecker collCh,Player player) {
		
		
		
		this.keyH = keyH;
		this.keyH =new KeyHandler();
		this.collCh=collCh;
		this.collCh = new CollisionChecker(gameP);
		this.tileM = new TileManager(gameP);
		this.player=player;
		this.player = new Player(gameP, keyH);
	}
	
	
	
	
}
