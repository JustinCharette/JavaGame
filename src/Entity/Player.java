package Entity;

import java.awt.Color;
import static Main.CollisionChecker.canMoveHere;
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

public class Player extends entity {

	GamePanel gp;
	KeyHandler kh;

	private int[][] levelData;
	CollisionChecker checker;

	public Player(GamePanel gp, KeyHandler kh) {
		this.gp = gp;
		this.kh = kh;

		playerHitbox = new Rectangle(x, y, gp.TILESIZE, gp.TILESIZE);
		setDefaultValues();
		direction = "idle";
		getPlayerImage();
		checker = new CollisionChecker(gp);

	}

	public void setDefaultValues() {
		x = 100;
		y = 430; // best starting positon
		// y = 400; // for testing purposes

		speed = 4;
	}

	public void loadLevelData(int[][] levelData) {
		this.levelData = levelData;
	}

	public void getPlayerImage() {

		File run1 = new File("./res/player/mario_walk1.gif");
		File run2 = new File("./res/player/mario_walk2.gif");
		File run3 = new File("./res/player/mario_walk3.gif");
		File run1Left = new File("./res/player/mario_walk1Left.gif");
		File run2Left = new File("./res/player/mario_walk2Left.gif");
		File run3Left = new File("./res/player/mario_walk3Left.gif");
		File idleLeft = new File("./res/player/mario_idle_Left.gif");

		try {
			idle = ImageIO.read(getClass().getResourceAsStream("/player/mario_idle.gif"));
			walk1 = ImageIO.read(run1);
			walk2 = ImageIO.read(run2);
			walk3 = ImageIO.read(run3);
			walk1Left = ImageIO.read(run1Left);
			walk2Left = ImageIO.read(run2Left);
			walk3Left = ImageIO.read(run3Left);
			LeftIdle = ImageIO.read(idleLeft);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateHitBox() {
		playerHitbox.x = x;
		playerHitbox.y = y;
	}

	public Rectangle getHitbox() {
		return playerHitbox;
	}

	public void update() {

		if (kh.rightPressed == false && kh.leftPressed == false && kh.upPressed == false && kh.downPressed == false) {
			direction = "idle";
		}

		if (kh.upPressed == true) {

			direction = "up";

		}
		if (kh.downPressed == true) {

			direction = "down";

		}
		if (kh.leftPressed == true) {

			direction = "left";
			rightFacing = false;

		}
		if (kh.rightPressed == true) {

			direction = "right";
			rightFacing = true;

		}

		updateHitBox();
		switch (direction) {

		case "left":
			if (canMoveHere(playerHitbox.x + speed, playerHitbox.y + speed, playerHitbox.width,
					playerHitbox.height, levelData, gp) == true) {
				x -= speed;
			} else {
				x = x + 7;
			}

			break;

		case "right":
			if (canMoveHere(playerHitbox.x + speed, playerHitbox.y + speed, playerHitbox.width,
					playerHitbox.height, levelData, gp) == true) {
				x += speed;
			} else {
				x = x - 7;
			}
			break;

		// down and up will be needed once we have pits in future assignment
		case "down":
			if (canMoveHere(playerHitbox.x + speed, playerHitbox.y + speed, playerHitbox.width,
					playerHitbox.height, levelData, gp) == true) {

			} else {

			}
			break;
		case "up":
			if (canMoveHere(playerHitbox.x + speed, playerHitbox.y + speed, playerHitbox.width,
					playerHitbox.height, levelData, gp) == true) {

			} else {

			}
			break;

		}

		spriteCounter++;
		if (spriteCounter > 10) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 3;
			} else if (spriteNum == 3) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}

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

		case "up":
			if (rightFacing == true) {
				image = idle;

			} else {
				image = LeftIdle;

			}
			break;
		case "down":
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

		}
		g2.drawImage(image, x, y, gp.TILESIZE, gp.TILESIZE, null);
	}

}