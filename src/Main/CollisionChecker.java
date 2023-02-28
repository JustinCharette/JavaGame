package Main;

import Entity.entity;

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
	
		
		int entityleftCol =  entityLeftWorldX/gp.TILESIZE;
		int entityRightCol = entityRightWolrdX/gp.TILESIZE;
		int entityTopRow   = entityTopWorldY/gp.TILESIZE ;
		int entityBotRow = entityBottomWorldY/gp.TILESIZE ;
		
	
		
		int tileNum1;
		int tileNum2;
		
		switch(entity.direction) {
		

		case "jump":
			entityBotRow = (entityBottomWorldY + entity.speed)/gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityBotRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
			
			
		
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionIsTrue = true;
				entity.onGround = true;
			}
			
			
	    break;
		case "left":
			entityleftCol = (entityLeftWorldX - entity.speed)/gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityleftCol][entityBotRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionIsTrue = true;
			}
			
			break;
		case "right":
			entityRightCol = (entityRightWolrdX + entity.speed)/gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionIsTrue = true;
			}
			
			break;
			
		case "idle"	:
			entityBotRow = (entityBottomWorldY + entity.speed)/gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityBotRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionIsTrue = true;
				entity.onGround = true;
			
			}
			break;
			
	
			
			
		
		
		
		
		}
		
	}

	
}
