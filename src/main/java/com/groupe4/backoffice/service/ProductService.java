package com.groupe4.backoffice.service;

import com.groupe4.backoffice.dao.ProductDAO;
import com.groupe4.backoffice.model.Product;

import java.util.List;

public class ProductService {
    public static List<Product> fetchAll() {
        return new ProductDAO().fetchAll();
    }
}
