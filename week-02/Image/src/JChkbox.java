import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JChkbox extends JFrame implements ActionListener{
    JCheckBox jbx1, jbx2, jbx3;
    JLabel answer1, answer2, answer3;
    boolean select1, select2, select3;
    String selection;
    JChkbox(String title){
        super(title);
        addWindowListener(new WindowAdapter(){
            public void WindowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        setSize(450,300);
        jbx1 = new JCheckBox("China");
        jbx2 = new JCheckBox("Japan");
        jbx3 = new JCheckBox("");         
        jbx3.setText("Cambodia");

        answer1 = new JLabel();
        answer2 = new JLabel();
        answer3 = new JLabel();

        jbx1.addActionListener(this);
        jbx2.addActionListener(this);
        jbx3.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(jbx1);        add(jbx2);        add(jbx3);
        add(answer1);        add(answer2);        add(answer3);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        select1 = jbx1.isSelected();
        select2 = jbx2.isSelected();
        select3 = jbx3.isSelected();
        selection = "";
        if(select1){
            selection = "D:\\CS201-202\\JAVA\\Java202\\week-02\\china flag.png";
            answer1.setIcon(new ImageIcon(selection));
        }
        else{
            selection = "";
            answer1.setIcon(new ImageIcon(selection));
        }
        if (select2) {
            selection = "D:\\CS201-202\\JAVA\\Java202\\week-02\\Flag_of_Japan.svg.png";
            answer2.setIcon(new ImageIcon(selection));
        }
        else{
            selection = "";
            answer2.setIcon(new ImageIcon(selection));
        }
        if (select3) {
            selection = "D:\\CS201-202\\JAVA\\Java202\\week-02\\Flag_of_Cambodia.svg.png";
            answer3.setIcon(new ImageIcon(selection));
        }
        else{
            selection = "";
            answer3.setIcon(new ImageIcon(selection));
        }
    }
    
    public static void main(String[] args) {
        //UIManager.setLookAndFeel(UIMananger.getSystemLookAndFeelClassName());
        new JChkbox("Hello");
        }
}
