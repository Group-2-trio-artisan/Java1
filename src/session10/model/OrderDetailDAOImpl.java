package session10.model;

import session10.entities.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    Connection conn = MySQLConnectionDB.getMyConnection();
    PreparedStatement pstm = null;
    private String SQL_GET_ALL_ORDERDETAIL = "SELECT * FROM orderdetail";

    public OrderDetailDAOImpl() throws SQLException {
    }

    @Override
    public ArrayList<OrderDetail> getAllOrderDetail() throws SQLException {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        pstm = conn.prepareStatement(SQL_GET_ALL_ORDERDETAIL);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.getOrderDetailId(rs.getInt(1));
            orderDetail.getOrderId(rs.getInt(2));
            orderDetail.getProductId(rs.getInt(3));
            orderDetail.getQuantity(rs.getInt(4));
            orderDetail.getUnitPrice(rs.getDouble(5));
        }
        return orderDetails;
    }
}
