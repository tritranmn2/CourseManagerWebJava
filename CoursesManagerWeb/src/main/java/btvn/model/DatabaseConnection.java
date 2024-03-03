package btvn.model;

import java.sql.*;


/**
 *
 * @author tritranmn2
 */
public class DatabaseConnection {
    public static Connection connection = null;
    private static DatabaseConnection instance = null;
    
    private DatabaseConnection()  {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/courses_manager_webjava","postgres","postgres");
        } catch (Exception ex) {
            System.out.println("ConnectDb:"+ex.getMessage());
        } 
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                instance=null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
