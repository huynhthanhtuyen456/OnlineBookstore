package Utils;

import Models.Book;

import java.util.List;

public class InsertionSort {
    public static void insertionSort(List<Book> books) {
        for (Book book : books) {
            int i = books.indexOf(book);
            int j = i - 1;

            while (j >= 0 && books.get(j).title.compareTo(books.get(i).title) > 0) {
                books.set(j + 1, books.get(j));
                j = j - 1;
            }
            books.set(j + 1, book);
        }
//        for (int i = 1; i < books.size(); i++) {
//            String key = books[i];
//            int j = i - 1;
//
//            while (j >= 0 && books[j].compareTo(key) > 0) {
//                books[j + 1] = books[j];
//                j = j - 1;
//            }
//            books[j + 1] = key;
//        }
    }
}
