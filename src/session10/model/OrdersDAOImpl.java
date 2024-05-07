package session10.model;

import session10.entities.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDAOImpl implements OrdersDAO {
    Connection conn = MySQLConnectionDB.getMyConnection();
    PreparedStatement pstm = null;

    private final String SQL_GET_ALL_ORDERS = "SELECT * FROM orders";
    private final String SQL_CREATE_ORDER = "INSERT INTO orders VALUES (?,?,?,?) ";
    private final String SQL_GET_ORDER_BY_ID = "SELECT * FROM customer where id=?";

    public OrdersDAOImpl() throws SQLException {
    }

    @Override
    public ArrayList<Order> getAllOrders() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order();
        pstm = conn.prepareStatement(SQL_GET_ALL_ORDERS);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            order.setId(rs.getInt(1));
            order.setCustomerId(rs.getInt(2));
            order.setOrderDate(rs.getDate(3));
            order.setTotal(rs.getInt(4));
            orders.add(order);
        }
        return null;
    }

    @Override
    public void createOrder(Order order) throws SQLException {
        pstm = conn.prepareStatement(SQL_GET_ORDER_BY_ID);
        pstm.setInt(1, order.getId());
        ResultSet rs = pstm.executeQuery();
        if (rs != null) {
            PreparedStatement pstm2 = conn.prepareStatement(SQL_CREATE_ORDER);
            pstm2.setInt(1, order.getId());
            pstm2.setInt(2, order.getCustomerId());
            pstm2.setTimestamp(3, new Timestamp(order.getOrderDate().getTime()));
            pstm2.setDouble(4, order.getTotal());
            pstm2.executeUpdate();
            System.out.println("Order created");
        }
    }
}
