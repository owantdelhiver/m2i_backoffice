package com.groupe4.backoffice.servlet.product;

import com.groupe4.backoffice.model.Product;
import com.groupe4.backoffice.model.ProductCategory;
import com.groupe4.backoffice.service.ProductService;
import com.groupe4.backoffice.utils.JsonFormater;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/create-product")
public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/html/product_category/create_product.jsp");
        requestDispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String shortDescription = req.getParameter("shortDescription");
        String longDescription = req.getParameter("longDescription");
        int stock = Integer.parseInt(req.getParameter("stock"));
        String pictureUrl = req.getParameter("pictureUrl");
        String categoryName = req.getParameter("categoryName");
        ProductService.create(new Product(
                name,
                price,
                shortDescription,
                longDescription,
                stock,
                JsonFormater.JsonToListString(pictureUrl),
                new ProductCategory(1L, categoryName)));
        resp.sendRedirect("products");
    }
}
