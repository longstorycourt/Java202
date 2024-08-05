package DatabaseFormTwo;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DatabaseFormTwo extends JFrame {

    private JLabel lblId = new JLabel("Id");
    private JLabel lblName = new JLabel("Name");
    private JLabel lblSex = new JLabel("Sex");
    private JLabel lblScore = new JLabel("Score");
    private JLabel lblRec = new JLabel("Rec: 0/0", JLabel.CENTER);

    private JTextField txtId = new JTextField();
    private JTextField txtName = new JTextField();
    private JComboBox cboSex = new JComboBox();
    private JTextField txtScore = new JTextField();

    private JButton btnFirst = new JButton("First");
    private JButton btnPrevious = new JButton("Previous");
    private JButton btnNext = new JButton("Next");
    private JButton btnLast = new JButton("Last");
    private JButton btnInsert = new JButton("Insert");

    private GridLayout grd = new GridLayout(4,3);

    private JPanel pnlButton = new JPanel();
    private JPanel pnlContent = new JPanel(grd);

    private Connection con;
    private String url = "jdbc:ucanaccess://D:\\MsAccess\\database.accdb";
    private Statement stm;
    private ResultSet rss;
    private int rowCount = 0;

    public DatabaseFormTwo(){
        setTitle("Update Database");
        setSize(320, 180);
        cboSex.addItem("M");
        cboSex.addItem("F");

        pnlContent.add(lblId);
        pnlContent.add(txtId);
        pnlContent.add(new JLabel());

        pnlContent.add(lblName);
        pnlContent.add(txtName);
        pnlContent.add(new JLabel());
        pnlContent.add(lblSex);
        pnlContent.add(cboSex);
        pnlContent.add(new JLabel());
        pnlContent.add(lblScore);
        pnlContent.add(txtScore);
        pnlContent.add(lblRec);
        
        add(pnlContent, BorderLayout.CENTER);

        grd.setHgap(5);
        grd.setVgap(5);

        pnlButton.add(btnFirst);
        pnlButton.add(btnPrevious);
        pnlButton.add(btnNext);
        pnlButton.add(btnLast);
        add(pnlButton, BorderLayout.SOUTH);

        try{
            con = DriverManager.getConnection(url);
            stm = con.createStatement();
            rss = stm.executeQuery("SELECT * FROM TbStudent");

            updatingRow(rss);

            rss.first();
            settingText(rss);
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        btnFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    rss.first();
                    settingText(rss);
                } catch (SQLException e1) {
                    
                    e1.printStackTrace();
                }
            }
        });
        btnPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    rss.previous();
                    if(rss.isBeforeFirst())
                        rss.first();
                    else
                        settingText(rss);
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
                        settingText(rss);
                }
                catch(SQLException ae){
                    ae.printStackTrace();
                }
            }
        });
        btnLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    rss.last();                        settingText(rss);
                }
                catch(SQLException ae){
                    ae.printStackTrace();
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                try{
                    rss.close();
                    con.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                String id = txtId.getText();
                String name = txtName.getText();
                String sex = cboSex.getSelectedItem().toString();
                String score = txtScore.getText();
                String sql = "INSERT INTO TbStudent VALUES( '"+ id+ "','"+ name+ "',"+sex+ "','"+score+ ");";
                //Execute the insertion
                try{
                    System.out.println(sql);
                    stm.executeUpdate(sql);
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                //Update the row count
                try{
                    rss = stm.executeQuery("SELECT * FROM TbStudent;");
                    updatingRow(rss);   
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void settingText(ResultSet rss){
        try{
            txtId.setText(rss.getString(1));
            txtName.setText(rss.getString(2));
            cboSex.setSelectedItem(rss.getString(3));
            txtScore.setText("" + rss.getInt(4));
            updatingRow(rss);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void updatingRow(ResultSet rss){
        try {
            rss.last();
                rowCount = rss.getRow();
                lblRec.setText("Rec: "+ rss.getRow()+"/"+rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        new DatabaseFormTwo();
    }
}
