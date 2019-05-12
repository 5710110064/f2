import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//import javax.swing.JTextField;

public class ControlPanel extends JPanel implements GameControlListener{
  private GameController gc;
  private JButton playButton;
  private JLabel playerLabel;
  //private JLabel playerwinLabel;
  private JLabel showdiceLabel;
  private JLabel showplayer;

  public ControlPanel(){
    gc = GameController.getInstance();
    gc.addControlListener(this);

    JButton exitButton = new JButton("Exit");
    //exitButton.setPreferredSize(new Dimension(60, 0));
    exitButton.addActionListener(new ActionListener(){    
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(1);
      }
    });

    playButton = new JButton("Play");
    //playButton.setPreferredSize(new Dimension(60, 0));
    playButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        gc.takeTurn();
        //updateShowDiceLabel();
      }
    });

    //playerwinLabel = new JLabel("", SwingConstants.CENTER);
    //playerwinLabel.setFont(playerwinLabel.getFont().deriveFont(16.0f));
    showdiceLabel = new JLabel("", SwingConstants.CENTER);
    showdiceLabel.setFont(showdiceLabel.getFont().deriveFont(16.0f));
    showplayer = new JLabel("The next player is : ", SwingConstants.CENTER);
    showplayer.setFont(showplayer.getFont().deriveFont(16.0f));
    playerLabel = new JLabel("", SwingConstants.CENTER);
    playerLabel.setFont(playerLabel.getFont().deriveFont(16.0f));
    updatePlayerLabel();
    //updateWinnerLabel();
    setLayout(new GridLayout(0 ,1));
    //setLayout(new BorderLayout());
    add(exitButton);
    //add(playerwinLabel);
    add(showplayer);
    add(playerLabel);
    add(showdiceLabel);
    add(playButton);    
  }

  public void changeGamePlayEnabled(boolean enabled){
    playButton.setEnabled(enabled);
    updatePlayerLabel();
    updateShowDiceLabel();
    //updateWinnerLabel();
  }

  private void updatePlayerLabel(){
    playerLabel.setText(gc.getCurrentPlayer().toString());
  }

  private void updateShowDiceLabel(){
    //gc.d1.reset();
    //gc.d2.reset();
    showdiceLabel.setText("D1:  "+gc.d1.getFace() + "    D2:   "+gc.d2.getFace());
    //showdiceLabel.setText(Integer.toString(gc.d1.getFace() + gc.d2.getFace()));
    //showdiceLabel.setText(gc.getShowDice());
  }

  /*private void updateWinnerLabel(){
    playerwinLabel.setText(gc.getWinner().toString());
  }*/
}