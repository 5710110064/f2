import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
	
	public ControlPanel(){
		JLabel label = new JLabel("Name?");
		setLayout(new FlowLayout());
		JButton button = new JButton("Click Me");
		button.addActionListener(new MyActionListener(label)); //add ActionListener of "Click Me" button
		add(label);
		add(button);
	}
}

class MyActionListener implements ActionListener{
	private JLabel label;

    public MyActionListener(JLabel label){
        this.label = label;
    }
	public void actionPerformed(ActionEvent e){ //action when have event
        label.setText("Hello my name is pigpigcat"); //show name
    }
}