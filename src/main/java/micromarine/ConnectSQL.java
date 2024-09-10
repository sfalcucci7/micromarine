package micromarine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

 // 9-8 this gives succes message connecting to new mysql db
public class ConnectSQL {
    public static void main(String[] args) {
 
        // creates three different Connection objects
        Connection conn1 = null;
        // Connection conn2 = null;
        // Connection conn3 = null;
 
        try {
            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/micromarinedb";
            String user = "mmuser";
            String password = "N14llsqf5077!";
 
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("omg yay it connected to the database");
            }
 
            // // connect way #2
            // String url2 = "jdbc:mysql://localhost:3306/micromarine?user=mmuser&password=N14llsqf5077!";
            // conn2 = DriverManager.getConnection(url2);
            // if (conn2 != null) {
            //     System.out.println("Connected to the database test2");
            // }
 
            // // connect way #3
            // String url3 = "jdbc:mysql://localhost:3306/test3";
            // Properties info = new Properties();
            // info.put("user", "root");
            // info.put("password", "secret");
 
            // conn3 = DriverManager.getConnection(url3, info);
            // if (conn3 != null) {
            //     System.out.println("Connected to the database test3");
            // }
        } catch (SQLException ex) {
            System.out.println("An error occurred. can't connect to db");
            ex.printStackTrace();
        
        }
        finally {
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
}
    }
}











// // package micromarine;

// // import java.sql.*;
// // import java.util.*;
// // import java.util.logging.Logger;

// // public class DemoApplication {

// //     private static final Logger log;

// //     static {
// //         System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
// //         log =Logger.getLogger(DemoApplication.class.getName());
// //     }

// //     public static void main(String[] args) throws Exception {
// //         log.info("Loading application properties");
// //         Properties properties = new Properties();
// //         properties.load(DemoApplication.class.getClassLoader().getResourceAsStream("application.properties"));

// //         log.info("Connecting to the database");
// //         Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
// //         log.info("Database connection test: " + connection.getCatalog());

// //         log.info("Create database schema");
// //         Scanner scanner = new Scanner(DemoApplication.class.getClassLoader().getResourceAsStream("schema.sql"));
// //         Statement statement = connection.createStatement();
// //         while (scanner.hasNextLine()) {
// //             statement.execute(scanner.nextLine());
// //         }

// //         /*
// //         Todo todo = new Todo(1L, "configuration", "congratulations, you have set up JDBC correctly!", true);
// //         insertData(todo, connection);
// //         todo = readData(connection);
// //         todo.setDetails("congratulations, you have updated data!");
// //         updateData(todo, connection);
// //         deleteData(todo, connection);
// //         */

// //         log.info("Closing database connection");
// //         connection.close();
// //     }
// // }



// package micromarine;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class ConnectSQL {
//     // Connect to your database.
//     // Replace server name, username, and password with your credentials
//     public static void main(String[] args) {
        
//         String connectionUrl =
//                // "jdbc:sqlserver://micromarinedb.database.windows.net;" 
//                 "jdbc:sqlserver://micromarinedb.database.windows.net:1433;"
//                         + "database=micromarinedb;"
//                         + "user=mmazureuser;"
//                         + "password=N14llsqf5077!;"
//                         + "encrypt=true;"
//                         + "trustServerCertificate=false;" //orig is false
//                         + "loginTimeout=30;";

//         try (Connection connection = DriverManager.getConnection(connectionUrl);) {
//             // Code here.
//             System.out.println("it connected omg!!");
//         }
//         // Handle any errors that may have occurred.CLASSPATH =.;C:\Users\alexa\OneDrive\Documents\Sam PSU\SWENG  894\sqljdbc_12.8.1.0_enu\sqljdbc_12.8\enu\jars\mssql-jdbc-12.8.1.jre11.jar

//         catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }