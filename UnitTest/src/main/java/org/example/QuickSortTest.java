package org.example;

import Utils.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testQuickSort() {
        String[] books = {"Operating Systems", "Algorithms", "Java Basics", "Data Structures"};
        String[] expectedSortedBooks = {"Algorithms", "Data Structures", "Java Basics", "Operating Systems"};

        QuickSort.quickSort(books, 0, books.length - 1);
        assertArrayEquals(expectedSortedBooks, books);
    }

    @Test
    void testQuickSortOnEmptyArray() {
        String[] emptyBooks = new String[0];

        // Sorting an empty array should not cause errors and should return an empty array
        QuickSort.quickSort(emptyBooks, 0, emptyBooks.length - 1);
        assertArrayEquals(new String[0], emptyBooks, "Quick sort on an empty array should return an empty array.");
    }

    @Test
    void testQuickSortOnSingleElementArray() {
        String[] singleBook = {"Algorithms"};

        // Sorting an array with a single element should return the same array
        QuickSort.quickSort(singleBook, 0, singleBook.length - 1);
        assertArrayEquals(new String[]{"Algorithms"}, singleBook, "Quick sort on a single element array should return the same array.");
    }
}