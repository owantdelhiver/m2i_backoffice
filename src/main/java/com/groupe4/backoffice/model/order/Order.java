package com.groupe4.backoffice.model.order;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private OrderStatus orderStatus;
    private List<OrderLine> orderLines;

    public Order(int id, Date date, OrderStatus orderStatus, List<OrderLine> orderLines) {
        this.id = id;
        this.date = date;
        this.orderStatus = orderStatus;
        this.orderLines = orderLines;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
}
