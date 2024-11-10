package Experiment;

import Models.Book;
import Models.Customer;
import Models.Order;
import Models.OrderQueue;
import Utils.BinarySearch;
import Utils.MergeSort;

import java.util.ArrayList;
import java.util.List;

class BinarySearchPerformance {

    public static void main(String[] args) {
        int largeSize = 8000;  // Large dataset size

        OrderQueue orderQueue = new OrderQueue();

        // Populate sorted array with a large number of orders
        for (int i = 0; i < largeSize; i++) {
            Customer testCustomer = new Customer();
            testCustomer.name = "Customer" + (i + 1);
            testCustomer.address = "Address" + (i + 1);
            List<Book> books = new ArrayList<Book>();
            for (int j = 0; j < largeSize; j++) {
                Book testBook = new Book();
                testBook.title = "Title" + (i + 1);
                books.add(testBook);
            }
            orderQueue.enqueue(new Order(testCustomer, testCustomer.address, books));
        }

        List<Order> orders = new ArrayList<>(orderQueue.queue);
        MergeSort.sortOrdersByNumber(orders, 0, orders.size() - 1);
        // Profile Binary Search Performance
        String targetOrderID = "ORD" + largeSize;
        long searchStartTime = System.nanoTime();

//        Order foundOrder = BinarySearch.searchOrderByNumber(sortedOrders, targetOrderID);

        Order foundOrder = BinarySearch.searchOrderByNumber(
                orders,
                0,
                orders.size() - 1,
                targetOrderID
        );
        long searchEndTime = System.nanoTime();
        long searchDuration = searchEndTime - searchStartTime;

        System.out.println("Binary Search Time for " + largeSize + " items: " + (searchDuration / 1_000_000) + " ms");
        System.out.println("Order found at index: " + (foundOrder != null ? foundOrder.orderID : "Order not found"));
    }
}
