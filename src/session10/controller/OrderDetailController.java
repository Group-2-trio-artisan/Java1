package session10.controller;

import session10.entities.Order;
import session10.entities.OrderDetail;
import session10.model.OrderDetailDAOImpl;
import session10.model.OrdersDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailController {
    OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
    OrdersDAOImpl ordersDAO = new OrdersDAOImpl();

    public OrderDetailController() throws SQLException {
    }


    public ArrayList<OrderDetail> getAllOrderDetail() throws SQLException {
        return orderDetailDAO.getAllOrderDetail();
    }
    public void createOrder(Order order) throws SQLException {
        ordersDAO.createOrder(order);
    }
    public ArrayList<Order> getAllOrder() throws SQLException {
        return ordersDAO.getAllOrders();
    }
}
