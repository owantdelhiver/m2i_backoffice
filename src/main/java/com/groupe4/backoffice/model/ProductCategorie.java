package com.groupe4.backoffice.model;

public class ProductCategorie {
    private Long id;
    private String name;
    private String description;

    public ProductCategorie() {
        this.name = "";
        this.description = "";
    }

    public ProductCategorie(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
