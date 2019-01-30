public class Clock{
    private int state;
    private int h;
    private int m; 
    public Clock(int hour, int min){
        h = hour;
        m = min;
        state = 0;
    }
    public void pressUp(){
        if(state == 1)
            h++;
        else if(state == 2)
            m++;
    }
    public void pressDown(){
        if(state == 1)
            h--;
        else if(state == 2)
            m--;
    }
    public void pressCenter(boolean longpress){
        if(longpress){
            if(state == 0)
                state = 1;
            else
                state = 0;
            printTime();
        }
        else{
            switch(state){
                case 1:
                    state = 2; break;
                case 2:
                    state = 1; break;
            }
        }
    }
    public void printTime(){
        System.out.println(h+"."+m);
    }
}