package session10.entities;

import java.util.Date;

public class Order {
    private int id;
    private int customerId;
    private Date orderDate;
    private int total;

    public Order(int id, int customerId, Date orderDate, int total) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.total = total;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
