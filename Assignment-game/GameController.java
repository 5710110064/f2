import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

public class GameController implements PlayerListener {
  private Board board;
  public static Dice d1 = new Dice();
  public static Dice d2 = new Dice();

  private Player p1;
  private Player p2;
  private Player currentPlayer;
  private Player winner = null;
  private List<Sprite> players = new ArrayList<>();

  private List<GameSpriteListener> spriteListeners = new ArrayList<>();
  private List<GameControlListener> controlListeners = new ArrayList<>();

  private static GameController instance;
  public static GameController getInstance(){
    if(instance == null){
      instance = new GameController();
    }
    return instance;
  }

  private GameController() {
    board = new Board(80);

    p1 = new Player("Player1", 0, board, this);
    p2 = new Player("Player2", 1, board, this);
    currentPlayer = p1;
    
    players.add(p1);
    players.add(p2);    

    //ImageIcon icon = new ImageIcon("C:/Users/Intel/Desktop/TANG/OOP/testwork/test-assignment/test-yourseft02/icon.jpg");
  }

  private void rollDice() {
    d1.roll();
    d2.roll();
  }

  public void takeTurn() {
    if(winner != null)
      return;

    rollDice();
    System.out.println("Dice1 : "+d1.getFace()+" , Dice2 : "+d2.getFace());
    currentPlayer.walk(d1.getFace() + d2.getFace());
  }

  public void changeTurn() {
    if (currentPlayer == p1)
      currentPlayer = p2;
    else
      currentPlayer = p1;
  }

  @Override
  public void walking(Player owner){
    notifyGamePlayEnabled(false);
    for(GameSpriteListener listener : spriteListeners){
      listener.spriteUpdated();
    }
  }

  @Override
  public void walkCompleted(Player onwer) {
    if(d1.getFace() != d2.getFace()){
      if(currentPlayer.getCurrentPosition() == 9){
        repeatTurn();
      }
      else{
        changeTurn();
      }
      //changeTurn();
      //blackHole();
      //repeatTurn();
      d1.reset();
      d2.reset();
    }
    
    //blackHole();
    notifyGamePlayEnabled(true);
  }

  @Override
  public void hasWon(Player owner) {
    if (winner == null) { // first winner only
      winner = owner;
      ImageIcon icon = new ImageIcon("C:/Users/Intel/Desktop/TANG/OOP/testwork/test-assignment/test-yourseft02/icon.jpg");
      JOptionPane.showMessageDialog(null, "The winner is :  "+ owner +"  !!!", "Winner", JOptionPane.INFORMATION_MESSAGE, icon );
    }
  }

  public Player getWinner() {
    return winner;
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public List<Sprite> getSprites(){
    return players;
  }

  public void addSpriteListener(GameSpriteListener listener){
    spriteListeners.add(listener);
  }

  public void addControlListener(GameControlListener listener){
    controlListeners.add(listener);
  }

  public void notifyGamePlayEnabled(boolean enabled){
    for(GameControlListener listener : controlListeners){
      listener.changeGamePlayEnabled(enabled);
    }
  }

  /*public void blackHole(){
        if(currentPlayer.getNextPosition() == 7 || currentPlayer.getNextPosition() == 12){

        }
    //repeatTurn();
  }*/

  private void repeatTurn() {
    if (currentPlayer == p1)
      currentPlayer = p1;
    else
      currentPlayer = p2;
  }

  /*public String getShowDice(){
    return "Dice1: "+d1.getFace()+" , Dice2: "+d2.getFace();
  }*/

}