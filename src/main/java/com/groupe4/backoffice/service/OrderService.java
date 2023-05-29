package com.groupe4.backoffice.service;

import com.groupe4.backoffice.dao.order.OrderDao;
import com.groupe4.backoffice.model.order.Order;

import java.util.List;

public class OrderService {
    public List<Order> getAll() {
        return new OrderDao().fetchAll();
    }
}
