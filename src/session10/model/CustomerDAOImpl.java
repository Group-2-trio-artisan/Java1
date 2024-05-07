package session10.model;

import session10.entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    private final Connection conn = MySQLConnectionDB.getMyConnection();
    PreparedStatement pstm = null;
    private final String SQL_CREATE_CUSTOMER = "insert into customer values(?,?,?,?,?)";
    private final String SQL_GET_BY_ID= "select * from customer where customer_id = ?";
    private final String SQL_GET_All_CUSTOMER= "select * from customer";
    private final String SQL_DELETE_CUSTOMER = "delete from customer where customer_id = ?";
    private final String SQL_UPDATE_CUSTOMER = "update customer set first_name = ?, last_name = ?, email = ?, phone = ? where product_id = ?";

    public CustomerDAOImpl() throws SQLException {
    }

    @Override
    public void addCustomer(Customer c) throws SQLException {
    }

    @Override
    public void updateCustomer(Customer c) throws SQLException {
    }

    @Override
    public void deleteCustomer(Customer c) throws SQLException {

    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws SQLException {
        pstm = conn.prepareStatement(SQL_GET_All_CUSTOMER);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Customer> customers = new ArrayList<>();
        while (rs.next()) {
            Customer c = new Customer();
            c.getCus_id(rs.getInt(1));
            c.setFirstName(rs.getString(2));
            c.setLastName(rs.getString(3));
            c.setEmail(rs.getString(4));
            c.setPhone(rs.getInt(5));
            customers.add(c);
        }
        return customers;
    }
}
