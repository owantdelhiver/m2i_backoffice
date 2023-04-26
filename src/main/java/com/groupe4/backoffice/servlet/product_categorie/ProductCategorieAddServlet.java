package com.groupe4.backoffice.servlet.product_categorie;

import com.groupe4.backoffice.model.ProductCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/product_categorie/add")
public class ProductCategorieAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Nouvelle catégorie");
        req.setAttribute("action", req.getContextPath() + "/product_categorie/add");
        req.setAttribute("categorie", new ProductCategory());
        req.getRequestDispatcher("/WEB-INF/html/product_categorie/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO add categorie product with service

        resp.sendRedirect(req.getContextPath() + "/product_categorie");
    }
}