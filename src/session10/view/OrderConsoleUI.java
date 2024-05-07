package session10.view;

import session10.controller.OrderDetailController;
import session10.entities.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderConsoleUI {
    OrderDetailController orderDetailController = new OrderDetailController();
    private final Scanner sc;

    public OrderConsoleUI() throws SQLException {
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("=====Order Console Menu=====");
        System.out.println("1. Create Order");
        System.out.println("2. Show Order");
        System.out.println("3. Show Order Detail");
        System.out.println("0. Exit");
        int choice = Integer.parseInt(this.sc.nextLine());
        return choice;
    }

    public void OrderDetailUI() throws SQLException{
        ArrayList<OrderDetail> allOrderDetail = orderDetailController.getAllOrderDetail();
        allOrderDetail.forEach((orderDetail) -> {
            System.out.println(orderDetail.getOrderDetailId(1));
            System.out.println(orderDetail.getOrderId(2));
            System.out.println(orderDetail.getProductId(3));
            System.out.println(orderDetail.getQuantity(4));
            System.out.println(orderDetail.getUnitPrice(5));
        });
    }
}
