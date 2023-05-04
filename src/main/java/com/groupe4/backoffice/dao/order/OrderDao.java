package com.groupe4.backoffice.dao.order;
import com.groupe4.backoffice.dao.GenericDAO;
import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.order.Order;
import com.groupe4.backoffice.model.order.OrderStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OrderDao implements GenericDAO<Order> {
    @Override
    public List<Order> fetchAll() {
        Connection connection = DB.getConnection();
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order`")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(
                        new Order(
                                resultSet.getInt("id"),
                                resultSet.getDate("date"),
                                OrderStatus.getFromLabel(resultSet.getString("status"))
                        ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    @Override
    public void create(Order obj) {

    }
    @Override
    public Order fetchById(Long id) {

        Connection connection = DB.getConnection();
        Order order = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from `order` o where o.id=?")) {
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getDate("date"),
                        OrderStatus.getFromLabel(resultSet.getString("status")),
                        new OrderLineDao().fetchByOrderId(resultSet.getLong("id")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public void update(Order obj) {

    }
    @Override
    public void delete(Long id) {

    }
}
