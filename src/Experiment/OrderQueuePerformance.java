package Experiment;

import Models.*;

import java.util.ArrayList;
import java.util.List;

class OrderQueuePerformance {

    public static void main(String[] args) {
        int[] datasetSizes = {10000, 100000, 1000000};  // Large dataset sizes
        for (int largeSize : datasetSizes) {
            // Profile Enqueue Performance
            OrderQueue orderQueue = new OrderQueue();
            long enqueueStartTime = System.nanoTime();

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

            long enqueueEndTime = System.nanoTime();
            long enqueueDuration = enqueueEndTime - enqueueStartTime;
            System.out.println("Enqueue Time for " + largeSize + " items: " + (enqueueDuration / 1_000_000) + " ms");

            // Profile Dequeue Performance
            long dequeueStartTime = System.nanoTime();

            while (!orderQueue.isEmpty()) {
                orderQueue.dequeue();
            }

            long dequeueEndTime = System.nanoTime();
            long dequeueDuration = dequeueEndTime - dequeueStartTime;
            System.out.println("Dequeue Time for " + largeSize + " items: " + (dequeueDuration / 1_000_000) + " ms");
        }
    }
}
