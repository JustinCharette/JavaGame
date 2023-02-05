package Main;

import Entity.entity;

public class CollisionChecker {
GamePanel gp;


public CollisionChecker(GamePanel gp) {
	this.gp = gp;
}
	
	public static boolean canMoveHere(int x , int y , int width , int height, int [][] levelData, GamePanel gp) {
	
		if(!isSolid(x,y, levelData,gp))
			if(!isSolid(x+width,y+height, levelData,gp))
				if(!isSolid(x+width,y, levelData,gp))
					if(!isSolid(x,y+height, levelData,gp))
						return true;
		
					
	return false;
					
		
		
		
	}
	
	public static Boolean isSolid(int x , int y , int [] [] levelData, GamePanel gp) {
		if (x < 5 || x >= 750  ) {
			return true;
		}
		
		if(y < 0 || y >= 540 ) {
			return true;
		}
		
		int xIndex = x/gp.TILESIZE;
		int yIndex = y/gp.TILESIZE;
		
		
		//int value = levelData[yIndex][xIndex];
		return false;
		
	}
	
	

	
}
