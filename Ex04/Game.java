public class Game{
    private int maxSolt;
    private int p1;
    private int p2;
    private int turn;
    private Dice dice1;
    private Dice dice2;

    public Game(int max_slot){
        maxSolt = max_slot;
        p1 = 0;
        p2 = 0;
        turn = 1;
        dice1 = new Dice();
        dice2 = new Dice();
    }
    public void walk(int slot){
        if(turn == 1){
            p1 += slot;
            System.out.println("Player 1 = "+p1);
        }
        else if(turn == 2){
            p2 += slot;
            System.out.println("Player 2 = "+p2);
        }
        if(p1 >= maxSolt){
            System.out.println("***Player 1 Win!!!***");
            System.out.println(p1+":"+p2);
        }
        else if(p2 >= maxSolt){
            System.out.println("***Player 2 Win!!!***");
            System.out.println(p2+":"+p1);
        }
    }
    public boolean isEnded(){
        return p1 >= maxSolt || p2 >= maxSolt;
    }
    public void play(){
        dice1.roll();
        System.out.println("Dice 1 : "+dice1.getValue());
        dice2.roll();
        System.out.println("Dice 2 : "+dice2.getValue());

        walk(dice1.getValue()+dice2.getValue()); 

        if(dice1.getValue() != dice2.getValue()){
            changeTurn();
        }
    }
    private void changeTurn(){
        turn = turn == 1 ? 2:1;
    }
}