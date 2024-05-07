package session10.view;

import session10.controller.ProductController;
import session10.entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductConsoleUI {
    //Step 1 call controller
    ProductController productController = new ProductController();
    //Fields
    private final Scanner sc;
    public ProductConsoleUI() throws SQLException {
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("====Product Management====");
        System.out.println("1. All product");
        System.out.println("2. Create product");
        System.out.println("3. Search product by ID");
        System.out.println("4. Update product");
        System.out.println("5. Delete product");
        System.out.println("0. Exit product");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    public void getAllProductUI() throws SQLException{
        //Step 4
        ArrayList<Product> allProduct = productController.getAllProductController();
        allProduct.forEach((product)->{
            System.out.println("=====Product Details=====");
            System.out.println(product.getProductId());
            System.out.println(product.getProductName());
            System.out.println(product.getProductDesc());
            System.out.println(product.getPrice());
        });
    }
    public void createProduct() throws SQLException{
        System.out.println("Enter id: ");
        int prod_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter product name : ");
        String name = sc.nextLine();
        System.out.println("Enter product desc : ");
        String product_desc = sc.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        Product product = new Product(prod_id,name,product_desc,price);
        productController.createProductController(product);
    }
    public void getProductById() throws SQLException{
        System.out.println("Enter product id: ");
        int prod_id = Integer.parseInt(sc.nextLine());
        Product product = productController.getProductByIdController(prod_id);
        if (product!= null) {
            System.out.println("=====Product Details=====");
            System.out.println(product.getProductId());
            System.out.println(product.getProductName());
            System.out.println(product.getProductDesc());
            System.out.println(product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }
    public void updateProduct() throws SQLException{
        try {
            System.out.println("Enter product id: ");
            int prod_id = Integer.parseInt(sc.nextLine());
            Product product = productController.getProductByIdController(prod_id);
            if (product!= null) {
                System.out.print("Enter new product name: ");
                String newProductName = sc.nextLine();
                System.out.print("Enter new product description: ");
                String newProductDesc = sc.next();
                System.out.println("Enter new product price: ");
                double newPrice = Integer.parseInt(sc.nextLine());
                product.setProductName(newProductName);
                product.setProductDesc(newProductDesc);
                product.setPrice(newPrice);
                productController.updateProductController(product);
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProduct() throws SQLException{
        System.out.println("Enter product id: ");
        int prod_id = Integer.parseInt(sc.nextLine());
        productController.deleteProductController(prod_id);
    }
    public void start() throws SQLException{
        while (true){
            int choice = menu();
            switch (choice){
                case 0: System.exit(0);break;
                case 1: getAllProductUI();break;
                case 2: createProduct();break;
                case 3: getProductById();break;
                case 4: updateProduct();break;
                case 5: deleteProduct();break;
                default: throw new AssertionError();
            }
        }
    }
}
