package Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{

	
	public Boolean upPressed=false;
	public Boolean downPressed=false ;
	public Boolean leftPressed=false  ;
	public Boolean rightPressed=false;
	
	// gravity variables
	public boolean jump = false;
	private int airSpeed =0;
	private int gravity = 1 ;
	private int jumpSpeed = -2;
	private int fallSpeedAfterCollision = 1;
	private boolean inAir = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
			if(code == KeyEvent.VK_W) {
			upPressed = true;
			
		}
		if(code ==KeyEvent.VK_S) {
			downPressed = true;
			
		}
		if(code ==KeyEvent.VK_A) {
			leftPressed = true;
		
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
			
		}
		if (code ==KeyEvent.VK_SPACE) {
			jump = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code1 = e.getKeyCode();
		
	
		
		if(code1 == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code1 ==KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code1 ==KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code1 == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if (code1 ==KeyEvent.VK_SPACE) {
			jump = false;
		}
	}

}
