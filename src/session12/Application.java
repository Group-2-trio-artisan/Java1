package session12;

import session12.View.View;
import session12.controller.Controller;
import session12.entity.Product;
import session12.model.GenericDAO;
import session12.model.ProductDAOImpl;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        GenericDAO<Product> ProductDAOImpl = new ProductDAOImpl();
        Controller<Product> productController = new Controller<>(ProductDAOImpl);
        View view = new View(productController);
        view.start();
    }
}
