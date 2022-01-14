package com.biz.book.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection getConnection() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            String JDBCURL = "jdbc:mysql://127.0.0.1:3308/address_book_system";
            connection = DriverManager.getConnection(JDBCURL, "root", "root");

        } catch (
                SQLException | ClassNotFoundException e) {
            System.out.println("Database not connected..!!!!");
        }
        return connection;
    }

    public static void main(String[] args) {
        DatabaseConnection db=new DatabaseConnection();
        db.getConnection();
    }
}
