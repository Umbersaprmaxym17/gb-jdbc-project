package com.max;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp {
    private Connection connection;
    private Statement statement;



    public static void main(String[] args)  {
        final JdbcApp jdbcApp = new JdbcApp();
        try {
            jdbcApp.connect();
            jdbcApp.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcApp.disconnect();
        }


    }

    private void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "score INTEGER" +
                ");");
    }









    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
        statement = connection.createStatement();
    }

    private void disconnect() {
        if (statement !=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection !=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
