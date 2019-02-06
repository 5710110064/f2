public class Dice{
    private int pageDice;

    public Dice(){
        pageDice = 1;
    }

    public void roll(){
        pageDice = (int)(Math.random()*6) + 1;
    }

    public int getValue(){
        return pageDice;
    }
}