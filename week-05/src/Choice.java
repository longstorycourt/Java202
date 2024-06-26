import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Choice extends JFrame{
    ButtonGroup g = new ButtonGroup();
    JRadioButton rdb1 = new JRadioButton("Radio 1");
    JRadioButton rdb2 = new JRadioButton("Radio 2");
    JCheckBox chk1 = new JCheckBox("Checkbox 1");
    JCheckBox chk2 = new JCheckBox("Checkbox 2");
    JComboBox cbo = new JComboBox();
    // JPanel pnl = new JPanel();

    public Choice(){
        setSize(300, 200);
        setLayout(new FlowLayout());
        // pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        g.add(rdb1); g.add(rdb2);
        add(rdb1); add(rdb2);
        add(chk1); add(chk2);
        cbo.addItem("Female");
        cbo.addItem("Male");
        add(cbo);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Choice();
    }

}
