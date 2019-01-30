public class Game{
    private int gamelimit;
    private int player1;
    private int player2;
    private int playerNow;
    public Game(int limit){
        gamelimit = limit;
        player1 = 0;
        player2 = 0;
        playerNow = 1;
    }
    public void walk(int point){
        if(playerNow == 1){
            player1 += point;
            checkWin();
            setPlayer(1);
        }
        else if(playerNow == 2){
            player2 += point;
            checkWin();
            setPlayer(2);
        }
    }
    public void checkWin(){   //Check the winner
        if(player1 >= gamelimit){
            System.out.println("Player1 Win!!!");
            System.out.println(getPlayer1() + ":" + getPlayer2());
        }
        if(player2 >= gamelimit){
            System.out.println("Player2 Win!!!");
            System.out.println(getPlayer2() + ":" + getPlayer1());
        }
    }
    public int getPlayer1(){
        return player1;
    }
    public int getPlayer2(){
        return player2;
    }
    public void setPlayer(int play){   //Define players
        if(play == 1)
            playerNow = 2;
        else if(play == 2)
            playerNow = 1;
    }
}