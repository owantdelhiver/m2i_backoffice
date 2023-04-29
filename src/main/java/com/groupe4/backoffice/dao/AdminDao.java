package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    private static final String SELECT_ADMIN_BY_EMAIL = "select * from admin where email = ? AND password = ?";

    public static Admin findByCredentials(String email, String password) {
        Admin admin = null;
        Connection connection = DB.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_EMAIL)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");

                admin = new Admin(firstname, lastname, email, password);

            }
        } catch (SQLException e) {
            System.out.println("SQL Exception Select User " + e.getMessage());
        }
        return admin;
    }

    public static List<Admin> findAll() {

        Connection connection = DB.getConnection();
        String SELECT_ALL_ADMINS = "select id, firstname, lastname, email from admin";

        List<Admin> adminList = new ArrayList<>();

        try (Statement preparedStatement = connection.createStatement()) {

            ResultSet rs = preparedStatement.executeQuery(SELECT_ALL_ADMINS);

            while (rs.next()) {
                Admin admin = new Admin(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email")
                );
                adminList.add(admin);

            }
        } catch (SQLException e) {
            System.out.println("SQL Exception Select User " + e.getMessage());
        }
        return adminList;
    }

}
