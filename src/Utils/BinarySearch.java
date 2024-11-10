package Utils;

import Models.Book;
import Models.Order;

import java.util.List;

public class BinarySearch {
//    public static Order searchOrderByNumber(List<Order> orders, String orderID) {
//        if (orders == null) {
//            throw new IllegalArgumentException("Order array cannot be null.");
//        }
//        if (orderID == null || orderID.isEmpty()) {
//            throw new IllegalArgumentException("Order ID cannot be null or empty.");
//        }
//
//        int low = 0;
//        int high = orders.size() - 1;
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            int result = orders.get(mid).orderID.compareTo(orderID);
//
//            if (result == 0) {
//                return orders.get(mid);
//            }
//            if (result < 0) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return null;  // Order ID not found
//    }

    public static Order searchOrderByNumber(List<Order> orders, int low, int high, String orderID)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If the element is present at the
            // middle itself
            if (orders.get(mid).orderID.compareTo(orderID) == 0)
                return orders.get(mid);

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (orders.get(mid).orderID.compareTo(orderID) > 0)
                return searchOrderByNumber(orders, low, mid - 1, orderID);

            // Else the element can only be present
            // in right subarray
            return searchOrderByNumber(orders, mid + 1, high, orderID);
        }

        // We reach here when element is not present
        // in array
        return null;
    }

//    public static Order searchOrder(List<Order> orders, int low, int high, String query)
//    {
//        if (high >= low) {
//            int mid = low + (high - low) / 2;
//
//            // If the element is present at the
//            // middle itself
//            if (orders.get(mid).orderID.compareTo(query) == 0)
//                return orders.get(mid);
//
//            // If element is smaller than mid, then
//            // it can only be present in left subarray
//            if (orders.get(mid).orderID.compareTo(query) > 0)
//                return searchOrder(orders, low, mid - 1, query);
//
//            // Else the element can only be present
//            // in right subarray
//            return searchOrder(orders, mid + 1, high, query);
//        }
//
//        // We reach here when element is not present
//        // in array
//        return null;
//    }

    public static Book findBookByISBN(List<Book> books, String isbn) {
        if (books == null) {
            throw new IllegalArgumentException("Book list cannot be null.");
        }
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("Book ISBN cannot be null or empty.");
        }

        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = books.get(mid).isbn.compareTo(isbn);

            if (result == 0) {
                return books.get(mid);
            }
            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;  // Book ISBN not found
    }
}
