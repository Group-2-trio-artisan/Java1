package session10.model;

import session10.entities.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrdersDAO {
    public ArrayList<Order> getAllOrders() throws SQLException;
    public void createOrder(Order order) throws SQLException;
}
