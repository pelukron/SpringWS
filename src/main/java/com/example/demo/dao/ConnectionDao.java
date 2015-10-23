package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Diego Moreno on 23/10/2015.
 */
public class ConnectionDao {
    private static final String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "movil";
    private static final String DB_URL = "jdbc:mysql://192.168.3.67:3306/"+ DB_NAME;
    private static final String ID = "usrMovil";
    private static final String PASS = "pswMovil";
    protected Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER_NAME).newInstance();
            return DriverManager.getConnection(DB_URL, ID, PASS);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void close(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
