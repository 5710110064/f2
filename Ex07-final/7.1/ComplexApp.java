import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComplexApp{
    private static final String[] FACES = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
    public static void main(String args[]){
        JFrame frame = new JFrame("My App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel facesPanel = new JPanel();
        GridLayout layout = new GridLayout(0, 3);
        layout.setHgap(5);
        layout.setVgap(2);

        facesPanel.setLayout(layout);
        
        JTextField textField = new JTextField();
        textField.setFont(textField.getFont().deriveFont(24.0f));

        JButton numberbutton;
        for(String face : FACES){
            numberbutton = new JButton(face);
            numberbutton.addActionListener(new NumberActionListener(textField, face)); //add ActionListener of each button
            facesPanel.add(numberbutton); //add each button to panel

        }

        frame.getContentPane().setLayout(new BorderLayout());

        JButton button = new JButton("Done");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(new DoneActionListener(textField)); //add ActionListener of "Done" button 

        frame.add(textField, BorderLayout.PAGE_START);
        frame.add(facesPanel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
} 
class NumberActionListener implements ActionListener{
    private JTextField textField;
    private String face;
    public NumberActionListener(JTextField textField, String face){
        this.textField = textField;
        this.face = face;
    }
    public void actionPerformed(ActionEvent e){ //action when have event
        textField.setText(textField.getText() + face); //set number in textfield
    }
}

class DoneActionListener implements ActionListener{
    private JTextField textField;
    public DoneActionListener(JTextField textField){
        this.textField = textField;
    }
    public void actionPerformed(ActionEvent e){ //action when have event
        textField.setText(""); //clear number in textfield
    }
}