package core.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static final String driverName = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/universalyazilim";
    static final String userName = "root";
    static final String password = "universal1234";
    static Connection connection = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        connection=DriverManager.getConnection(url, userName, password);
        return connection;
    }
}
