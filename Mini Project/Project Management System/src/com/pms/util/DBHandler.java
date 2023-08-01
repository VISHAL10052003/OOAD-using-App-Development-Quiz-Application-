package com.pms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection to the database using the specified connection URL, username, and password
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}

