import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookStore1 extends Frame{
    private Label lblTitle = new Label("Book Store");
    private Label lblB_ID = new Label("Book ID: ");
    private Label lblB_Qty = new Label("Book Qty:");
    private Label lblB_Price = new Label("Book Price: ");
    private Choice chcB_ID = new Choice();
    private TextField txtB_Qty = new TextField();
    private TextField txtB_Price = new TextField();
    private TextArea txtDisplay = new TextArea();
    private Button btnAdd = new  Button("Add");
    private Button btnTotal = new  Button("Total");
    private Button btnExit = new  Button("Exit");
    private double total = 0;
    private int i =0;

    public BookStore1(){
        setTitle("Book Store");
        setSize(500, 300);
        setLayout(null);
        lblTitle.setAlignment(Label.CENTER);
        chcB_ID.add("B001");
        chcB_ID.add("B002");
        chcB_ID.add("B003");
        chcB_ID.add("B004");
        chcB_ID.add("B005");
        txtDisplay.append("B-ID\tB-Qty\tB-Price\tB-Total\n");
        add(lblTitle);
        add(lblB_ID);        add(chcB_ID);
        add(lblB_Qty);        add(txtB_Qty);   
        add(lblB_Price);        add(txtB_Price);
        add(btnAdd);        add(btnExit);   add(btnExit);
        add(txtDisplay);

        lblTitle.setBounds(5, 30, 500, 20);
        lblB_ID.setBounds(130, 60, 70, 20);
        lblB_Qty.setBounds(130, 85, 70, 20);
        lblB_Price.setBounds(130,110, 70,20);
        chcB_ID.setBounds(210, 60,150, 20);
        txtB_Qty.setBounds(210, 85, 150,20);
        txtB_Price.setBounds(210, 110, 150,20);
        btnAdd.setBounds(135, 135, 70, 30);
        btnTotal.setBounds(210, 135, 70,30);
        btnExit.setBounds(285, 135, 70, 30);
        txtDisplay.setBounds(50, 170, 390, 100);

        chcB_ID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                txtB_Qty.setText("");
                txtB_Price.setText("");
                txtB_Qty.requestFocus();
            }
        });
        txtB_Qty.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode()== KeyEvent.VK_ENTER)
                    txtB_Price.requestFocus();
            }
        });
        txtB_Price.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode()== KeyEvent.VK_ENTER){
                    double q, p, t;
                    q = Double.parseDouble(txtB_Qty.getText());
                    p = Double.parseDouble(txtB_Price.getText());
                    t = q*p; 
                    total += t;
                    txtDisplay.append(chcB_ID.getSelectedItem() + "\t" +txtB_Qty.getText()+ "\t"+ txtB_Price.getText()+ "\t"+ t+ "\n");
                } 
            }
        });
        btnTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                txtDisplay.append("\t\tTotal:\t"+ total + "\n");
            }
        });
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }           
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BookStore1();
    }
}
