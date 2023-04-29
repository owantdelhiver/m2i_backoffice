package com.groupe4.backoffice.dao;
import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

        private static final String SELECT_ADMIN_BY_EMAIL = "select * from admin where email = ? AND password = ?";

        public AdminDao() {
        }

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

                    admin = new Admin(firstname, lastname , email, password);

                }
            } catch (SQLException e) {
                System.out.println("SQL Exception Select User "+e.getMessage());
            }
            return admin;
        }



}
