package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.ProductCategorie;

import java.util.ArrayList;
import java.util.List;

public class ProductCategorieDAO implements GenericDAO<ProductCategorie> {

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public List<ProductCategorie> fetchAll() {
        List<ProductCategorie> categories = new ArrayList<>();
        categories.add(new ProductCategorie(1L, "categorie 1"));
        categories.add(new ProductCategorie(2L, "categorie 2"));
        categories.add(new ProductCategorie(3L, "categorie 3"));
        return categories;
    }

    @Override
    public ProductCategorie fetchById(Long id) {
        //TODO
        return new ProductCategorie(1L, "categorie 1");
    }

    @Override
    public void update(ProductCategorie obj) {

    }

    @Override
    public void delete(ProductCategorie obj) {

    }
}