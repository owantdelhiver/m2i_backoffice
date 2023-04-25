package com.groupe4.backoffice.model;

public class ProductCategorie {
    private Long id;
    private String name;

    public ProductCategorie() {
        this.name = "";
    }

    public ProductCategorie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}