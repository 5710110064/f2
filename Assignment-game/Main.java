import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {
  public static void main(String[] args) {
  	JFrame frame = new JFrame("Snacke");
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	frame.setSize(800, 500);
  	frame.getContentPane().setLayout(new BorderLayout());

  	JLabel startlabel = new JLabel("Start Board Game", SwingConstants.CENTER);
  	startlabel.setFont(startlabel.getFont().deriveFont(24.0f));

  	JButton startbutton = new JButton("START");
  	startbutton.setPreferredSize(new Dimension(60, 50));
  	startbutton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			GameController gc = GameController.getInstance();
			new GameFrame();
		}
  	});

  	frame.add(startlabel, BorderLayout.CENTER);
  	frame.add(startbutton, BorderLayout.PAGE_END);
  	frame.setVisible(true);
  	
    //GameController gc = GameController.getInstance();
    /*while (gc.getWinner() == null) {
      gc.takeTurn();
    }
    System.out.println(gc.getWinner() + " is a winner");*/
    //new GameFrame();
  }
}