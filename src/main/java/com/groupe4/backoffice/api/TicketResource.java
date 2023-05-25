package com.groupe4.backoffice.api;

import com.groupe4.backoffice.dto.AdminDto;
import com.groupe4.backoffice.model.ticket.Ticket;
import com.groupe4.backoffice.service.AdminService;
import com.groupe4.backoffice.service.TicketService;
import com.groupe4.backoffice.servlet.product_category.CreateCategoryServlet;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@Path("/tickets")
public class TicketResource {


        @POST
        @Produces(value = MediaType.APPLICATION_JSON)
        public Response getAll() {
            List<Ticket> ticketList = TicketService.fetchAll();

            return Response
                    .ok(ticketList)
                    .header("Access-Control-Allow-Origin", "http://localhost:8081")
                    .build();
        }
    @POST
    @Path("/create")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response create(Ticket ticket) {
    TicketService.create(ticket);

        return Response
                .ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8081")
                .build();
    }
    }

