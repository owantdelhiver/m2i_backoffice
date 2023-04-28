package com.groupe4.backoffice.servlet.product_categorie;

import com.groupe4.backoffice.model.Product;
import com.groupe4.backoffice.model.ProductCategory;
import com.groupe4.backoffice.service.ProductCategorieService;
import com.groupe4.backoffice.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductService.fetchAll();
        req.setAttribute("products", products);
        List<ProductCategory> categories = ProductCategorieService.fetchAll();
        req.setAttribute("categories", categories);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/html/product_category/product_list.jsp");
        requestDispatcher.forward(req,resp);
    }
}