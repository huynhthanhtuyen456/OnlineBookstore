//package Experiment;
//
//import Models.Order;
//import Utils.BinarySearch;
//
//class BinarySearchPerformanceLarge {
//
//    public static void main(String[] args) {
//        int[] datasetSizes = {10000, 100000, 1000000};  // Large dataset sizes
//
//        for (int size : datasetSizes) {
//            Order[] sortedOrders = new Order[size];
//            System.out.println("Dataset size: " + size);
//
//            // Populate sorted array with a large number of orders
//            for (int i = 0; i < size; i++) {
//                sortedOrders[i] = new Order("Customer" + (i + 1), "Address" + (i + 1), "ORD" + (i + 1), new String[]{"Book" + (i + 1)});
//            }
//
//            // Profile Binary Search Performance
//            String targetOrderID = "ORD" + size;
//            long searchStartTime = System.nanoTime();
//
//            int foundIndex = BinarySearch.binarySearch(sortedOrders, targetOrderID);
//
//            long searchEndTime = System.nanoTime();
//            long searchDuration = searchEndTime - searchStartTime;
//
//            System.out.println("Binary Search Time for " + size + " items: " + (searchDuration / 1_000_000) + " ms");
//            System.out.println("Order found at index: " + (foundIndex != -1 ? foundIndex : "Order not found"));
//            System.out.println("------");
//        }
//    }
//}
