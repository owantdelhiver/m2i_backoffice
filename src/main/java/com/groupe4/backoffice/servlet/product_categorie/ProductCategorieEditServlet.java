package com.groupe4.backoffice.servlet.product_categorie;

import com.groupe4.backoffice.model.ProductCategory;
import com.groupe4.backoffice.service.ProductCategorieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/product_categorie/edit")

public class ProductCategorieEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductCategory productCategory = ProductCategorieService.fetchOneById(Long.parseLong(req.getParameter("id")));

        req.setAttribute("title", "Edit");
        req.setAttribute("action", req.getContextPath() + "/product_categorie/edit");
        req.setAttribute("categorie", productCategory);
        req.getRequestDispatcher("/WEB-INF/html/product_categorie/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/product_categorie");
    }
}
