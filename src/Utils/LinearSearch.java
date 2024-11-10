package Utils;

import Models.Book;
import Models.Order;
import Models.OrderQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinearSearch {
    public static List<Order> searchOrder(List<Order> orders, String query) {
        List<Order> result = new ArrayList<>();
        if (orders == null) {
            throw new IllegalArgumentException("Queue cannot be null.");
        }
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Search query cannot be null or empty.");
        }

        for (Order order : orders) {
            if (order.orderID.equals(query)) {
                result.add(order);
            } else {
                List<Book> searchResults = LinearSearch.searchBook(order.books, query);
                if (!searchResults.isEmpty()) {
                    result.add(order);
                }
            }
        }
        return result;
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
