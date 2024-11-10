package Utils;

import Models.Book;
import Models.Order;
import Models.OrderQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinearSearch {
    public static Order linearSearch(OrderQueue queue, String orderID) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null.");
        }
        if (orderID == null || orderID.isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty.");
        }

        for (Order order : queue.queue) {
            if (order.orderID.equals(orderID)) {
                return order;
            }
        }
        return null;
    }

    public static List<Book> searchBook(List<Book> books, String query) {
        List<Book> booksToSearch = new ArrayList<>();
        if (books == null) {
            throw new IllegalArgumentException("Books list cannot be null.");
        }
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Book Title cannot be null or empty.");
        }

        for (Book book : books) {
            if (book.title.contains(query) || book.author.name.contains(query) || book.isbn.contains(query)) {
                booksToSearch.add(book);
            }
        }
        return booksToSearch;
    }
}
