package com.groupe4.backoffice.servlet.product_category;

import com.groupe4.backoffice.model.ProductCategory;
import com.groupe4.backoffice.service.ProductCategorieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/edit-category")
public class UpdateCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/WEB-INF/html/product_category/edit_category.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long categoryId = Integer.parseInt(req.getParameter("id"));
        String categoryName = req.getParameter("name");
        ProductCategorieService.update(new ProductCategory(categoryId, categoryName));
        resp.sendRedirect("categories");
    }
}
