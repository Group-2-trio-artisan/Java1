package session10.model;

import session10.entities.OrderDetail;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class OrderManagement {
    public void createOrder()throws SQLException{
        Connection conn = MySQLConnectionDB.getMyConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn.setAutoCommit(false);// Đánh dấu điểm bắt đầu của Transaction
        String orderQuery = "insert into orders values(?,?,?,?,?)";
        String orderDetailQuery = "insert into details values(?,?,?,?,?)";
        //insert đối với bảng chính tăng tự động
        pstm = conn.prepareStatement(orderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, 1);
        pstm.setTimestamp(2, new Timestamp(new Date().getTime()));
        pstm.setTimestamp(3, new Timestamp(new Date().getTime()));
        pstm.setString(4, "Credit card");
        pstm.executeUpdate();
        // lay ra key moi generated tu insert orders
        rs = pstm.getGeneratedKeys();
        int orderId = -1;
        if(rs.next()){
            orderId = rs.getInt(1);
        }
        if (orderId != -1) {
            //insert orderDetails
            pstm = conn.prepareStatement(orderDetailQuery);
//            for (OrderDetail orderDetail : orderDetails) {
//                pstm.setInt(1, orderId);
//                pstm.setTimestamp(2, new Timestamp(new Date().getTime()));
//                pstm.setTimestamp(3, new Timestamp(new Date().getTime()));
//                pstm.addBatch();
//            }
            pstm.executeBatch();// Thuc thi cac Batch(insert nhieu ban ghi cung)
        }
        conn.commit();// Đánh dấu giao dịch(Transaction) thành công

    }
}
