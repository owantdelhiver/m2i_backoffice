package com.groupe4.backoffice.servlet.product;

import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.model.product.ProductCategory;
import com.groupe4.backoffice.service.ProductCategorieService;
import com.groupe4.backoffice.service.ProductService;
import com.groupe4.backoffice.utils.ImageSave;
import com.groupe4.backoffice.utils.JsonFormater;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = "/edit-product")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = ProductService.fetchOneById(id);
        List<ProductCategory> categories = ProductCategorieService.fetchAll();
        request.setAttribute("product", product);
        request.setAttribute("categories", categories);
        request
                .getRequestDispatcher("/WEB-INF/html/product_category/edit_product.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String shortDescription = req.getParameter("shortDescription");
        String longDescription = req.getParameter("longDescription");
        int stock = Integer.parseInt(req.getParameter("stock"));
        String pictureUrl = new ImageSave().getFileName(req.getPart("pictureUrl"));
        int categoryId = Integer.parseInt(req.getParameter("productCategoryId"));
        ProductService.update(new Product(
                id,
                name,
                price,
                shortDescription,
                longDescription,
                stock,
                pictureUrl,
                new ProductCategory(categoryId)
        ));

        new ImageSave().save(req.getPart("pictureUrl"), (int) id);

        resp.sendRedirect("products");
    }
}