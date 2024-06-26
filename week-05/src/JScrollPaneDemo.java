import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JScrollPaneDemo extends JFrame{
private JButton btn[] = new JButton[20];
private JPanel pnl = new JPanel();
private int v = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
private int h = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
private JScrollPane scr = new JScrollPane(pnl, v, h);

public JScrollPaneDemo(){
setTitle("JScrollPane Demo");
    setSize(500,300);
    for(int i = 0; i<20; i++){
        pnl.add(btn[i]= new JButton("Button"+ (i+1)));
        add(scr);
        setVisible(true);
        setLocationRelativeTo(null); 
    }
}
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new JScrollPaneDemo();
    }
}