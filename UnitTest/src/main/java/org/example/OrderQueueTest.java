package org.example;

import Models.OrderQueue;
import Models.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderQueueTest {

    @Test
    void testEnqueueDequeue() {
        OrderQueue orderQueue = new OrderQueue();

        Order order1 = new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"});
        Order order2 = new Order("Bob", "456 Park Ave", "ORD002", new String[]{"Data Structures"});

        orderQueue.enqueue(order1);
        orderQueue.enqueue(order2);

        assertEquals(2, orderQueue.size());

        // Dequeue and check the first order
        Order dequeuedOrder = orderQueue.dequeue();
        assertEquals("Alice", dequeuedOrder.customerName);
        assertEquals(1, orderQueue.size());

        // Dequeue and check the second order
        dequeuedOrder = orderQueue.dequeue();
        assertEquals("Bob", dequeuedOrder.customerName);
        assertTrue(orderQueue.isEmpty());
    }

    @Test
    void testEnqueueNullOrder() {
        OrderQueue orderQueue = new OrderQueue();

        // Verify that enqueueing a null order throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> orderQueue.enqueue(null), "Cannot enqueue a null order.");
    }

    @Test
    void testDequeueFromEmptyQueue() {
        OrderQueue orderQueue = new OrderQueue();

        // Verify that dequeuing from an empty queue throws an IllegalStateException
        assertThrows(IllegalStateException.class, orderQueue::dequeue, "Cannot dequeue from an empty queue.");
    }

    @Test
    void testEnqueueDequeueLargeDataset() {
        OrderQueue orderQueue = new OrderQueue();
        int largeSize = 10000;

        // Enqueue a large number of orders
        for (int i = 1; i <= largeSize; i++) {
            orderQueue.enqueue(new Order("Customer" + i, "Address" + i, "ORD" + i, new String[]{"Book" + i}));
        }

        assertEquals(largeSize, orderQueue.size());

        // Dequeue all orders and ensure the queue empties correctly
        for (int i = 1; i <= largeSize; i++) {
            Order order = orderQueue.dequeue();
            assertEquals("ORD" + i, order.orderID);
        }

        // Queue should be empty after all dequeues
        assertTrue(orderQueue.isEmpty());
    }

    @Test
    void testSizeOfEmptyQueue() {
        OrderQueue orderQueue = new OrderQueue();

        // The size of an empty queue should be zero
        assertEquals(0, orderQueue.size());
    }

    @Test
    void testIsEmptyOnNewQueue() {
        OrderQueue orderQueue = new OrderQueue();

        // isEmpty() should return true for a new, empty queue
        assertTrue(orderQueue.isEmpty());
    }
}

