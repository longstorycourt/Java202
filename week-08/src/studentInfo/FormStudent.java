package studentInfo;
 //TO_DO add delete; edit; ...
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; 
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 

public class FormStudent extends JFrame implements ActionListener {
   private JTextField tfid,tfname,tfgender,tfscore;
   private JButton btRead, btWrite, btCl;
   private JTable table;
   private ListSelectionModel listselect;
   private DefaultTableModel model;
   private JScrollPane jsp;

   private ArrayList<Student> listAdd=new ArrayList<Student>();

   public FormStudent() {
      initGUI();
   }
   public void initGUI(){
      Container con = getContentPane();
      JPanel p1 = new JPanel(); p1.setLayout(new FlowLayout());
      p1.add(new JLabel("Student Information"));

      JPanel p2=new JPanel();p2.setLayout(new GridLayout(4,2));
      p2.add(new JLabel("ID:"));p2.add(tfid=new JTextField(12));
      p2.add(new JLabel("Name:"));p2.add(tfname=new JTextField(12));
      p2.add(new JLabel("Gender:"));p2.add(tfgender=new JTextField(12));
      p2.add(new JLabel("Score:"));p2.add(tfscore=new JTextField(12));

      JPanel p12=new JPanel();p12.setLayout(new BorderLayout());
      p12.add(p1,"North");p12.add(p2,"Center");

      JPanel p3=new JPanel();p3.setLayout(new FlowLayout());
      //p3.add(btAdd = new JButton("Add"));
      p3.add(btRead=new JButton("Read"));
      p3.add(btWrite=new JButton("Write"));
      p3.add(btCl =new JButton("Clear"));

      JPanel p123=new JPanel();p123.setLayout(new BorderLayout());
      p123.add(p12,"North");p123.add(p3,"Center");
      JPanel p1234=new JPanel();p1234.setLayout(new BorderLayout());

      model=new DefaultTableModel();
      model.addColumn("ID:");
      model.addColumn("Name:");
      model.addColumn("Gender");
      model.addColumn("Score:");
      table=new JTable(model);
      jsp=new JScrollPane(table);
      p1234.add(p123,"North"); p1234.add(jsp,"Center");
      con.add(p1234);
		
      btWrite.addActionListener(this);
      btRead.addActionListener(this);
      btCl.addActionListener(this);
      setVisible(true); setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setSize(300, 300);
   }
   public static void main(String[] args) {
      new FormStudent();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      // if(e.getSource()==btAdd)
      //    myAdd();
      if(e.getSource()==btRead) 
         myRead();
      if(e.getSource()==btWrite)
         myWrite();
      if(e.getSource()==btCl)
         clearTable();		
   }
   public void myAdd(){
      Object []row= {tfid.getText(),tfname.getText(),tfgender.getText(),tfscore.getText()};
      model.addRow(row);
   }	
   public void myWrite(){
      listAdd.add(getStudent());
      try{
         ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("D:\\CS201-202\\JAVA\\Java202\\week-08\\Student.txt",true ));
         out.writeObject(listAdd);
         JOptionPane.showMessageDialog(null, "Write succesfully");
         out.close();
      }
      catch(IOException e){
         e.printStackTrace();}
   }
   public Student getStudent(){
      String i=tfid.getText();
      String n=tfname.getText();
      String g=tfgender.getText();
      double s=Double.parseDouble(tfscore.getText());
      return new Student(i, n, g, s);
   }
   public void myRead(){
      listAdd.clear();
      clearTable();
      read();
      addToTable(listAdd);
   }
   //@SuppressWarnings("unchecked")
   public void read(){
      try{
         ObjectInputStream in=new ObjectInputStream(new FileInputStream("D:\\CS201-202\\JAVA\\Java202\\week-08\\Student.txt"));
         try{
            while(true){
               listAdd = (ArrayList<Student>)in.readObject();
            }		
         }
         catch(EOFException e){ in.close();}
         catch(ClassNotFoundException e){e.printStackTrace();}
         //JOptionPane.showMessageDialog(null, "Read  sucessfully");
      }
      catch(IOException e){e.printStackTrace();}
   }
   public void addToTable(ArrayList<Student> listAdd){
      for(int i=0;i<listAdd.size();i++){
         Object[]row={listAdd.get(i).getId(),listAdd.get(i).getName(),
         listAdd.get(i).getGender(),listAdd.get(i).getScore()};
         model.addRow(row);
      }
   }
  public void clearTable(){
     for(int i=model.getRowCount()-1;i>=0;i--){
        model.removeRow(i);
     }
  }
   // public void clearData(){
   //   tfid.setText(" ");
   //   tfname.setText(" ");
   //   tfgender.setText(" ");
   //   tfscore.setText(" ");      
   // }
}

