import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    final static String url="jdbc:mysql://localhost:3306/library";
    final static String uname= "root";
    final static String password= "SriKrishnaAlexanderKarn1163#";
    public static Connection con;
    public static Connection getConnection(){
        
        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
            
        // } catch (ClassNotFoundException e) {
            
        //     e.printStackTrace();
        // }
        try {
            con = DriverManager.getConnection(url, uname, password);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return con;
    }
}
