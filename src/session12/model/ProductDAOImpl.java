package session12.model;

import session10.model.MySQLConnectionDB;
import session12.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements GenericDAO<Product> {
    private final Connection conn = MySQLConnectionDB.getMyConnection();
    private final String SQL_CREATE_PRODUCT = "insert into products values(?,?,?,?)";
    private final String SQL_GET_By_ID= "select * from products where product_id = ?";
    private final String SQL_GET_All_PRODUCT= "select * from products";
    private final String SQL_DELETE_PRODUCT = "delete from products where product_id = ?";
    private final String SQL_UPDATE_PRODUCT = "update products where product_id = ?";
    PreparedStatement pstm = null;

    public ProductDAOImpl() throws SQLException {
    }

    @Override
    public void create(Product entity) throws SQLException {
        pstm = conn.prepareStatement(SQL_CREATE_PRODUCT);
        pstm.setInt(1, entity.getId());
        pstm.setString(2,entity.getName());
        pstm.setString(3,entity.getDescription());
        pstm.setDouble(4,entity.getPrice());
        pstm.executeUpdate();
        System.out.println("Insert success");
    }

    @Override
    public Product getById(int id) throws SQLException {
        pstm = conn.prepareStatement(SQL_GET_By_ID);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt("product_id"));
            product.setName(rs.getString("product_name"));
            product.setDescription(rs.getString("product_desc"));
            product.setPrice(rs.getDouble("price"));
            return product;
        }
        return null;
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> allProducts = new ArrayList<>();
        pstm = conn.prepareStatement(SQL_GET_All_PRODUCT);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setDescription(rs.getString(3));
            product.setPrice(rs.getDouble(4));
            allProducts.add(product);
        }
        return allProducts;
    }

    @Override
    public void update(Product entity) throws SQLException {
        pstm = conn.prepareStatement(SQL_UPDATE_PRODUCT);
        pstm.setInt(1,entity.getId());
        pstm.setString(2,entity.getName());
        pstm.setString(3,entity.getDescription());
        pstm.setDouble(4,entity.getPrice());
        pstm.executeUpdate();
        System.out.println("Update success");
    }

    @Override
    public boolean delete(int id) throws SQLException {
        pstm = conn.prepareStatement(SQL_DELETE_PRODUCT);
        pstm.setInt(1,id);
        pstm.executeUpdate();
        System.out.println("Delete success");
        return false;
    }

    @Override
    public List<Product> findByName(String name) throws SQLException {

        return List.of();
    }
}
