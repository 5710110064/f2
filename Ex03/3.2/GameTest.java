public class GameTest{
    public static void main(String args[]){
        Game g = new Game(30);
        g.walk(10);  
        g.walk(5);   
        g.walk(8);   
        g.walk(3);   
        g.walk(12);   //Player1 Win!!!  
    }
}