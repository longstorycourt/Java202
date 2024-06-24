package ScrollPanel;
import javax.swing.*;
public class ScrollPanelForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->createAndShowGUI());
    }
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Scrollable Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        //Create a panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        //Create a scroll pane and add the form panel
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //add the scroll pane to the frame
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
