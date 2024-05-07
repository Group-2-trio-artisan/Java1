package session9.model;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{
    private static final Connection conn;
    static {
        try {
            conn = MySQLConnectionDB.getMyConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Statement stm = null;
    private PreparedStatement pstm = null;


    @Override
    public Customers findCustomerById(int id) throws SQLException {
        String query = "SELECT * FROM customer WHERE customer_id = ?";
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()) {
            int customerId = rs.getInt("customer_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            return new Customers(customerId, firstName, lastName, email);
        }
        return null;
    }


    @Override
    public ArrayList<Customers> getAllCustomer() throws SQLException {
        String query = "SELECT * FROM customer";
        stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        ArrayList<Customers> customers = new ArrayList<>();
        while(rs.next()) {
            int customerId = rs.getInt("customer_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            customers.add(new Customers(customerId, firstName, lastName, email));
        }
        return customers;
    }
}
