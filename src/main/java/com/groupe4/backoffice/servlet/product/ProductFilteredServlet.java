package com.groupe4.backoffice.servlet.product;

import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.model.product.ProductCategory;
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

@WebServlet("/products-filtered")
public class ProductFilteredServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        String[] selectedCategories = request.getParameterValues("category");
        List<Product> filteredProducts = productService.filterProductsByCategories(selectedCategories);
        request.setAttribute("products", filteredProducts);

        List<ProductCategory> categories = ProductCategorieService.fetchAll();
        request.setAttribute("categories", categories);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/html/product_category/product_list.jsp");
        dispatcher.forward(request, response);
    }
}
