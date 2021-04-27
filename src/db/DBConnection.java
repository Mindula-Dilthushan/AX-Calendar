package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/axcalendar", "root", "1023");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (dbConnection == null) ? (dbConnection = new DBConnection()) : (dbConnection);
    }

    public Connection getConnection() {
        return connection;
    }
}
