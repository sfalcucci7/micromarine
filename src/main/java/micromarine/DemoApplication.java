// package micromarine;

// import java.sql.*;
// import java.util.*;
// import java.util.logging.Logger;

// public class DemoApplication {

//     private static final Logger log;

//     static {
//         System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
//         log =Logger.getLogger(DemoApplication.class.getName());
//     }

//     public static void main(String[] args) throws Exception {
//         log.info("Loading application properties");
//         Properties properties = new Properties();
//         properties.load(DemoApplication.class.getClassLoader().getResourceAsStream("application.properties"));

//         log.info("Connecting to the database");
//         Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
//         log.info("Database connection test: " + connection.getCatalog());

//         log.info("Create database schema");
//         Scanner scanner = new Scanner(DemoApplication.class.getClassLoader().getResourceAsStream("schema.sql"));
//         Statement statement = connection.createStatement();
//         while (scanner.hasNextLine()) {
//             statement.execute(scanner.nextLine());
//         }
//         Plastics plastics = new Plastics("Samantha Falcucci", "sqf5077@psu.edu", 9, "NJ", .44, "Summer");
//         insertData(plastics, connection);



//         log.info("Closing database connection");
//         connection.close();
//     }


//         private static void insertData(Plastics plastics, Connection connection) throws SQLException {
//         log.info("Insert data");
//         PreparedStatement insertStatement = connection
//                 .prepareStatement("INSERT INTO PLASTICS (fullname, email, counttotal, usastate, maxsize, season) VALUES (?, ?, ?, ?, ?, ?);");
    
//         insertStatement.setString(1, plastics.getFullname());
//         insertStatement.setString(2, plastics.getEmail());
//         insertStatement.setInt(3, plastics.getCounttotal());
//         insertStatement.setString(4, plastics.getUsastate());
//         insertStatement.setDouble(5, plastics.getMaxsize());
//         insertStatement.setString(6, plastics.getSeason());

//         insertStatement.executeUpdate();
//             }
//         }



 
    
