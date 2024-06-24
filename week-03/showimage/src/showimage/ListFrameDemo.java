package showimage;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListFrameDemo extends Frame {
    public ListFrameDemo(String str){
        super();
        setSize(600,500);
        addWindowListener(new WindowAdapter(){
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });
        add(new ListPanel());
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)  {
        new ListFrameDemo("JList");
    }
}
