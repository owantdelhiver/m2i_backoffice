package com.groupe4.backoffice.api;
import com.groupe4.backoffice.dto.AdminDto;
import com.groupe4.backoffice.service.AdminService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
@Path("/admins")
public class AdminResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getAll() {
        AdminService adminService = new AdminService();
        List<AdminDto> adminList = adminService.findAll();
        return Response
                .ok(adminList)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }
}
