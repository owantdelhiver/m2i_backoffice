package com.groupe4.backoffice.servlet.product;

import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.model.product.ProductCategory;
import com.groupe4.backoffice.service.ProductService;
import com.groupe4.backoffice.utils.ImageSave;
import com.groupe4.backoffice.utils.JsonFormater;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/create-product")
@MultipartConfig
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
        int id_product = ProductService.create(new Product(
                name,
                price,
                shortDescription,
                longDescription,
                stock,
                pictureUrl,
                new ProductCategory(1L, categoryName)));

        new ImageSave().save(req.getPart("pictureUrl"), id_product);

        resp.sendRedirect("products");
    }
}
