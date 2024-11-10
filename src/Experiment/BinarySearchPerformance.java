//package Experiment;
//
//import Models.Order;
//import Utils.BinarySearch;
//
//class BinarySearchPerformance {
//
//    public static void main(String[] args) {
//        int largeSize = 100000;  // Large dataset size
//        Order[] sortedOrders = new Order[largeSize];
//
//        // Populate sorted array with a large number of orders
//        for (int i = 0; i < largeSize; i++) {
//            sortedOrders[i] = new Order("Customer" + (i + 1), "Address" + (i + 1), "ORD" + (i + 1), new String[]{"Book" + (i + 1)});
//        }
//
//        // Profile Binary Search Performance
//        String targetOrderID = "ORD" + largeSize;
//        long searchStartTime = System.nanoTime();
//
//        int foundIndex = BinarySearch.binarySearch(sortedOrders, targetOrderID);
//
//        long searchEndTime = System.nanoTime();
//        long searchDuration = searchEndTime - searchStartTime;
//
//        System.out.println("Binary Search Time for " + largeSize + " items: " + (searchDuration / 1_000_000) + " ms");
//        System.out.println("Order found at index: " + (foundIndex != -1 ? foundIndex : "Order not found"));
//    }
//}
