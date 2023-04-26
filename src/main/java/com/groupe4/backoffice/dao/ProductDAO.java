package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.Product;
import com.groupe4.backoffice.model.ProductCategory;
import com.groupe4.backoffice.utils.JsonFormater;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonString;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
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
        return null;
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
        new ProductDAO().create(new Product(1L, "toto", 15, "short", "description", 2, Arrays.asList("First", "Second"), new ProductCategory(1L,"category")));
    }
}
