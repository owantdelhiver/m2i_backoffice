package com.groupe4.backoffice.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/test")
public class Test {
    @GET()
    public Response test() {
        return Response.status(200).build();
    }
}
