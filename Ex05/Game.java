import java.util.ArrayList;

public class Game{
    private int p1;
    private int p2;
    private int maxSlot;
    private int turn;
    private Dice dice1;
    private Dice dice2;
    private ArrayList<Tunnel> tunnels;

    public Game(int max_slot){
        p1 = 0;
        p2 = 0;
        maxSlot = max_slot;
        turn = 1;
        dice1 = new Dice();
        dice2 = new Dice();
        tunnels = new ArrayList<Tunnel>();
    }
    public void addTunnel(int s_in, int s_out){
        Tunnel t = new Tunnel(s_in, s_out);
        tunnels.add(t);
    }
    private void walk(int slot){
        if(turn == 1){
            p1 += slot;
            System.out.println("Player 1 = "+p1);
            for(Tunnel t: tunnels)
                p1 = t.walkIn(p1);
        }
        else if(turn == 2){
            p2 += slot;
            System.out.println("Player 2 = "+p2);
            for(Tunnel t: tunnels)
                p2 = t.walkIn(p2);
        }
        if(p1 >= maxSlot){
            System.out.println("*** Player 1 Win!!! ***");
            System.out.println(p1+ ":" +p2);
        }
        else if(p2 >= maxSlot){
            System.out.println("*** Player 2 Win!!! ***");
            System.out.println(p2+ ":" +p1);
        }
    }
    public boolean isEnded(){
        return p1 >= maxSlot || p2 >= maxSlot;
    }
    public void play(){
        dice1.roll();
        System.out.println("Dice 1 : "+dice1.getValue());
        dice2.roll();
        System.out.println("Dice 2 : "+dice2.getValue());
        walk(dice1.getValue() + dice2.getValue());
        if(dice1.getValue() != dice2.getValue())
            changeTurn();
    }
    private void changeTurn(){
        turn = turn == 1 ? 2:1;
    }
}