package com.groupe4.backoffice.service;

import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.utils.Image;
import jakarta.servlet.ServletOutputStream;

import java.io.*;

public class ImageService {
    public String getImageAsBase64FromProduct(Product product) {
        return new Image().getImageAsBase64FromProduct(product);
    }

    public static void read(int id, ServletOutputStream out) {
        String dir = new Image().getPathImgDirProduct() + File.separator + id;
        Product product = ProductService.fetchOneById(id);
        String path = dir + File.separator + product.getPicture_url();

        try(FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(out);
        ) {
            int ch;
            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
