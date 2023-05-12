package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.model.product.ProductCategory;
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
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product(name, price, short_description, description, stock, picture_url, id_category) VALUES (?,?,?,?,?,?,?)");){
            preparedStatement.setString(1,obj.getName());
            preparedStatement.setFloat(2, obj.getPrice());
            preparedStatement.setString(3, obj.getShort_description());
            preparedStatement.setString(4, obj.getDescription());
            preparedStatement.setInt(5, obj.getStock());
            preparedStatement.setString(6, obj.getPicture_url());
            preparedStatement.setInt(7, Math.toIntExact(obj.getCategory().getId()));
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
                                resultSet.getString("p.picture_url"),
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
        Connection connection = DB.getConnection();
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.id, p.name, p.price, p.short_description, p.description, p.stock, p.picture_url, pc.id, pc.name FROM product p LEFT JOIN product_category pc on p.id_category = pc.id WHERE p.id = ?")){
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                product = new Product(
                                resultSet.getLong("p.id"),
                                resultSet.getString("p.name"),
                                resultSet.getFloat("p.price"),
                                resultSet.getString("p.short_description"),
                                resultSet.getString("p.description"),
                                resultSet.getInt("p.stock"),
                                resultSet.getString("p.picture_url"),
                                new ProductCategory(
                                        resultSet.getLong("pc.id"),
                                        resultSet.getString("pc.name")
                                )
                        );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    @Override
    public void update(Product obj) {
        Connection connection = DB.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET name = ?, price = ?, short_description = ?, description = ?, stock = ?, picture_url = ?, id_category = ? WHERE id = ?")) {
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setFloat(2, obj.getPrice());
            preparedStatement.setString(3, obj.getShort_description());
            preparedStatement.setString(4, obj.getDescription());
            preparedStatement.setInt(5, obj.getStock());
            preparedStatement.setString(6, obj.getPicture_url());
            preparedStatement.setInt(7, Math.toIntExact(obj.getCategory().getId()));
            preparedStatement.setInt(8, Math.toIntExact(obj.getId()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = DB.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?")){
            preparedStatement.setInt(1, Math.toIntExact(id));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> fetchByNameOrId(String search) {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT p.id, p.name, p.price, p.short_description, p.description, p.stock, p.picture_url, pc.id, pc.name FROM product p LEFT JOIN product_category pc on p.id_category = pc.id WHERE p.id LIKE ? OR p.name LIKE ?")) {
            preparedStatement.setString(1,search);
            preparedStatement.setString(2, "%" + search + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(
                        new Product(
                                resultSet.getLong("p.id"),
                                resultSet.getString("p.name"),
                                resultSet.getFloat("p.price"),
                                resultSet.getString("p.short_description"),
                                resultSet.getString("p.description"),
                                resultSet.getInt("p.stock"),
                                resultSet.getString("p.picture_url"),
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
}
