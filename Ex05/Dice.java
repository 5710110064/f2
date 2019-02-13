public class Dice{
    private int faceDice;

    public Dice(){
        faceDice = 1;
    }

    public void roll(){
        faceDice = (int)(Math.random()*6) + 1;
    }

    public int getValue(){
        return faceDice;
    }
}