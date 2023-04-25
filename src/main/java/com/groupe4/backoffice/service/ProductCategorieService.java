package com.groupe4.backoffice.service;

import com.groupe4.backoffice.dao.ProductCategorieDAO;
import com.groupe4.backoffice.model.ProductCategorie;

import java.util.List;

public class ProductCategorieService {
    public static List<ProductCategorie> fetchAll() {
        return new ProductCategorieDAO().fetchAll();
    }

    public static ProductCategorie fetchOneById(long id) {
        return new ProductCategorieDAO().fetchById(id);
    }

    public static void create(ProductCategorie productCategorie) {
        new ProductCategorieDAO().create(productCategorie);
    }

    public static void update(ProductCategorie productCategorie) {
        new ProductCategorieDAO().update(productCategorie);
    }

    public static void delete(ProductCategorie productCategorie) {
        new ProductCategorieDAO().delete(productCategorie);
    }
}
