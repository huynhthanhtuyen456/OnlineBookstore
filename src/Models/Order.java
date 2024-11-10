package Models;

import java.util.List;

public class Order {
    public String orderID;
    public Customer customer;
    public String shippingAddress;
    public List<Book> books;

    public Order(Customer customer, String shippingAddress, List<Book> books) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.orderID = "" + (int)(Math.random() * 10000);
        this.books = books;
    }
}
