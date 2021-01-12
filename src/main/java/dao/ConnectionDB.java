package dao;

import models.Account;
import models.Query;

import java.sql.*;

public class ConnectionDB {
    private static volatile ConnectionDB connectionDB = null;
    private Connection connection;
    private final static String jdbcUserName = "nguyenchien92";
    private final static String jdbcPassWord = "Nhiepphong9293";
    private final static String jdbcURL = "jdbc:mysql://localhost:3306/managerHotel?useSSL=false";

    private ConnectionDB() {
    }

    public static ConnectionDB getInstance() {
        if (connectionDB == null) {
            synchronized (ConnectionDB.class) {
                if (connectionDB == null) {
                    connectionDB = new ConnectionDB();
                }
            }
        }

        return connectionDB;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassWord);

        return connection;
    }

}
