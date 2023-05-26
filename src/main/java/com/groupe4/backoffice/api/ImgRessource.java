package com.groupe4.backoffice.api;

import com.groupe4.backoffice.model.product.Product;
import com.groupe4.backoffice.service.ProductService;
import com.groupe4.backoffice.utils.Image;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.io.File;
@Path("/image")
public class ImgRessource {
    @Path("/product/{id}")
    @GET
    @Produces("image/png")
    public Response getImageProduct(@PathParam("id") int id) {
        String dir = new Image().getPathImgDirProduct() + File.separator + id;
        Product product = ProductService.fetchOneById(id);
        String path = dir + File.separator + product.getPicture_url();

        File file = new File(path);
        Response.ResponseBuilder responseBuilder = Response.ok(file);
        return responseBuilder.build();
    }
}
