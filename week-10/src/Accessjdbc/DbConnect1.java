package Accessjdbc;
import java.sql.*;


public class DbConnect1 {
    public static void main(String[] args)  {
        Connection cnn;
        Statement stm;
        ResultSet rss;
        try{
            cnn = DriverManager.getConnection("jdbc:ucanaccess://D:\\MsAccess\\database.accdb");
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss = stm.executeQuery("SELECT * FROM TbStudent;");
            // stm.executeUpdate("INSERT INTO TbStudent VALUES('1', 'Linda', 'F', '99');");
            while(rss.next()){
                long id = rss.getLong("Id");
                String name = rss.getString("Name");
                String sex = rss.getString("Sex");
                long score = rss.getLong("Score");
                System.out.println(id + "  "+ name+"  "+ sex+"  "+score);
            }
            stm.executeUpdate(("UPDATE"))
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
