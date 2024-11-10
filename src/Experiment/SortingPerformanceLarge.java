//package Experiment;
//
//import Utils.InsertionSort;
//import Utils.QuickSort;
//
//import java.util.Arrays;
//import java.util.Random;
//
//class SortingPerformanceLarge {
//
//    public static void main(String[] args) {
//        int[] datasetSizes = {1000, 10000, 100000};  // Adjusted sizes for sorting
//        for (int size : datasetSizes) {
//            String[] books = generateRandomBooks(size);
//            System.out.println("Dataset size: " + size);
//
//            // Profile Insertion Sort Performance
//            String[] insertionSortBooks = Arrays.copyOf(books, books.length);
//            long insertionSortStartTime = System.nanoTime();
//
//            InsertionSort.insertionSort(insertionSortBooks);
//
//            long insertionSortEndTime = System.nanoTime();
//            long insertionSortDuration = insertionSortEndTime - insertionSortStartTime;
//            System.out.println("Insertion Sort Time for " + size + " items: " + (insertionSortDuration / 1_000_000) + " ms");
//
//            // Profile Quick Sort Performance
//            String[] quickSortBooks = Arrays.copyOf(books, books.length);
//            long quickSortStartTime = System.nanoTime();
//
//            QuickSort.quickSort(quickSortBooks, 0, quickSortBooks.length - 1);
//
//            long quickSortEndTime = System.nanoTime();
//            long quickSortDuration = quickSortEndTime - quickSortStartTime;
//            System.out.println("Quick Sort Time for " + size + " items: " + (quickSortDuration / 1_000_000) + " ms");
//            System.out.println("------");
//        }
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
