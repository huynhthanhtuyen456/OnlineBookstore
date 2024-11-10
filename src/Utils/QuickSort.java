package Utils;

import Models.Book;

import java.util.List;

public class QuickSort {
    public static void sortByAuthor(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partitionByAuthor(books, low, high);
            sortByAuthor(books, low, pi - 1);
            sortByAuthor(books, pi + 1, high);
        }
    }

    private static int partitionByAuthor(List<Book> books, int low, int high) {
        String pivot = books.get(high).author.name;
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (books.get(j).author.name.compareTo(pivot) < 0) {
                i++;
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }

        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);

        return i + 1;
    }
}
