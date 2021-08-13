import java.sql.*;

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/bms?characterEncoding=latin1","root","supriya@2405");
            s =c.createStatement();
        }catch(Exception e){
            System.out.println("database error" + e);
        }  
    }  
}