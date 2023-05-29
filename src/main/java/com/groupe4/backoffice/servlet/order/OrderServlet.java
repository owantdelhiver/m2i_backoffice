package com.groupe4.backoffice.servlet.order;

import com.groupe4.backoffice.dao.order.OrderDao;
import com.groupe4.backoffice.model.order.Order;
import com.groupe4.backoffice.model.order.OrderStatus;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));
        Order order = new OrderDao().fetchById((long) id);



        order.setOrderStatus(OrderStatus.valueOf(req.getParameter("status")));

        resp.sendRedirect("/orders");
    }
}