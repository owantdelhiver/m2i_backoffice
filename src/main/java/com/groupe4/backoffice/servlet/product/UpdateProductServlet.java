package com.groupe4.backoffice.servlet.product;

import com.groupe4.backoffice.model.Product;
import com.groupe4.backoffice.model.ProductCategory;
import com.groupe4.backoffice.service.ProductCategorieService;
import com.groupe4.backoffice.service.ProductService;
import com.groupe4.backoffice.utils.JsonFormater;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/edit-product")
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/WEB-INF/html/product_category/edit_product.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        long price = Long.parseLong(req.getParameter("price"));
        String shortDescription = req.getParameter("shortDescription");
        String longDescription = req.getParameter("longDescription");
        int stock = Integer.parseInt(req.getParameter("stock"));
        String pictureUrl = req.getParameter("pictureUrl");
        String categoryName = req.getParameter("categoryName");
        ProductService.update(new Product(
                id,
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
