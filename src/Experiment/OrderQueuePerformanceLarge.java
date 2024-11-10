//package Experiment;
//
//import Models.Order;
//import Models.OrderQueue;
//
//class OrderQueuePerformanceLarge {
//
//    public static void main(String[] args) {
//        int[] datasetSizes = {10000, 100000, 1000000};  // Large dataset sizes
//
//        for (int size : datasetSizes) {
//            OrderQueue orderQueue = new OrderQueue();
//            System.out.println("Dataset size: " + size);
//
//            // Profile Enqueue Performance
//            long enqueueStartTime = System.nanoTime();
//
//            for (int i = 1; i <= size; i++) {
//                orderQueue.enqueue(new Order("Customer" + i, "Address" + i, "ORD" + i, new String[]{"Book" + i}));
//            }
//
//            long enqueueEndTime = System.nanoTime();
//            long enqueueDuration = enqueueEndTime - enqueueStartTime;
//            System.out.println("Enqueue Time for " + size + " items: " + (enqueueDuration / 1_000_000) + " ms");
//
//            // Profile Dequeue Performance
//            long dequeueStartTime = System.nanoTime();
//
//            while (!orderQueue.isEmpty()) {
//                orderQueue.dequeue();
//            }
//
//            long dequeueEndTime = System.nanoTime();
//            long dequeueDuration = dequeueEndTime - dequeueStartTime;
//            System.out.println("Dequeue Time for " + size + " items: " + (dequeueDuration / 1_000_000) + " ms");
//            System.out.println("------");
//        }
//    }
//}
