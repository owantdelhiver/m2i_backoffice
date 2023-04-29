package com.groupe4.backoffice.servlet.product_category;

import com.groupe4.backoffice.model.product.ProductCategory;
import com.groupe4.backoffice.service.ProductCategorieService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/categories")
public class ProductCategorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> categories = ProductCategorieService.fetchAll();
        req.setAttribute("categories", categories);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/html/product_category/category_list.jsp");
        requestDispatcher.forward(req,resp);
    }
}