package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionWindow implements ActionListener {
    JButton okButton = new JButton("OK");

    UIElements ui = new UIElements();
    JFrame newFrame = new JFrame();
    JTextArea ins = new JTextArea("Welcome to Mario, for movement use the up down left right arrows or the w a s d  Keys, space bar for jumping, the goal of the game is to reach the end of the level before time or lives run out");
    JComboBox options;

    public InstructionWindow(){
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setResizable(false);
		newFrame.setSize(420,420);
		newFrame.setLayout(null);
        newFrame.setVisible(true);

        okButton.setBounds(150,300,100,50);
        okButton.setContentAreaFilled( false );
		okButton.addActionListener(this);
        okButton.setFocusable(false);

        ins.setBounds(10, 100, 400, 100);
        ins.setEditable(false);
        ins.setLineWrap(true);
        ins.setWrapStyleWord(true);


        String[] languages = {"English", "French", "Vietnamese"};
        options = new JComboBox(languages);
        options.setBounds(135, 20, 150, 30);
		options.addActionListener(this);
       


		newFrame.add(options);
		newFrame.add(ins);
        newFrame.add(okButton);
        newFrame.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==okButton){
            ui.button4.revalidate();
            ui.button1.revalidate();
            ui.button2.revalidate();
            ui.button3.revalidate();
            ui.button1.repaint();
            ui.button2.repaint();
            ui.button3.repaint();
            ui.button4.repaint();

            System.out.println(ui.button1.getText());
            
            

            newFrame.setVisible(false);
            newFrame.dispose(); 
        }
		
		if(e.getSource()==options){
            System.out.println(ui.button1.getText());
			if(options.getSelectedItem() == "English"){
				ui.button1.setText("Pause");
                ui.button2.setText("Start");
                ui.button3.setText("Exit");
                ui.button4.setText("How to play");
                ins.setText("Welcome to Mario, for movement use the up down left right arrows or the w a s d  Keys, space bar for jumping, the goal of the game is to reach the end of the level before time or lives run out");
                
			}
			else if(options.getSelectedItem() == "French"){
                ui.button1.setText("Pause");
                ui.button2.setText("Départ");
                ui.button3.setText("Sortie");
                ui.button4.setText("Instructionsy");
                ins.setText("bienvenue dans notre jeu mario, pour vous déplacer, appuyez sur les flèches haut, bas, gauche, droite ou sur les touches w, a, s, d pour sauter, appuyez sur la barre d'espace. le but est d'atteindre la fin du niveau sans perdre toutes vos vies en un minimum de temps");
               
			}
			else if(options.getSelectedItem() == "Vietnamese"){
                ui.button1.setText("Tạm Dừng");
                ui.button2.setText("Bắt Đầu");
                ui.button3.setText("Thoát");
                ui.button4.setText("Cách Chơi");  
                ins.setText( "Chào mừng đến với trò chơi Mario của chúng tôi, để di chuyển, hãy nhấn các mũi tên lên, xuống, trái, phải hoặc các phím w, a, s, d, để nhảy, nhấn phím cách. Mục tiêu là đạt đến cuối cấp độ mà không mất tất cả mạng sống của bạn trong khoảng thời gian tối thiểu");
			  
            }

       

		}
		
    }
    
}
