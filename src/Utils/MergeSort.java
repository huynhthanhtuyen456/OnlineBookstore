package Utils;

import Models.Book;
import Models.Order;

import java.util.List;

public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void mergeOrderList(List<Order> orderList, int l, int m, int r)
    {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        Order[] L = new Order[n1];
        Order[] R = new Order[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = orderList.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = orderList.get(m + 1 + j);

        // Merge the temp arrays

        // Initial indices of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].orderID.compareTo(R[j].orderID) < 0) {
                orderList.set(k, L[i]);
                i++;
            }
            else {
                orderList.set(k, R[j]);
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            orderList.set(k, L[i]);
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            orderList.set(k, R[j]);
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sortOrdersByNumber(List<Order> orderList, int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sortOrdersByNumber(orderList, l, m);
            sortOrdersByNumber(orderList, m + 1, r);

            // Merge the sorted halves
            mergeOrderList(orderList, l, m, r);
        }
    }

    static void mergeBookList(List<Book> books, int l, int m, int r)
    {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        Book[] L = new Book[n1];
        Book[] R = new Book[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = books.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = books.get(m + 1 + j);

        // Merge the temp arrays

        // Initial indices of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].title.compareTo(R[j].title) < 0) {
                books.set(k, L[i]);
                i++;
            }
            else {
                books.set(k, R[j]);
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            books.set(k, L[i]);
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            books.set(k, R[j]);
            j++;
            k++;
        }
    }

    public static void sortBooksByTitle(List<Book> books, int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sortBooksByTitle(books, l, m);
            sortBooksByTitle(books, m + 1, r);

            // Merge the sorted halves
            mergeBookList(books, l, m, r);
        }
    }
}
