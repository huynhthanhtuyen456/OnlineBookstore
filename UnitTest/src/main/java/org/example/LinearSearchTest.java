package org.example;

import Models.Order;
import Models.OrderQueue;
import Utils.LinearSearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    void testLinearSearch() {
        OrderQueue orderQueue = new OrderQueue();
        Order order1 = new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"});
        Order order2 = new Order("Bob", "456 Park Ave", "ORD002", new String[]{"Data Structures"});

        orderQueue.enqueue(order1);
        orderQueue.enqueue(order2);

        // Search for an existing order
        Order foundOrder = LinearSearch.linearSearch(orderQueue, "ORD001");
        assertNotNull(foundOrder);
        assertEquals("Alice", foundOrder.customerName);

        // Search for a non-existent order
        Order nonExistentOrder = LinearSearch.linearSearch(orderQueue, "ORD003");
        assertNull(nonExistentOrder);
    }

    @Test
    void testLinearSearchWithNullQueue() {
        // Verify that searching in a null queue throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> LinearSearch.linearSearch(null, "ORD001"), "Queue cannot be null.");
    }

    @Test
    void testLinearSearchWithNullOrderID() {
        OrderQueue orderQueue = new OrderQueue();
        orderQueue.enqueue(new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"}));

        // Verify that a null orderID throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> LinearSearch.linearSearch(orderQueue, null), "Order ID cannot be null or empty.");
    }

    @Test
    void testLinearSearchWithEmptyOrderID() {
        OrderQueue orderQueue = new OrderQueue();
        orderQueue.enqueue(new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"}));

        // Verify that an empty orderID throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> LinearSearch.linearSearch(orderQueue, ""), "Order ID cannot be null or empty.");
    }

    @Test
    void testLinearSearchLargeDataset() {
        OrderQueue orderQueue = new OrderQueue();
        int largeSize = 10000;

        // Enqueue a large number of orders
        for (int i = 1; i <= largeSize; i++) {
            orderQueue.enqueue(new Order("Customer" + i, "Address" + i, "ORD" + i, new String[]{"Book" + i}));
        }

        // Search for an order ID near the end of the queue
        Order foundOrder = LinearSearch.linearSearch(orderQueue, "ORD" + largeSize);
        assertNotNull(foundOrder);
        assertEquals("ORD" + largeSize, foundOrder.orderID);

        // Search for a non-existent order ID
        Order nonExistentOrder = LinearSearch.linearSearch(orderQueue, "ORD" + (largeSize + 1));
        assertNull(nonExistentOrder);
    }

    @Test
    void testLinearSearchOnEmptyQueue() {
        OrderQueue orderQueue = new OrderQueue();

        // Searching in an empty queue should return null
        Order result = LinearSearch.linearSearch(orderQueue, "ORD001");
        assertNull(result, "Search in an empty queue should return null.");
    }

    @Test
    void testLinearSearchForNonExistentOrder() {
        OrderQueue orderQueue = new OrderQueue();
        orderQueue.enqueue(new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"}));

        // Searching for a non-existent order ID should return null
        Order result = LinearSearch.linearSearch(orderQueue, "ORD999");
        assertNull(result, "Search for a non-existent order should return null.");
    }
}

