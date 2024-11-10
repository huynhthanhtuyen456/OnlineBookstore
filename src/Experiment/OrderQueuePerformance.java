//package Experiment;
//
//import Models.Order;
//import Models.OrderQueue;
//
//class OrderQueuePerformance {
//
//    public static void main(String[] args) {
//        int largeSize = 100000;  // Large dataset size
//
//        // Profile Enqueue Performance
//        OrderQueue orderQueue = new OrderQueue();
//        long enqueueStartTime = System.nanoTime();
//
//        for (int i = 1; i <= largeSize; i++) {
//            orderQueue.enqueue(new Order("Customer" + i, "Address" + i, "ORD" + i, new String[]{"Book" + i}));
//        }
//
//        long enqueueEndTime = System.nanoTime();
//        long enqueueDuration = enqueueEndTime - enqueueStartTime;
//        System.out.println("Enqueue Time for " + largeSize + " items: " + (enqueueDuration / 1_000_000) + " ms");
//
//        // Profile Dequeue Performance
//        long dequeueStartTime = System.nanoTime();
//
//        while (!orderQueue.isEmpty()) {
//            orderQueue.dequeue();
//        }
//
//        long dequeueEndTime = System.nanoTime();
//        long dequeueDuration = dequeueEndTime - dequeueStartTime;
//        System.out.println("Dequeue Time for " + largeSize + " items: " + (dequeueDuration / 1_000_000) + " ms");
//    }
//}
