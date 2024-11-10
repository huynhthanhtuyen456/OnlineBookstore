//package Experiment;
//
//import Models.Order;
//import Models.OrderQueue;
//import Utils.LinearSearch;
//
//class LinearSearchPerformanceLarge {
//
//    public static void main(String[] args) {
//        int[] datasetSizes = {10000, 100000, 1000000};  // Large dataset sizes
//
//        for (int size : datasetSizes) {
//            OrderQueue orderQueue = new OrderQueue();
//            System.out.println("Dataset size: " + size);
//
//            // Populate queue with a large number of orders
//            for (int i = 1; i <= size; i++) {
//                orderQueue.enqueue(new Order("Customer" + i, "Address" + i, "ORD" + i, new String[]{"Book" + i}));
//            }
//
//            // Profile Linear Search Performance
//            String targetOrderID = "ORD" + size;
//            long searchStartTime = System.nanoTime();
//
//            Order foundOrder = LinearSearch.linearSearch(orderQueue, targetOrderID);
//
//            long searchEndTime = System.nanoTime();
//            long searchDuration = searchEndTime - searchStartTime;
//
//            System.out.println("Linear Search Time for " + size + " items: " + (searchDuration / 1_000_000) + " ms");
//            System.out.println("Order found: " + (foundOrder != null ? foundOrder.customerName : "Order not found"));
//            System.out.println("------");
//        }
//    }
//}
