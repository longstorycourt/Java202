import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    private JLabel lblName = new JLabel("Username: ");
    private JLabel lblPw = new JLabel("Password: ");
    private JTextField txtName = new JTextField();
    private JPasswordField txtPw = new JPasswordField();
    private Button btnLogin = new Button("LogIn");
    private Button btnExit = new Button("Exit");
    private JPanel pnl1, pnl2;
    int error = 0;
    public Login(){
        pnl1 = new JPanel();
        pnl1.setLayout(new BorderLayout());
        pnl2 = new JPanel();
        pnl2.setLayout(new GridLayout(3,2));
        pnl2.add(lblName);        pnl2.add(txtName);  
        pnl2.add(lblPw);        pnl2.add(txtPw);  
        pnl2.add(btnLogin);        pnl2.add(btnExit);
        pnl1.add(pnl2, BorderLayout.CENTER);
        add(pnl1);

        txtPw.setEchoChar('*'); //all inputs in txtPw shown as '*'
        btnLogin.addActionListener(this);
        btnExit.addActionListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(350,150);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnLogin){
            if(txtName.getText().compareTo("soksan")==0 && txtPw.getText().compareTo("123456") ==0)
                JOptionPane.showMessageDialog(null, "You're logged in!");
            else{
                if(error <=2){
                    error +=1;
                    JOptionPane.showMessageDialog(null,"Incorrect username or password! Please try again.");
                }
                else{
                    txtPw.setEnabled(false);
                    txtName.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Max attempt reached!");
                }
            }
        }
        if(ae.getSource()== btnExit)
            System.exit(0);
    }
    public static void main(String[] args){
        new Login();
    }
}
