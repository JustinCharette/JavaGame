package Model;

import View.GamePanel;
import controller.Controller;

/**
 * @author justi
 * class to check wether the user is hitting an imapassable object
 */
        public class CollisionChecker {
GamePanel gp;

/**
 * coonstructor
 * @param gp the gamepannel 
 */
public CollisionChecker(GamePanel gp) {
	this.gp = gp;
	
}
	
	public void checktile(entity entity) {
		
		 
		int entityRightWolrdX = entity.playerHitbox.x  + entity.playerHitbox.width;
		int entityLeftWorldX = entity.playerHitbox.x ;
		int entityTopWorldY = entity.playerHitbox.y ;
		int entityBottomWorldY =entity.playerHitbox.y +entity.playerHitbox.height ;
	
		
		int entityleftCol =  entityLeftWorldX/gp.getTILESIZE();
		int entityRightCol = entityRightWolrdX/gp.getTILESIZE();
		int entityTopRow   = entityTopWorldY/gp.getTILESIZE() ;
		int entityBotRow = entityBottomWorldY/gp.getTILESIZE() ;
		
	
		
		int tileNum1;
		int tileNum2;
		
		switch(entity.direction) {
		

		case "jump":
			entityBotRow = (entityBottomWorldY + entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.tileM.getMapTileNum()[entityleftCol][entityBotRow];
			tileNum2 = gp.tileM.getMapTileNum()[entityRightCol][entityBotRow];
			
			
		
			
			if(gp.tileM.getTile()[tileNum1].getCollision() == true || gp.tileM.getTile()[tileNum2].getCollision() == true) {
				entity.collisionIsTrue = true;
				entity.onGround = true;
			}
			
			
	    break;
		case "left":
			entityleftCol = (entityLeftWorldX - entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.tileM.getMapTileNum()[entityleftCol][entityTopRow];
			tileNum2 = gp.tileM.getMapTileNum()[entityleftCol][entityBotRow];
			
			if(gp.controller.tileM.getTile()[tileNum1].getCollision() == true || gp.tileM.getTile()[tileNum2].getCollision() == true) {
				entity.collisionIsTrue = true;
			}
			
			break;
		case "right":
			entityRightCol = (entityRightWolrdX + entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.tileM.getMapTileNum()[entityRightCol][entityTopRow];
			tileNum2 =gp.tileM.getMapTileNum()[entityRightCol][entityBotRow];
			
			if(gp.tileM.getTile()[tileNum1].getCollision() == true || gp.tileM.getTile()[tileNum2].getCollision() == true) {
				entity.collisionIsTrue = true;
			}
			
			break;
			
		case "idle"	:
			entityBotRow = (entityBottomWorldY + entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.tileM.getMapTileNum()[entityleftCol][entityBotRow];
			tileNum2 = gp.tileM.getMapTileNum()[entityRightCol][entityBotRow];
			
			if(gp.tileM.getTile()[tileNum1].getCollision() == true || gp.tileM.getTile()[tileNum2].getCollision() == true) {
				entity.collisionIsTrue = true;
				entity.onGround = true;
			
			}
			break;
			
	
			
			
		
		
		
		
		}
		
	}

	
}
