package com.groupe4.backoffice.dao;

import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.ticket.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements GenericDAO<Ticket> {

    @Override
    public int create(Ticket ticket) {
        Connection connection = DB.getConnection();
try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ticket(email, message) values (?,?)", Statement.RETURN_GENERATED_KEYS)){
    preparedStatement.setString(1,ticket.getEmail());
    preparedStatement.setString(2, ticket.getMessage());
    preparedStatement.execute();

} catch (SQLException e) {
    throw new RuntimeException(e);
}
        return 0;
    }

    @Override
    public List<Ticket> fetchAll() {
            Connection connection = DB.getConnection();
            List<Ticket> tickets = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ticket")){
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    tickets.add(
                            new Ticket(
                                    resultSet.getString("email"),
                                    resultSet.getString("message")
                            )
                    );
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return tickets;
        }



    @Override
    public Ticket fetchById(Long id) {
        return null;
    }

    @Override
    public void update(Ticket obj) {

    }

    @Override
    public void delete(Long id) {

    }
}
