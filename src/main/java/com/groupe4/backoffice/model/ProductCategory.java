package com.groupe4.backoffice.model;

public class ProductCategory {
    private Long id;
    private String name;

    public ProductCategory() {
        name = "";
    }

    public ProductCategory(String name) {
        this.name = name;
    }

    public ProductCategory(Long id, String name) {
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