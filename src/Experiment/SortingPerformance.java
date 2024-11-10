package Experiment;

import Models.*;
import Utils.MergeSort;
import Utils.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class SortingPerformance {

    public static void main(String[] args) {
        int[] datasetSizes = {10000, 100000};  // Large dataset sizes
        for (int largeSize : datasetSizes) {

            // Populate queue with a large number of orders
            List<Book> books = new ArrayList<Book>();
            for (int i = 0; i < largeSize; i++) {
                Book testBook = new Book();
                testBook.title = "Title" + (i + 1);
                Author testAuthor = new Author();
                testAuthor.name = "Author" + (i + 1);
                testBook.author = testAuthor;
                testBook.isbn = "ISBN" + (i + 1);
                books.add(testBook);
            }

            // Profile Quick Sort Performance
            long quickSortStartTime = System.nanoTime();

            QuickSort.sortByAuthor(books, 0, books.size() - 1);

            long quickSortEndTime = System.nanoTime();
            long quickSortDuration = quickSortEndTime - quickSortStartTime;
            System.out.println(
                    "Quick Sort Time for "
                            + largeSize
                            +
                            " items: "
                            + (quickSortDuration / 1_000_000) + " ms");

            long mergeSortISBNStartTime = System.nanoTime();

            MergeSort.sortBooksByISBN(books, 0, books.size() - 1);

            long mergeSortISBNEndTime = System.nanoTime();
            long mergeSortISBNDuration = mergeSortISBNEndTime - mergeSortISBNStartTime;
            System.out.println(
                    "Merge Sort Time for sorting by ISBN for "
                            + largeSize
                            + " items: "
                            + (mergeSortISBNDuration / 1_000_000) + " ms");

            long mergeSortTitleStartTime = System.nanoTime();

            MergeSort.sortBooksByTitle(books, 0, books.size() - 1);

            long mergeSortTitleEndTime = System.nanoTime();
            long mergeSortTitleDuration = mergeSortTitleEndTime - mergeSortTitleStartTime;
            System.out.println(
                    "Merge Sort Time for sorting by Title for "
                            + largeSize
                            + " items: "
                            + (mergeSortTitleDuration / 1_000_000) + " ms");

            long mergeSortOrderNumberStartTime = System.nanoTime();

            OrderQueue orderQueue = new OrderQueue();
            long enqueueStartTime = System.nanoTime();

            // Populate queue with a large number of orders
            for (int i = 0; i < largeSize; i++) {
                Customer testCustomer = new Customer();
                testCustomer.name = "Customer" + (i + 1);
                testCustomer.address = "Address" + (i + 1);
                List<Book> booksOder = new ArrayList<Book>();
                for (int j = 0; j < 5; j++) {
                    Book testBook = new Book();
                    testBook.title = "Title" + (i + 1);
                    Author testAuthor = new Author();
                    testAuthor.name = "Author" + (i + 1);
                    testBook.author = testAuthor;
                    testBook.isbn = "ISBN" + (i + 1);
                    booksOder.add(testBook);
                }
                orderQueue.enqueue(new Order(testCustomer, testCustomer.address, booksOder));
            }
            List<Order> orders = new ArrayList<>(orderQueue.queue);
            MergeSort.sortOrdersByNumber(orders, 0, orders.size() - 1);

            long mergeSortOrderNumberEndTime = System.nanoTime();
            long mergeSortOrderNumberDuration = mergeSortOrderNumberEndTime - mergeSortOrderNumberStartTime;
            System.out.println(
                    "Merge Sort Time for sorting order by number for "
                            + largeSize
                            + " items: "
                            + (mergeSortOrderNumberDuration / 1_000_000) + " ms");
        }
    }
}
