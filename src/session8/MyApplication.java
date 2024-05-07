package session8;

import java.sql.*;

public class MyApplication {
    public static void main(String[] args) throws SQLException {
        //createCustomer();
        getAllCustomer();
        getCustomerVsPreparedStatement();
    }
    public static void getAllCustomer() throws SQLException {
        //Gọi đối tượng connection(nhấc Object connection đặt vào class này)
        Connection connection = MySQLConnectionDB.getMyConnection();
        //Tạo Statement(Lệnh thực thi với CSDL)
        Statement stm = connection.createStatement();
        //Truy vấn trong CSDL
        String query = "select * from customers";
        //Thực thi truy vấn, trả kết quả về cho đối tượng ResultSet
        //ResultSet là chứa kết quả trả về từ CSDL
        ResultSet rs = stm.executeQuery(query);
        //Đọc bản ghi trên ResultSet
        while (rs.next()){
            //Đọc customer_id có kiểu là int
            int cusId = rs.getInt(1);
            String first_name = rs.getString(2);
            String last_name = rs.getString(3);
            String email = rs.getString(4);
            System.out.println("=========================");
            System.out.println("Customer ID: " + cusId);
            System.out.println("First name: " + first_name);
            System.out.println("Last name: " + last_name);
            System.out.println("Email: " + email);
        }
        connection.close();
    }

    //Thêm bản ghi trong CSDL
    public static void createCustomer() throws SQLException {
        Connection connection = MySQLConnectionDB.getMyConnection();
        Statement stm = connection.createStatement();
        String query = "INSERT INTO customers(customer_id, first_name, last_name, email) VALUE(3, 'NGUYEN', 'THANH NAM' , 'nam@fpt.edu.vn')";
        //Hàm executeUpdate() dùng cho mục đích là INSERT, UPDATE, DELETE
        int count = stm.executeUpdate(query);
        System.out.println(count);
    }

    public static void getCustomerVsPreparedStatement() throws SQLException {
        Connection connection = MySQLConnectionDB.getMyConnection();
        //Truy vấn
        String query = "select * from customers where customer_id = ? and last_name like ?";
        //Tạo đối tượng là PreparedStatement
        PreparedStatement pstm = connection.prepareStatement(query);
        //Thiết lập tham số cho ? đầu tiên(số 1)
        pstm.setInt(1,3);
        //Thiết lập tham số cho ? đầu tiên(số 2)
        pstm.setString(2,"THANH NAM");

        //Kết quả trả về đối tượng ResultSet
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            System.out.println("======= Use PreparedStatement =======");
            System.out.println("Customer ID:" + rs.getInt("customer_id"));
            System.out.println("First_name: " + rs.getString(2));
            System.out.println("Last_name: " + rs.getString(3));
            System.out.println("Email: " + rs.getString("email"));

        }
        connection.close();
    }
}
