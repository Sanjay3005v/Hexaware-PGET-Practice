package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/student_management_system";
    private final static String USER = "root";
    private final static String PWD = "Sanjay@30052005";

    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }                                                   
        return connection;
    }
}
