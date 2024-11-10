//package Experiment;
//
//import Models.Order;
//import Models.OrderQueue;
//import Utils.LinearSearch;
//
//class LinearSearchPerformance {
//
//    public static void main(String[] args) {
//        int largeSize = 100000;  // Large dataset size
//        OrderQueue orderQueue = new OrderQueue();
//
//        // Populate queue with a large number of orders
//        for (int i = 1; i <= largeSize; i++) {
//            orderQueue.enqueue(new Order("Customer" + i, "Address" + i, "ORD" + i, new String[]{"Book" + i}));
//        }
//
//        // Profile Linear Search Performance
//        String targetOrderID = "ORD" + largeSize;
//        long searchStartTime = System.nanoTime();
//
//        Order foundOrder = LinearSearch.linearSearch(orderQueue, targetOrderID);
//
//        long searchEndTime = System.nanoTime();
//        long searchDuration = searchEndTime - searchStartTime;
//
//        System.out.println("Linear Search Time for " + largeSize + " items: " + (searchDuration / 1_000_000) + " ms");
//        System.out.println("Order found: " + (foundOrder != null ? foundOrder.customerName : "Order not found"));
//    }
//}
