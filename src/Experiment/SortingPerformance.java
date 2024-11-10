//package Experiment;
//
//import Utils.InsertionSort;
//import Utils.QuickSort;
//
//import java.util.Arrays;
//import java.util.Random;
//
//class SortingPerformance {
//
//    public static void main(String[] args) {
//        int largeSize = 10000;  // Adjust as needed
//        String[] books = generateRandomBooks(largeSize);
//
//        // Profile Insertion Sort Performance
//        String[] insertionSortBooks = Arrays.copyOf(books, books.length);
//        long insertionSortStartTime = System.nanoTime();
//
//        InsertionSort.insertionSort(insertionSortBooks);
//
//        long insertionSortEndTime = System.nanoTime();
//        long insertionSortDuration = insertionSortEndTime - insertionSortStartTime;
//        System.out.println("Insertion Sort Time for " + largeSize + " items: " + (insertionSortDuration / 1_000_000) + " ms");
//
//        // Profile Quick Sort Performance
//        String[] quickSortBooks = Arrays.copyOf(books, books.length);
//        long quickSortStartTime = System.nanoTime();
//
//        QuickSort.quickSort(quickSortBooks, 0, quickSortBooks.length - 1);
//
//        long quickSortEndTime = System.nanoTime();
//        long quickSortDuration = quickSortEndTime - quickSortStartTime;
//        System.out.println("Quick Sort Time for " + largeSize + " items: " + (quickSortDuration / 1_000_000) + " ms");
//    }
//
//    private static String[] generateRandomBooks(int size) {
//        String[] books = new String[size];
//        Random random = new Random();
//        for (int i = 0; i < size; i++) {
//            books[i] = "Book" + random.nextInt(size);
//        }
//        return books;
//    }
//}
