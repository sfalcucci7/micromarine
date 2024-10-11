////// [[[THIS IS A CORE IMPORTANT FILE]]]

package micromarine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 // Initiates MySQL JDBC driver and connection to MySQL database micromarinedb 
public class ConnectSQL {
    static  String user = "mmuser";
    static  String password = "N14llsqf5077!";
    static String url = "jdbc:mysql://localhost:3306/micromarinedb";
    static String driver = "com.mysql.cj.jdbc.Driver";

    //Creates method to get the connection that will be used in other modules
    public static Connection GetCon(){
    Connection con = null;
    try {
        Class.forName(driver);
        try {
        con = DriverManager.getConnection(url, user, password);

        // Exception errors if connection is unsuccessful
    } catch (SQLException e){
        throw new RuntimeException(e);
}

    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

return con;
}
    }


