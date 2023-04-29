package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.Admin;
import com.groupe4.backoffice.model.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminJdbcDao implements AdminDao { //CREER UNE INTERFACE ?

    @Override
    public Admin create(Admin entity) {
        throw new RuntimeException();
    }

    @Override
    public List<Admin> findAll(String email) {

        Connection connection = DB.getInstance();
       var SELECT_ALL_ADMINS = "select id, firstname, lastname from admin where email = ?";
        List<Admin> adminList = new ArrayList<>();

        try (Statement preparedStatement = connection.createStatement()) {

            ResultSet rs = preparedStatement.executeQuery(SELECT_ALL_ADMINS);

            while (rs.next()) {
                Admin admin = new Admin(
                        rs.getString("adminId"),
                        rs.getString("fistname"),
                        rs.getString("lastname"),
                        rs.getString("email")
                );
                adminList.add(admin);

            }
        } catch (SQLException e) {
            System.out.println("SQL Exception Select User "+e.getMessage());
        }
        return adminList;
    }

}
