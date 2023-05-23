package com.groupe4.backoffice.servlet;

import com.groupe4.backoffice.service.ImageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/images/product")
public class ImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        resp.setContentType("image/jpg");
        try(ServletOutputStream out = resp.getOutputStream()) {
            ImageService.read(id, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}