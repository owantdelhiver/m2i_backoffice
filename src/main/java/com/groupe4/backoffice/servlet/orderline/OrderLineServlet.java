package com.groupe4.backoffice.servlet.orderline;

import com.groupe4.backoffice.dao.order.OrderDao;
import com.groupe4.backoffice.model.order.Order;
import com.groupe4.backoffice.model.order.OrderStatus;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/order")
public class OrderLineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Order order = new OrderDao().fetchById((long) id);
        req.setAttribute("order", order);

        List<OrderStatus> orderStatus = Arrays.asList(OrderStatus.values());
        req.setAttribute("status", orderStatus);

        req.getRequestDispatcher("/WEB-INF/html/order/edit.jsp")
                .forward(req, resp);
    }
}