package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.ProductCategorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategorieDAO implements GenericDAO<ProductCategorie> {

    @Override
    public void create(ProductCategorie obj) {
        Connection connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product_category(name) VALUES (?)");
            preparedStatement.setString(1, obj.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductCategorie> fetchAll() {
        List<ProductCategorie> categories = new ArrayList<>();
        Connection connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name FROM product_category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(new ProductCategorie(resultSet.getLong("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public ProductCategorie fetchById(Long id) {
        ProductCategorie category = null;
        Connection connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name FROM product_category WHERE id = ? ");
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new ProductCategorie(resultSet.getLong("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    @Override
    public void update(ProductCategorie obj) {
        Connection connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product_category SET name = ? WHERE id = ?");
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, Math.toIntExact(obj.getId()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ProductCategorie obj) {
        Connection connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product_category WHERE id = ? ");
            preparedStatement.setInt(1, Math.toIntExact(obj.getId()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}