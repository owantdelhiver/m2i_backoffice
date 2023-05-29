package com.groupe4.backoffice.servlet.orders;

import com.groupe4.backoffice.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/orders")

public class OrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("orders", new OrderService().getAll());
        req
                .getRequestDispatcher("/WEB-INF/html/orders/list.jsp")
                .forward(req, resp);
    }
}
