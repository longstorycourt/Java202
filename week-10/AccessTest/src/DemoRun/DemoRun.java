package DemoRun;

import java.sql.*;

public class DemoRun  {
    public static void main(String[] args) throws Exception {
        Connection con;
        Statement stm;
        ResultSet rss;

        try{
            con = DriverManager.getConnection("jdbc:ucanaccess://D:\\MsAccess\\database.accdb");
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
            
            // stm.executeUpdate("INSERT INTO TbStudent VALUES('2', 'Sopheak', 'M', '98');");
            // stm.executeUpdate("UPDATE TbStudent SET Name = 'Dara', Sex = 'M' WHERE Id ='2' ; ");
            // stm.executeUpdate("DELETE * FROM TbStudent WHERE Id = 3;");
            

            // rss = stm.executeQuery("SELECT * FROM TbStudent;");
            // while(rss.next()){
            //     long id = rss.getLong("Id");
            //     String name = rss.getString("Name");
            //     String sex = rss.getString("Sex");
            //     long score = rss.getLong("Score");
            //     System.out.println(id + "    "+ name + "    "+sex+"    "+ score);
            // }
            // System.out.println("Read successfully");


            //stm.executeUpdate("CREATE TABLE Subject (Subject_ID char(10), Subject_Name char(30), Teacher_Name char(30), Date char(15))");
            //stm.executeUpdate("DROP TABLE Subject;"); //Delete the table
            //stm.executeUpdate("INSERT INTO Subject VALUES('3','Python','Chelsea Peretti','12/January/2024');");
            //stm.executeUpdate("UPDATE Subject SET Subject_Name = 'Pascal' WHERE Teacher_Name ='Chelsea Peretti';");
            // stm.executeUpdate("DELETE * FROM Subject WHERE Subject_Id = '3';");
            // rss = stm.executeQuery("SELECT * FROM Subject;");
            // while(rss.next()){
            //     String SubjectId = rss.getString("Subject_ID");
            //     String SubjectName = rss.getString("Subject_Name");
            //     String TeacherName = rss.getString("Teacher_Name");
            //     String Date = rss.getString("Date");
            //     System.out.println(SubjectId+ "    "+ SubjectName + "    "+TeacherName+"    "+ Date);
            // }
            
            System.out.println("Run successfully!");
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
