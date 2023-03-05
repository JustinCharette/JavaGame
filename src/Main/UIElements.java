package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class UIElements extends JPanel implements ActionListener{

	JLabel label1 = new JLabel("life");
	JLabel label2 = new JLabel("clock");
	JLabel label3 = new JLabel("Score");
	JSlider volume = new JSlider();
	JButton button1 = new JButton("Pause");
	JButton button2 = new JButton("Start");
	JButton button3 = new JButton("Exit");
	JButton button4 = new JButton("How to play");

	Font f  = new Font(Font.SANS_SERIF,  Font.BOLD, 20);

	public UIElements(){
	
		button1.setBounds(580,500,100,50);
		button2.setBounds(480,500,100,50);
		button3.setBounds(680,500,100,50);
		button4.setBounds(10,500,100,50);

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
		button1.setForeground(Color.WHITE);
		button2.setForeground(Color.WHITE);
		button3.setForeground(Color.WHITE);
		button4.setForeground(Color.WHITE);


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
			System.out.println("button4");
		   }
		  
    }
	

   
}
