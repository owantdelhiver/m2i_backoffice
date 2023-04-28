package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.Product;
import com.groupe4.backoffice.model.ProductCategory;
import com.groupe4.backoffice.utils.JsonFormater;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class ProductDAO implements GenericDAO<Product> {
    @Override
    public void create(Product obj) {
        Connection connection = DB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product(id, name, price, short_description, description, stock, picture_url, id_category) VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,Math.toIntExact(obj.getId()));
            preparedStatement.setString(2,obj.getName());
            preparedStatement.setFloat(3, obj.getPrice());
            preparedStatement.setString(4, obj.getShort_description());
            preparedStatement.setString(5, obj.getDescription());
            preparedStatement.setInt(6, obj.getStock());
            preparedStatement.setString(7, JsonFormater.arraysStringToJsonString(obj.getPicture_url()));
            preparedStatement.setInt(8, Math.toIntExact(obj.getCategory().getId()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> fetchAll() {
        Connection connection = DB.getConnection();
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.id, p.name, p.price, p.short_description, p.description, p.stock, p.picture_url, pc.id, pc.name FROM product p LEFT JOIN product_category pc on p.id_category = pc.id")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                products.add(
                        new Product(
                                resultSet.getLong("p.id"),
                                resultSet.getString("p.name"),
                                resultSet.getFloat("p.price"),
                                resultSet.getString("p.short_description"),
                                resultSet.getString("p.description"),
                                resultSet.getInt("p.stock"),
                                JsonFormater.JsonToListString(resultSet.getString("p.picture_url")),
                                new ProductCategory(
                                        resultSet.getLong("pc.id"),
                                        resultSet.getString("pc.name")
                                        )
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public Product fetchById(Long id) {
        return null;
    }

    @Override
    public void update(Product obj) {

    }

    @Override
    public void delete(Product obj) {

    }

    public static void main(String[] args) {
        System.out.println(new ProductDAO().fetchAll());
    }
}
