package com.groupe4.backoffice.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DB {
    private static Connection connection;

    private DB() {}

    public static Connection getConnection() {
        if(connection == null) {
            try{
                Properties properties = new Properties();
                String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
                properties.load( new FileInputStream(path + "app.properties"));

                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection(properties.getProperty("bdd_url"),properties.getProperty("bdd_user") , properties.getProperty("bdd_password") );
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}