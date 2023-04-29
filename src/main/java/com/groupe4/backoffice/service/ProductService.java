package com.groupe4.backoffice.service;

import com.groupe4.backoffice.dao.ProductDAO;
import com.groupe4.backoffice.model.product.Product;

import java.util.List;

public class ProductService {
    public static List<Product> fetchAll() {
        return new ProductDAO().fetchAll();
    }
    public static Product fetchOneById(int id) {
        return new ProductDAO().fetchById((long) id);
    }
    public static List<Product> fetchByNameOrId(String search) {return new ProductDAO().fetchByNameOrId(search);}
    public static void create(Product product) {
        new ProductDAO().create(product);
    }

    public static void update(Product product) {
        new ProductDAO().update(product);
    }

    public static void delete(Long id) {
        new ProductDAO().delete(id);
    }
}
