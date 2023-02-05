package Entity;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class entity {
	public int x;
	public int y;
	public int speed;
	
	public BufferedImage idle;
	public BufferedImage walk1;
	public BufferedImage walk2;
	public BufferedImage walk3;
	public BufferedImage walk1Left;
	public BufferedImage walk2Left;
	public BufferedImage walk3Left;
	public BufferedImage LeftIdle;
	public String direction;
	public int spriteCounter =0;
	public int spriteNum =1;
	public boolean rightFacing;
	public Rectangle playerHitbox;
	public boolean collisionIsTrue;
	
	

}
