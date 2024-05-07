package session10.model;

import session10.entities.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    void addCustomer(Customer c) throws SQLException;
    void updateCustomer(Customer c) throws SQLException;
    void deleteCustomer(Customer c) throws SQLException;
    Customer getCustomerById(int id) throws SQLException;
    ArrayList<Customer> getAllCustomers() throws SQLException;
}
