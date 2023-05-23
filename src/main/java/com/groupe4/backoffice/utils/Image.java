package com.groupe4.backoffice.utils;

import com.groupe4.backoffice.model.product.Product;
import jakarta.servlet.http.Part;

import java.io.*;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.StringJoiner;

public class Image {

    public void save(Part part, int id_product) {
        String fileName = getFileName(part);
        String pathToUpload = getPathToUpload(fileName, id_product);
        try {
            part.write(pathToUpload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "Default.file";
    }

    private String getPathToUpload(String fileName, int id_product) {

        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath;
        try {
            fullPath = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String fullPathArr[] = fullPath.split("/");

        int newLength = fullPathArr.length - 4;
        String[] arrPath = new String[newLength];

        System.arraycopy(fullPathArr, 0, arrPath, 0, newLength);

        StringJoiner joiner = new StringJoiner("/");

        for (String element : arrPath) {
            joiner.add(element);
        }

        String pathDir = joiner.toString() + File.separatorChar + "media/product" + File.separator + id_product;
        File uploadDir = new File(pathDir);

        if (!uploadDir.exists()) uploadDir.mkdir();

        return pathDir + File.separator + fileName;
    }

    public String getImageAsBase64FromProduct(Product product) {

//        getPathToUpload()
        try (FileInputStream inputStream = new FileInputStream(getPathToUpload(product.getPicture_url(), (int) product.getId()))) {

            byte[] fileContent = inputStream.readAllBytes();
            return Base64.getEncoder().encodeToString(fileContent);

        } /*catch (FileNotFoundException e) {
            return getFallbackImageAsBase64();
        }*/ catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //if img not exist
//    private String getFallbackImageAsBase64() throws IOException {
//
//        try (FileInputStream fallbackStream = new FileInputStream(
//                getPathToSource(FALLBACK_PRODUCT_IMAGE_PATH))) {
//            if (fallbackStream == null) {
//                throw new FileNotFoundException("Fallback image not found");
//            }
//
//            byte[] fileContent = fallbackStream.readAllBytes();
//            return Base64.getEncoder().encodeToString(fileContent);
//        }
//    }
}