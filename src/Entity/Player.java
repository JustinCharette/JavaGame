package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Graphics2D;
import Main.GamePanel;
import Main.KeyHandler;

public class Player extends entity {

	GamePanel gp;
	KeyHandler kh;
	
	public Player(GamePanel gp , KeyHandler kh) {
		this.gp = gp;
		this.kh = kh;
		setDefaultValues();
		direction = "idle";
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
	}
	
	public void getPlayerImage() {
		
		
		File run1 = new File("./src/mario_walk1.gif");
		File run2 = new File("./src/mario_walk2.gif");
		File run3 = new File("./src/mario_walk3.gif");
		
		try {
			idle = ImageIO.read(getClass().getResourceAsStream("/player/mario_idle.gif"));
		    walk1 = ImageIO.read(run1);
			walk2 =ImageIO.read(run2);
			walk3 = ImageIO.read(run3);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void update() {
		if(kh.upPressed == true) {
			y-=speed;
			direction = "idle";
			
		}
		if(kh.downPressed== true) {
			y+=speed;
			direction = "idle";
			
		}
		if(kh.leftPressed== true) {
	       x-=speed;
	       direction = "idle";
	       
}
		if(kh.rightPressed== true) {
			x+=speed;
			direction = "right";
			
}
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum ==1) {
				spriteNum =2;
			}
			else if(spriteNum ==2) {
				spriteNum =3;
			}
			else if(spriteNum ==3) {
				spriteNum =1;
			}
			spriteCounter =0;
		}
	}
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x,y,gp.TILESIZE,gp.TILESIZE);
		BufferedImage image = null;
		
		switch(direction) {
		case "idle":
			image = idle;
			break;

			
		case "right":
			if(spriteNum ==1) {
			image = walk1;
			}
			if(spriteNum ==2) {
				image = walk2;
				}
			if(spriteNum ==3) {
				image = walk3;
				}
			
         break;
		
		}
		g2.drawImage(image,x,y,gp.TILESIZE,gp.TILESIZE,null);
	}
	
	
}