package com.groupe4.backoffice.model.order;

public enum OrderStatus {
    DELIVERED("delivered"),
    DELIVERY_IN_PROGRESS("delivery in progress"),
    CANCEL("cancel"),
    VALIDATED("validated"),
    RECEIVED("received");

    public final String label;
    private OrderStatus(String label) {
        this.label = label;
    }
}
