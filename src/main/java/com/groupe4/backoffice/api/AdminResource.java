package com.groupe4.backoffice.api;

import com.groupe4.backoffice.dto.AdminDto;
import com.groupe4.backoffice.service.AdminService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class AdminResource {
private static AdminService adminService = new AdminService();


        @GET
        @Produces(value = MediaType.APPLICATION_JSON)
        public Response getAll() {
            List<AdminDto> adminList = adminService.findAll();

            return Response
                    .ok(adminList)
                    .build();
        }


    }
}
