package packmethode;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonDemo extends JFrame{
    public ButtonDemo(){
        setTitle("Button using pack()");
        setLayout(new FlowLayout());
        setButton(); // This method adds buttons to the frame
        pack(); //Calling the pack() method
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void setButton(){
        for(int i = 1; i<9; i++){
            add(new JButton("Button"+ i));
        }
    }
    public static void main(String[] args) {
        new ButtonDemo();
    }
    
}
