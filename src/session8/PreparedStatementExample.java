package session8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {
    public static void main(String[] args) throws SQLException {
        //get connection
        Connection connection = MySQLConnectionDB.getMyConnection();
        //Create Query(SQL engine)
        String query = "SELECT * FROM customers WHERE customer_id = ? AND first_name like ? ";
        //Create PreparedStatement
        PreparedStatement pstm = connection.prepareStatement(query);
        //Gán giá trị cho tham số theo thứ tự: (?, ?)
        pstm.setInt(1, 1);
        pstm.setString(2, "TRUONG");

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.println("========================");
            System.out.println("Customer ID: " + rs.getInt("customer_id"));
            System.out.println("First Name: " + rs.getString(2));
            System.out.println("Last Name: " + rs.getString(3));
            System.out.println("Email: " + rs.getString("email"));
        }
        connection.close();
    }
}
