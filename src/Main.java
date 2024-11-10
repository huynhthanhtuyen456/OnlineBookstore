import Models.*;
import Utils.BinarySearch;
import Utils.LinearSearch;
import Utils.QuickSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        String[] titles = {
                "Java Basics",
                "Data Structures",
                "Algorithms",
                "Operating Systems",
                "War And Peace",
                "Networking Foundation",
                "Agile Process"
        };
        String[] authorNames = {
                "John",
                "Alice",
                "Bob",
                "Jack",
                "Mary",
                "Johnson",
                "Jacob"
        };
        String[] customerNames = {
                "Ben",
                "Loki",
                "Odin",
                "Haki"
        };

        for (String authorName : authorNames) {
            Author author = new Author();
            author.name = authorName;
            authors.add(author);
        }

        for (String customerName : customerNames) {
            Customer customer = new Customer();
            customer.name = customerName;
            customers.add(customer);
        }

        for (int i = 0; i < titles.length; i++) {
            Book book = new Book();
            book.isbn = "" + i + i;
            book.title = titles[i];
            book.author = authors.get(i);
            book.edition = i;
            books.add(book);
        }

        System.out.println("Welcome to TH Online Bookstore!");
        System.out.println("Please type your name before making an order!");
        Customer customer = new Customer();
        Scanner customerNameScanner = new Scanner(System.in);
        String customerName = customerNameScanner.nextLine();
        while (customerName.isEmpty()) {
            System.out.println("Please re-type your name:");
        }
        customer.name = customerName;
        System.out.println("Your name is " + customer.name);

        System.out.println("Please type your address before making an order!");
        Scanner customerAddressScanner = new Scanner(System.in);
        String customerAddress = customerAddressScanner.nextLine();
        while (customerAddress.isEmpty()) {
            System.out.println("Please re-enter your address:");
        }
        customer.address = customerAddress;
        System.out.println("Your address is " + customer.address);

        System.out.println("Our available books will be sorted by title following alphabetically:");
        QuickSort.sortByTitle(books, 0, books.size() - 1);
        for (Book book : books) {
            System.out.println("- " + book.Display());
        }

        boolean continueToOrder = false;
        OrderQueue orderQueue = new OrderQueue();

        do {
            System.out.println("Please type your search term to find your expected books to make an order!");
            Scanner searchBookTermScanner = new Scanner(System.in);
            String searchBookTerm = searchBookTermScanner.nextLine();
            while (searchBookTerm.isEmpty()) {
                System.out.println("Please re-type the Title of book:");
            }

            // Search for a book by title using Linear Search
            System.out.println("Your search term: " + searchBookTerm);
            List<Book> searchResults = LinearSearch.searchBook(books, searchBookTerm);
            System.out.println("Your search results:");
            if (!searchResults.isEmpty()) {
                for (Book book : searchResults) {
                    System.out.println("    - " + book.Display());
                    System.out.println("        * Availability Quantity for this book is " + book.availableQuantity);
                }
            } else {
                System.out.println("Book not found.");
            }

            List<Book> orderedBooks = new ArrayList<>();
            System.out.println("Type your list of ISBN to make an order. It should be split by comma!");
            Scanner bookOrderScanner = new Scanner(System.in);
            String bookOrderList = bookOrderScanner.nextLine();
            String[] bookArrayString = bookOrderList.split(",");
            System.out.println(Arrays.toString(bookArrayString));
            QuickSort.sortByISBN(books, 0, books.size() - 1);
            for (String bookString : bookArrayString) {
                Book book = BinarySearch.findBookByISBN(books, bookString);
                if (book != null) {
                    orderedBooks.add(book);
                    System.out.println("Added book with ISBN: " + book.isbn + " to oder list.");
                } else {
                    System.out.println("Book not found for ISBN: " + bookString);
                }
            }
            // Add orders to the queue
            orderQueue.enqueue(new Order(customer, customer.address, orderedBooks));

            System.out.println("Do you want to make another order? Type Y/y for Yes and N/n for No.");
            try {
                Scanner continueToOrderScanner = new Scanner(System.in);
                String continueToOrderInput = continueToOrderScanner.nextLine();
                continueToOrder = continueToOrderInput.equals("Y") || continueToOrderInput.equals("y");

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
        } while (continueToOrder);

        List<Order> orders = new ArrayList<>(orderQueue.queue);
        System.out.println("List of orders:");
        for (Order order : orders) {
            System.out.println("- " + order.orderID);
        }

        System.out.println("Please type your order number to find your order!");
        Scanner searchOrderNumberScanner = new Scanner(System.in);
        String searchOrderNumber = searchOrderNumberScanner.nextLine();
        while (searchOrderNumber.isEmpty()) {
            System.out.println("Please re-type the Order Number:");
        }
        Order searchOrderResult = BinarySearch.searchOrderByNumber(orders, searchOrderNumber);
        if (searchOrderResult != null) {
            System.out.println("Order found: " + searchOrderResult.orderID);
        }
        else {
            System.out.println("Order not found.");
        }

        // Dequeue and process an order
        Order currentOrder = orderQueue.dequeue();
        String orderID = currentOrder.orderID;
        System.out.println(
                "Processing order for: "
                        + currentOrder.customer.name
                        + " with OrderID: "
                        + orderID
        );
        System.out.println("\n");

        // Sort books in the order by title
        QuickSort.quickSort(currentOrder.books, 0, currentOrder.books.size() - 1);
        System.out.println("Sorted books in order by title: \n");
        for (Book book : currentOrder.books) {
            System.out.println(book.Display());
            System.out.println("\n");
        }
    }
}