package session10.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderManagement {
    public void createOrder()throws SQLException{
        Connection conn = MySQLConnectionDB.getMyConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn.setAutoCommit(false);// Đánh dấu điểm bắt đầu của Transaction
        String orderQuery = "insert into orders values(?,?,?,?,?)";
        String orderDetailQuery = "";
    }
}
