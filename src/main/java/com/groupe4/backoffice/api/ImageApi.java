package com.groupe4.backoffice.api;

import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.service.ImageService;
import com.groupe4.backoffice.service.ProductService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/images")
public class ImageApi {

    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getImagePerId(@PathParam("id") int id) {
        Product product = ProductService.fetchOneById(id);
        String imageBase64 = new ImageService().getImageAsBase64FromProduct(product);

        return Response
                .ok(imageBase64)
                .build();
    }

}