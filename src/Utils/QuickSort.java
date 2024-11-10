package Utils;

import Models.Book;

import java.util.List;

public class QuickSort {
    public static void quickSort(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);
            quickSort(books, low, pi - 1);
            quickSort(books, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, int low, int high) {
        Book pivot = books.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (books.get(j).title.compareTo(pivot.title) < 0
                    || books.get(j).author.name.compareTo(pivot.author.name) < 0) {
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

    public static void sortByTitle(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partitionByTitle(books, low, high);
            sortByTitle(books, low, pi - 1);
            sortByTitle(books, pi + 1, high);
        }
    }

    public static void sortByISBN(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partitionByISBN(books, low, high);
            sortByISBN(books, low, pi - 1);
            sortByISBN(books, pi + 1, high);
        }
    }

    public static void sortByAuthor(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partitionByAuthor(books, low, high);
            sortByAuthor(books, low, pi - 1);
            sortByAuthor(books, pi + 1, high);
        }
    }

    private static int partitionByTitle(List<Book> books, int low, int high) {
        String pivot = books.get(high).title;
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (books.get(j).title.compareTo(pivot) < 0) {
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

    private static int partitionByISBN(List<Book> books, int low, int high) {
        String pivot = books.get(high).isbn;
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (books.get(j).isbn.compareTo(pivot) < 0) {
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
