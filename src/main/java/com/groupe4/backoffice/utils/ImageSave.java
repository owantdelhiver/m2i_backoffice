package com.groupe4.backoffice.utils;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ImageSave {

    public void save(Part part, int id_product) {
        String fileName = getFileName(part);
        String pathToUpload = getPathToUpload(fileName, id_product);
        try {
            part.write(pathToUpload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "Default.file";
    }

    private String getPathToUpload(String fileName, int id_product) {
        Properties properties = new Properties();
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        try {
            properties.load( new FileInputStream(path + "app.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String uploadPath = properties.getProperty("image_product_dir") + File.separator + id_product;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        return uploadPath + File.separator + fileName;
    }
}