package session10.model;

import session10.entities.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailDAO {
    ArrayList<OrderDetail> getAllOrderDetail() throws SQLException;
}
