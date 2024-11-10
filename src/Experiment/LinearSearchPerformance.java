package Experiment;

import Models.*;
import Utils.LinearSearch;

import java.util.ArrayList;
import java.util.List;

class LinearSearchPerformance {

    public static void main(String[] args) {
        int[] datasetSizes = {10000, 100000, 1000000};  // Large dataset sizes
        for (int largeSize : datasetSizes) {

            OrderQueue orderQueue = new OrderQueue();

            // Populate queue with a large number of orders
            for (int i = 0; i < largeSize; i++) {
                Customer testCustomer = new Customer();
                testCustomer.name = "Customer" + (i + 1);
                testCustomer.address = "Address" + (i + 1);
                List<Book> books = new ArrayList<Book>();
                for (int j = 0; j < 5; j++) {
                    Book testBook = new Book();
                    testBook.title = "Title" + (i + 1);
                    Author testAuthor = new Author();
                    testAuthor.name = "Author" + (i + 1);
                    testBook.author = testAuthor;
                    testBook.isbn = "ISBN" + (i + 1);
                    books.add(testBook);
                }
                orderQueue.enqueue(new Order(testCustomer, testCustomer.address, books));
            }

            // Profile Linear Search Performance
            String targetOrderID = "ORD" + largeSize;
            long searchStartTime = System.nanoTime();
            List<Order> orders = new ArrayList<>(orderQueue.queue);
            System.out.println(orders.get(orders.size() - 1).orderID);
            System.out.println("Searching for " + targetOrderID);
            System.out.println("Searching in " + orders.size() + " orders");

            List<Order> foundOrders = LinearSearch.searchOrder(orders, targetOrderID);
            System.out.println("Found " + foundOrders.size() + " orders");

            long searchEndTime = System.nanoTime();
            long searchDuration = searchEndTime - searchStartTime;

            System.out.println("Linear Search Time for " + largeSize + " items: " + (searchDuration / 1_000_000) + " ms");
            for (Order order : foundOrders) {
                System.out.println("Order found: " + order.orderID);
            }
        }
    }
}
