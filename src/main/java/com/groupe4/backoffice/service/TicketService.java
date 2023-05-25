package com.groupe4.backoffice.service;

import com.groupe4.backoffice.dao.TicketDAO;
import com.groupe4.backoffice.model.ticket.Ticket;

import java.util.List;

public class TicketService {
    public static List<Ticket> fetchAll() {
        return new TicketDAO().fetchAll();
    }

    public static int create(Ticket ticket) {
        return new TicketDAO().create(ticket);
    }
}
