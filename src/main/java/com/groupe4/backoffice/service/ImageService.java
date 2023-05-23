package com.groupe4.backoffice.service;

import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.utils.Image;

public class ImageService {
    public String getImageAsBase64FromProduct(Product product) {
        return new Image().getImageAsBase64FromProduct(product);
    }
}
