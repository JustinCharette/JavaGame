package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Main.CollisionChecker;
import Main.GamePanel;
import Main.KeyHandler;

/**
 * @author justin and vivian player class will be used to control and manage the
 *         playable charecter
 *
 */
public class Player extends entity {

	GamePanel gp;
	KeyHandler kh;

	private int[][] levelData;
	CollisionChecker checker;

	/**
	 * contructor which sets nessasary values sets default position and sets the
	 * hitbox for the charecter
	 * 
	 * @param gp
	 * @param kh
	 */
	public Player(GamePanel gp, KeyHandler kh) {
		this.gp = gp;
		this.kh = kh;

		playerHitbox = new Rectangle(x, y, gp.TILESIZE, gp.TILESIZE);
		setDefaultValues();
		direction = "idle";
		getPlayerImage();
		checker = new CollisionChecker(gp);

	}

	/**
	 * initializes starting position and player speed
	 */
	public void setDefaultValues() {
		x = 100;
		y = 420;
		speed = 4;
	}

	/**
	 * @param levelData will be used later to get unit colision when the screen will
	 *                  be moving , loads in the map in the player class so that the
	 *                  player may acess the array that holds the sprites
	 */
	public void loadLevelData(int[][] levelData) {
		this.levelData = levelData;
	}

	/**
	 * creates all images that will be used to render the charecter , each action
	 * has 3 different images that will be swapped one after the other to create the
	 * illusion of mounvment
	 */
	public void getPlayerImage() {
//		File idleRight = new File("src/images/player/mario_idle.gif");
//		File run1 = new File("src/images/player/mario_walk1.gif");
//		File run2 = new File("src/images/player/mario_walk2.gif");
//		File run3 = new File("src/images/player/mario_walk3.gif");
//		File run1Left = new File("src/images/player/mario_walk1Left.gif");
//		File run2Left = new File("src/images/player/mario_walk2Left.gif");
//		File run3Left = new File("src/images/player/mario_walk3Left.gif");
//		File idleLeft = new File("src/images/player/mario_idle_Left.gif");
//		File jump1 = new File("src/images/player/mario_jump1_right.gif");
//		File jump2 = new File("src/images/player/mario_jump2_right.gif");

		try {
			
//			
//			idle = ImageIO.read(idleRight);
//			walk1 = ImageIO.read(run1);
//			walk2 = ImageIO.read(run2);
//			walk3 = ImageIO.read(run3);
//			walk1Left = ImageIO.read(run1Left);
//			walk2Left = ImageIO.read(run2Left);
//			walk3Left = ImageIO.read(run3Left);
//			LeftIdle = ImageIO.read(idleLeft);
//			jump1Right = ImageIO.read(jump1);
//			jump2Right = ImageIO.read(jump2);
			
//			idle = ImageIO.read(getClass().getResourceAsStream("/mario_idle.gif"));
//			walk1 = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_walk1.gif"));
//			walk2 = ImageIO.read(getClass().getResourceAsStream("sprite/player/mario_walk2.gif"));
//			walk3 = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_walk3.gif"));
//			walk1Left = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_walk1Left.gif"));
//			walk2Left = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_walk2Left.gif"));
//			walk3Left = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_walk3Left.gif"));
//			LeftIdle = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_idle_Left.gif"));
//			jump1Right = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_jump1_right.gif"));
//			jump2Right = ImageIO.read(getClass().getResourceAsStream("sprites/player/mario_jump2_right.gif"));
			
//			
			idle = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_idle.gif"));
			walk1 = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk1.gif"));
			walk2 = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk2.gif"));
			walk3 = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk3.gif"));
			walk1Left = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk1Left.gif"));
			walk2Left = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk2Left.gif"));
			walk3Left = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk3Left.gif"));
			LeftIdle = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_idle_Left.gif"));
			jump1Right = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_jump1_right.gif"));
			jump2Right = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_jump2_right.gif"));
			
			
			
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * used to redraw the hitbox when the charecter moves
	 */
	public void updateHitBox() {
		playerHitbox.x = x;
		playerHitbox.y = y;
	}

	/**
	 * getter for hitbox
	 * 
	 * @return the hitbox whiich is a rectangle
	 */
	public Rectangle getHitbox() {
		return playerHitbox;
	}

	/**
	 * this is the maion helper method of the class , it checks wether the user has
	 * pressed a key and will update the charecter position if the user is not
	 * hitting a wall
	 */
	public void update() {
		if (onGround == true) {
			kh.inAir = false;
		}

		if (kh.rightPressed == false && kh.leftPressed == false && kh.inAir == false) { // maybe shoudl be kh.inAir
			direction = "idle";

			if (collisionIsTrue == false && onGround == false) {
				y += kh.airSpeed;
				kh.airSpeed += kh.gravity;

			} else if (collisionIsTrue == true && onGround == true) {
			}

		}

		if (kh.leftPressed == true && kh.inAir == false) {

			direction = "left";
			rightFacing = false;

		}
		if (kh.rightPressed == true && kh.inAir == false) {

			direction = "right";
			rightFacing = true;

		}

		if (kh.jump == true) {
			jump();
			direction = "jump";
			kh.inAir = true;

		}

		updateHitBox();
		collisionIsTrue = false;

		checker.checktile(this);

		switch (direction) {

		case "left":
			if (collisionIsTrue == false && x >= 5) {

				x -= speed;
			} else {

			}

			break;

		case "right":
			if (collisionIsTrue == false && x < 710) {

				x += speed;
			} else {

			}
			break;

		case "jump":

			if (y + kh.airSpeed >= 430) {
				y = 430;
				checker.checktile(this);
				break;
			}

			y += kh.airSpeed;
			kh.airSpeed += kh.gravity;
			onGround = false;

			if (kh.rightPressed == true) {
				x += speed;
			} else if (kh.leftPressed == true) {
				x -= speed;
			}

			checker.checktile(this);

			break;

		}

		spriteCounter++;
		if (spriteCounter > 10) {
			if (spriteNum == 1 && kh.inAir == false) {
				spriteNum = 2;
			} else if (spriteNum == 2 && kh.inAir == false) {
				spriteNum = 3;
			} else if (spriteNum == 3 && kh.inAir == false) {
				spriteNum = 1;
			}
			if (kh.inAir == true) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 3;
				} else if (spriteNum == 3) {
					spriteNum = 1;
				}
			}
			spriteCounter = 0;
		}
	}

	private void jump() {
		if (kh.inAir == true) {
			return;
		}

		kh.airSpeed = kh.jumpSpeed;

	}

	/**
	 * second main helper method that will be called in update , this handles the
	 * mechanism of which sprite gets desplayed when
	 * 
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "idle":
			if (rightFacing == true) {
				image = idle;

			} else {
				image = LeftIdle;

			}
			break;

		case "left":
			if (kh.leftPressed == false) {
				image = idle;

			}
			if (spriteNum == 1) {
				image = walk1Left;

			}
			if (spriteNum == 2) {
				image = walk2Left;

			}
			if (spriteNum == 3) {
				image = walk3Left;

			}
			break;

		case "right":
			if (kh.rightPressed == false) {
				image = idle;

			}
			if (spriteNum == 1) {
				image = walk1;

			}
			if (spriteNum == 2) {
				image = walk2;

			}
			if (spriteNum == 3) {
				image = walk3;

			}
			break;

		case "jump":
			if (spriteNum == 1) {
				image = jump1Right;
			}
			if (spriteNum == 2) {
				image = jump2Right;
			}
			if (spriteNum == 3) {
				image = jump2Right;
			}

		}
		g2.drawImage(image, x, y, gp.TILESIZE, gp.TILESIZE, null);
	}

}