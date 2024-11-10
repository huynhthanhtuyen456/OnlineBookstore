package org.example;

import Models.Order;
import Utils.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void testBinarySearch() {
        Order[] sortedOrders = {
                new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"}),
                new Order("Bob", "456 Park Ave", "ORD002", new String[]{"Data Structures"}),
                new Order("Charlie", "789 Oak St", "ORD003", new String[]{"Operating Systems"})
        };

        // Search for an existing order
        int foundIndex = BinarySearch.binarySearch(sortedOrders, "ORD002");
        assertEquals(1, foundIndex);
        assertEquals("Bob", sortedOrders[foundIndex].customerName);

        // Search for a non-existent order
        int notFoundIndex = BinarySearch.binarySearch(sortedOrders, "ORD004");
        assertEquals(-1, notFoundIndex);
    }


    @Test
    void testBinarySearchWithNullArray() {
        // Verify that searching in a null array throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearch(null, "ORD001"), "Order array cannot be null.");
    }

    @Test
    void testBinarySearchWithNullOrderID() {
        Order[] sortedOrders = {
                new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"}),
                new Order("Bob", "456 Park Ave", "ORD002", new String[]{"Data Structures"})
        };

        // Verify that a null orderID throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearch(sortedOrders, null), "Order ID cannot be null or empty.");
    }

    @Test
    void testBinarySearchWithEmptyOrderID() {
        Order[] sortedOrders = {
                new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"}),
                new Order("Bob", "456 Park Ave", "ORD002", new String[]{"Data Structures"})
        };

        // Verify that an empty orderID throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearch(sortedOrders, ""), "Order ID cannot be null or empty.");
    }

    @Test
    void testBinarySearchLargeDataset() {
        int largeSize = 10000;
        Order[] sortedOrders = new Order[largeSize];

        // Populate the array with sorted orders
        for (int i = 0; i < largeSize; i++) {
            sortedOrders[i] = new Order("Customer" + (i + 1), "Address" + (i + 1), "ORD" + (i + 1), new String[]{"Book" + (i + 1)});
        }

        // Search for an order ID in the middle of the array
        int middleIndex = largeSize / 2;
        int foundIndex = BinarySearch.binarySearch(sortedOrders, "ORD" + (middleIndex + 1));
        assertEquals(middleIndex, foundIndex);
        assertEquals("ORD" + (middleIndex + 1), sortedOrders[foundIndex].orderID);

        // Search for an order ID at the end of the array
        int lastIndex = largeSize - 1;
        foundIndex = BinarySearch.binarySearch(sortedOrders, "ORD" + largeSize);
        assertEquals(lastIndex, foundIndex);
        assertEquals("ORD" + largeSize, sortedOrders[foundIndex].orderID);

        // Search for a non-existent order ID
        int notFoundIndex = BinarySearch.binarySearch(sortedOrders, "ORD" + (largeSize + 1));
        assertEquals(-1, notFoundIndex);
    }

    @Test
    void testBinarySearchOnEmptyArray() {
        Order[] emptyOrders = new Order[0];

        // Searching in an empty array should return -1
        int result = BinarySearch.binarySearch(emptyOrders, "ORD001");
        assertEquals(-1, result, "Binary search on an empty array should return -1.");
    }

    @Test
    void testBinarySearchForNonExistentOrder() {
        Order[] sortedOrders = {
                new Order("Alice", "123 Main St", "ORD001", new String[]{"Java Basics"}),
                new Order("Bob", "456 Park Ave", "ORD002", new String[]{"Data Structures"})
        };

        // Searching for a non-existent order ID should return -1
        int result = BinarySearch.binarySearch(sortedOrders, "ORD999");
        assertEquals(-1, result, "Binary search for a non-existent order should return -1.");
    }
}

