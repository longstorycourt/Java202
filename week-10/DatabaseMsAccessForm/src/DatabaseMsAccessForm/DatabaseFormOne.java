package DatabaseMsAccessForm;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class DatabaseFormOne extends JFrame {
    private TextArea lblDisplay = new TextArea();
    private JPanel pnlButton = new JPanel(new GridLayout(1,4));
    private JButton btnFirst = new JButton("First");
    private JButton btnPrevious = new JButton("Previous");
    private JButton btnNext = new JButton("Next");
    private JButton btnLast = new JButton("Last");

    Connection con;
    String url ="jdbc:ucanaccess://D:\\MsAccess\\database.accdb";
    Statement stm;
    ResultSet rss;
    
    public DatabaseFormOne(){
        setTitle("Database");
        setSize(400,200);
        add(lblDisplay, BorderLayout.CENTER);
        lblDisplay.setFont(new Font("Cambria", Font.BOLD, 18));

        pnlButton.add(btnFirst);
        pnlButton.add(btnPrevious);
        pnlButton.add(btnNext);
        pnlButton.add(btnLast);

        add(pnlButton, BorderLayout.SOUTH);
        try{
            con = DriverManager.getConnection(url);
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rss = stm.executeQuery("SELECT * FROM TbStudent;");
            rss.first();
            displayText(rss);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        btnFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    rss.first();
                    displayText(rss);
                }
                catch(SQLException ae){
                    ae.printStackTrace();
                }
            } 
        });
        btnPrevious.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    rss.previous();
                    if(rss.isBeforeFirst())
                        rss.first();
                    else
                        displayText(rss);                    

                }
                catch(SQLException ae){
                    ae.printStackTrace();
                }
            }
        });
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    rss.next();
                    if(rss.isAfterLast())
                        rss.last();
                    else
                    displayText(rss);
                }
                catch(SQLException ae){
                    ae.printStackTrace();
                }
            }
        });
        btnLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    rss.last();
                    displayText(rss);
                } catch (SQLException ae) {
                    ae.printStackTrace();
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            public void closeWindow(WindowEvent we){
                try{
                    rss.close();
                    con.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            } 
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void displayText(ResultSet rss){
        try{
            lblDisplay.setText("Id:\t"+ rss.getString(1)+"\nName:\t"+rss.getString(2)+"\nSex:\t"+rss.getString(3)+"\nScore:\t"+rss.getLong(4));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        new DatabaseFormOne();
    }
}
