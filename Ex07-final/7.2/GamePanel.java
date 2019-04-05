import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class GamePanel extends JPanel {
	public GamePanel(){
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black); //set color of background
		g2d.fillRect(0,0,400,600); //set for background

    	g2d.setColor(Color.yellow);         //set color
     	g2d.drawRect(150, 150, 100, 100);     // head (x,y,width,height)
     	g2d.setColor(Color.green);
    	g2d.drawRect(200, 440, 150, 10);    // tail
     	g2d.setColor(Color.blue);
    	g2d.fillOval(100, 250, 200, 200);  // body
     	g2d.setColor(Color.pink);
     	g2d.drawOval(100, 250, 200, 200);  // paint body
     	g2d.fillOval(195, 195, 10, 5);     // nose
     	g2d.setColor(Color.white);
     	g2d.fillOval(170, 170, 10, 10);     // left eyes
     	g2d.fillOval(220, 170, 10, 10);     // right eyes
    	g2d.setColor(Color.orange);
    	g2d.drawLine(150, 150, 170, 130);     // left ears
    	g2d.drawLine(170, 130, 190, 150);
        g2d.setColor(Color.gray); 
    	g2d.drawLine(210, 150, 230, 130);    // right ears
    	g2d.drawLine(230, 130, 250, 150);
    	g2d.setColor(Color.red);
    	g2d.drawArc(170, 200, 60, 30, 180, 180);  // mouth (int x, int y, int width, int length, int startAngle, int arcAngle)
        g2d.drawLine(200, 200, 200, 230);

        g2d.setColor(Color.gray); 
        g2d.fillOval(160, 270, 40, 200);  // left leg 
        g2d.fillOval(200, 270, 40, 200);  // right leg 

        g2d.setColor(Color.white);
        g2d.drawLine(160, 220, 120, 200);     // left mustache
        g2d.drawLine(160, 230, 120, 230);
        g2d.drawLine(160, 240, 120, 250);
        g2d.drawLine(240, 220, 280, 200);     // right mustache
        g2d.drawLine(240, 230, 280, 230);
        g2d.drawLine(240, 240, 280, 250);

	}
}