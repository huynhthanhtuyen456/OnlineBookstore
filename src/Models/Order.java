package Models;

import java.util.List;
import java.util.UUID;

public class Order {
    public String orderID;
    public Customer customer;
    public String shippingAddress;
    public List<Book> books;

    public Order(Customer customer, String shippingAddress, List<Book> books) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.orderID = UUID.randomUUID().toString();
        this.books = books;
    }
}
