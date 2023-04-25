package com.groupe4.backoffice.model;

public class ProductCategorie {
    private Long id;
    private String name;

    public ProductCategorie() {
        name = "";
    }

    public ProductCategorie(String name) {
        this.name = name;
    }

    public ProductCategorie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}