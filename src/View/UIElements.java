package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;


/**
 * main class to manage the ui elements which will be used in a jlayered pane , will be upgreaded to make the features function
 * @author 
 *
 */
public class UIElements extends JPanel  implements ActionListener{ //implements ActionListener
	
	JLabel label1 = new JLabel("<html>life<br>3</html>");
	JLabel label2 = new JLabel("<html>Clock<br>05:00</html>");
	JLabel label3 = new JLabel("<html>Score<br>9999999</html>");
	JSlider volume = new JSlider();
	JButton button1 = new JButton("Pause");
	JButton button2 = new JButton("Start");
	JButton button3 = new JButton("Exit");
	JButton button4 = new JButton("How to play");

	Font f  = new Font("MV Boli",  Font.BOLD, 20);

	/**
	 * constructor which sets all the porperties of the ui elements
	 */
	public UIElements(){
		
		button1.setBounds(580,500,100,50);
		button2.setBounds(480,500,100,50);
		button3.setBounds(680,500,100,50);
		button4.setBounds(300,500,200,50);


		button1.setContentAreaFilled( false );
		button1.setBorder( null );
		button2.setContentAreaFilled( false );
		button2.setBorder( null );
		button3.setContentAreaFilled( false );
		button3.setBorder( null );
		button4.setContentAreaFilled( false );
		button4.setBorder( null );

		button1.setFont(f);
		button2.setFont(f);
		button3.setFont(f);
		button4.setFont(f);
		button1.setForeground(Color.YELLOW);
		button2.setForeground(Color.YELLOW);
		button3.setForeground(Color.YELLOW);
		button4.setForeground(Color.YELLOW);


		button1.addActionListener(this);
        button2.addActionListener(this);
	    button3.addActionListener(this);
		button4.addActionListener(this);

		volume.setOpaque(true);
		volume.setOrientation(SwingConstants.HORIZONTAL);
		volume.setBounds(10,500,200,50);
		
		label1.setOpaque(false);
		label2.setOpaque(false);
		label3.setOpaque(false);
		
		
		
		label1.setBounds(10,5,100,50);
		label2.setBounds(310,5,100,50);
		label3.setBounds(650,5,100,50);

		label1.setFont(f);
		label2.setFont(f);
		label3.setFont(f);
		
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		volume.setFocusable(false);
		

		this.setBackground(new Color(0,0,0,0));
		this.setBounds(0,0,760,576);
		this.setLayout(null);
		this.setOpaque(false);

	
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(volume);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		

	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button1) {
			System.out.println("button1");
		   }
		   else if(e.getSource()==button2) {
			System.out.println("button2");
		   }
		   else if(e.getSource()==button3) {
			System.out.println("button3");
		   }
		   else if(e.getSource()==button4) {
			InstructionWindow iw = new InstructionWindow();
		   }
		

		}
		  
    }

	