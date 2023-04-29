package com.groupe4.backoffice.service;

import com.groupe4.backoffice.dao.ProductCategorieDAO;
import com.groupe4.backoffice.model.product.ProductCategory;

import java.util.List;

public class ProductCategorieService {
    public static List<ProductCategory> fetchAll() {
        return new ProductCategorieDAO().fetchAll();
    }

    public static ProductCategory fetchOneById(long id) {
        return new ProductCategorieDAO().fetchById(id);
    }

    public static void create(ProductCategory productCategory) {
        new ProductCategorieDAO().create(productCategory);
    }

    public static void update(ProductCategory productCategory) {
        new ProductCategorieDAO().update(productCategory);
    }

    public static void delete(long id) {
        new ProductCategorieDAO().delete(id);
    }
}
