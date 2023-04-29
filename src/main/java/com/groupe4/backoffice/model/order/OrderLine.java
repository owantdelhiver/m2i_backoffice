package com.groupe4.backoffice.model.order;

import com.groupe4.backoffice.model.product.Product;

public class OrderLine {
    private int id;
    private Product product;
    private int quantity;

    public OrderLine(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
