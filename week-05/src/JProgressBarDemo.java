import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.awt.BorderLayout;

public class JProgressBarDemo extends JFrame{
    private JProgressBar progressBar = new JProgressBar();
    public JProgressBarDemo(){
        setLayout(new BorderLayout());
        setTitle("JProgressBar Demo");
        setSize(500, 300);
        add(progressBar, BorderLayout.SOUTH);
        progressBar.setStringPainted(true);
        setVisible(true);
        setLocationRelativeTo(null);

        for(int i = 0; i<=100; i++){
            progressBar.setValue(i);
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException exc){}
        }
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new JProgressBarDemo();
    }
    
}
