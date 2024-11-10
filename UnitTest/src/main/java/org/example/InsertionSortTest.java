package org.example;

import Utils.InsertionSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void testInsertionSort() {
        String[] books = {"Algorithms", "Java Basics", "Data Structures"};
        String[] expectedSortedBooks = {"Algorithms", "Data Structures", "Java Basics"};

        InsertionSort.insertionSort(books);
        assertArrayEquals(expectedSortedBooks, books);
    }

    @Test
    void testInsertionSortOnEmptyArray() {
        String[] emptyBooks = new String[0];

        // Sorting an empty array should not cause errors and should return an empty array
        InsertionSort.insertionSort(emptyBooks);
        assertArrayEquals(new String[0], emptyBooks, "Insertion sort on an empty array should return an empty array.");
    }
}
