package session12.View;

import session12.controller.Controller;
import session12.entity.Product;
import session12.model.Model;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class View {
    Model<Product> productModel = new Model<>();
    Controller<Product> productController = new Controller<>(productModel);

    public View() throws SQLException {
        this.productController = productController;
    }
    private final Scanner sc = new Scanner(System.in);


    public void viewAllProductsUI() throws SQLException {
        List<Product> allProducts = productController.getAllEntities();
        allProducts.forEach((product)->{
            System.out.println("=====Product Details=====");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }
    public void addNewProductUI() throws SQLException, IllegalAccessException {
        System.out.println("Enter product name : ");
        String name = sc.nextLine();
        System.out.println("Enter product desc : ");
        String product_desc = sc.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        Product product = new Product(name,product_desc,price);
        productController.addEntity(product);
    }
    public void updateProductUI() throws SQLException {
        System.out.println("Enter product ID to edit: ");
        int bookId = Integer.parseInt(this.sc.nextLine());
        Product product = productController.getById(bookId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Enter new Name: ");
        String name = this.sc.nextLine();
        if (!name.isEmpty()) {
            product.setName(name);
        }

        System.out.println("Enter new Description: ");
        String des = this.sc.nextLine();
        if (!des.isEmpty()) {
            product.setDescription(des);
        }

        System.out.println("Enter new Price: ");
        String price = this.sc.nextLine();
        if (!price.isEmpty()) {
            double productPrice = Double.parseDouble(price);
            product.setPrice(productPrice);
        }

        productController.updateEntity(product);
    }

    public void deleteProductUI() throws SQLException {
        System.out.println("Enter product ID to delete: ");
        int bookId = Integer.parseInt(this.sc.nextLine());

    }
    private int menu(){
        System.out.println("====Product Management====");
        System.out.println("1. Create product");
        System.out.println("2. All product");
        System.out.println("3. Update product");
        System.out.println("0. Exit product");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    public void start() throws SQLException, IllegalAccessException {
        while (true){
            int choice = menu();
            switch (choice){
                case 0: System.exit(0);break;
                case 1: addNewProductUI();break;
                case 2: viewAllProductsUI();break;
                case 3: updateProductUI();break;
                default: throw new AssertionError();
            }
        }
    }
}
