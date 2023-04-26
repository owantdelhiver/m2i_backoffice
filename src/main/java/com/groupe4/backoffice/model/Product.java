package com.groupe4.backoffice.model;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonString;

import java.util.List;

public class Product {
    private long id;
    private String name;
    private float price;
    private String short_description;
    private String description;
    private int stock;
    private List<String> picture_url;
    private ProductCategory category;

    public Product(long id, String name, float price, String short_description, String description, int stock, List<String> picture_url, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.short_description = short_description;
        this.description = description;
        this.stock = stock;
        this.picture_url = picture_url;
        this.category = category;
    }

    public Product(String name, float price, String short_description, String description, int stock, List<String> picture_url, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.short_description = short_description;
        this.description = description;
        this.stock = stock;
        this.picture_url = picture_url;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(List<String> picture_url) {
        this.picture_url = picture_url;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
