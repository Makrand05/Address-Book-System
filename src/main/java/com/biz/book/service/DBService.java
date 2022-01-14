package com.biz.book.service;

import com.biz.book.model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    DatabaseConnection databaseConnection = new DatabaseConnection();

    public  boolean showData() {
        List<ContactPerson> contactList = new ArrayList<>();

        try (Connection connection =  databaseConnection.getConnection()){
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from address_book";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                ContactPerson info=new ContactPerson();
                info.setId(resultSet.getInt(1));
                info.setFirstName(resultSet.getString(2));
                info.setLastName(resultSet.getString(3));
                info.setAddress(resultSet.getString(4));

                info.setCity(resultSet.getString(5));
                info.setState(resultSet.getString(6));
                info.setZip(resultSet.getInt(7));
                info.setPhoneNumber(resultSet.getLong(8));
                info.setEmailId(resultSet.getString(9));
                contactList.add(info);
            }
        } catch (SQLException throwables) {
           return false;
        }
        System.out.println(contactList);
        return true;
    }

}
