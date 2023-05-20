package com.groupe4.backoffice.dao.order;
import com.groupe4.backoffice.dao.GenericDAO;
import com.groupe4.backoffice.dao.ProductDAO;
import com.groupe4.backoffice.model.DB;
import com.groupe4.backoffice.model.order.OrderLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderLineDao implements GenericDAO<OrderLine> {


    public List<OrderLine> fetchByOrderId(Long id) {
        Connection connection = DB.getConnection();
        List<OrderLine> orderLines = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from OrderLine ol LEFT JOIN orders ord on ol.id_order=ord.id where ol.id_order=?")) {
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderLines.add(new OrderLine(
                                resultSet.getInt("id"),
                                new ProductDAO().fetchById(resultSet.getLong("ol.id_product")),
                                resultSet.getInt("quantity")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderLines;
    }


    @Override
    public OrderLine fetchById(Long id) {
        Connection connection = DB.getConnection();
        OrderLine orderLine = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from OrderLine ol where ol.id=?")) {
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderLine = new OrderLine(
                        resultSet.getInt("id"),

                        new ProductDAO().fetchById(
                                resultSet.getLong("ol.id_product")),
                        resultSet.getInt("quantity"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderLine;

    }

    @Override
    public int create(OrderLine obj) {
        return 0;
    }


    @Override
    public List<OrderLine> fetchAll() {
        return null;
    }


    @Override
    public void update(OrderLine obj) {

    }

    @Override
    public void delete(Long id) {

    }
}
