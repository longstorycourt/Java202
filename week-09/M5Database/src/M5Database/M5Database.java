package M5Database;
import java.sql.*;

public class M5Database {
    public static void main(String[] args){
        // String url = "jdbc:ucanaccess://D:\\MsAccess\\Database1.accdb";
        
        Connection con;
        // Statement stm;
        // ResultSet rss;
        try{
            con = DriverManager.getConnection("jdbc:ucanaccess://D:/MsAccess/Database1.accdb");
        // stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        // rss = stm.executeQuery("SELECT * FROM Student;");
        // while(rss.next()){
        //     long id = rss.getLong("Id");
        //     String name = rss.getString("Name");
        //     String sex = rss.getString("Sex");
        //     long score = rss.getLong("Score");
        //     System.out.println(id + "  "+ name+"  "+ sex+"  "+score);
        // }
        //stm.executeUpdate("INSERT INTO TbStudent VALUES('1', 'Linda', 'F', '99');");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        }
        
}
