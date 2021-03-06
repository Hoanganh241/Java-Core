package com.example.demojdbc.controller.model.model.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/demo";
    public static final String USERNAME ="root";
    public static final String PASSWORD = "";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
