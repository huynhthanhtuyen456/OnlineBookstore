package Models;

import javax.print.attribute.standard.DateTimeAtCreation;

public class Book {
    public String isbn;
    public String title;
    public Author author;
    public int edition;
    public Double price;
    public int availableQuantity;
//    public DateTimeAtCreation publicationDate;
//    public Publisher publisher;

    public String Display() {
        return "ISBN: " + isbn + " " + "Title: " + title + " " + "Author: " + author.name + " " + "Edition: " + edition;
    }
}
