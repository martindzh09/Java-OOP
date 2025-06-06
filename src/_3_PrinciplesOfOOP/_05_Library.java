package _3_PrinciplesOfOOP;

import java.util.ArrayList;

class _05_Library {

    // field 1 - ArrayList of objects (books of class "_05_Book")
    ArrayList<_05_Book> books = new ArrayList<>();

    // Method 2 - Adding a new book to ArrayList of books (class "_05_Book")
    void addBook(_05_Book book) {
        books.add(book);
    }

    // * Overloading method 2 - -||-; explicitly instancing a new object with method's parameters
    void addBook(String title, String author, int yearPublished, String isbn) {
      books.add(new _05_Book(title, author, yearPublished, isbn));
    }

    // (Static) Method 3 - Format of printing data of each book
    static void bookData(String title, String author, int yearPublished, String isbn) {
        System.out.println("\n" + "-----------------------");

        System.out.printf("Title: %s%n", title);
        System.out.printf("Author: %s%n", author);
        System.out.printf("Year published: %d%n", yearPublished);
        System.out.printf("ISBN: %s%n", isbn);

        System.out.println("-----------------------");
    }

    // Method 4 - Searching for a specific book by title
    void searchBook(String bookToFind) {
        int timesNotFound = 0;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(bookToFind)) {
                System.out.printf("%n'%s' is successfully found in the library!%n", bookToFind);
                System.out.printf("| Book's sequential number -> %d |%n", i);

                // (static) method 3 is called
                bookData(books.get(i).getTitle(), books.get(i).getAuthor(),
                        books.get(i).getYearPublished(), books.get(i).getIsbn());
            }
            else {
                timesNotFound++;
            }
        }

        if (timesNotFound == books.size()) {
            System.out.println("\n" + "No such book is found in the library :(");
        }
    }

    // Method 5 - Printing data of all saved books in the ArrayList (books)
    void allBooksData() {
        System.out.println("\n" + " ------- ");
        System.out.println("| BOOKS |");

        if (books.size() >= 3) {
            System.out.printf("* Some of the most recently added books titles: '%s', '%s', '%s' and many others.%n",
                    books.getLast().getTitle(), books.get(books.size() - 2).getTitle(), books.get(books.size() - 3).getTitle());
        }

        for (_05_Book book: books) {
            // (static) method 3 is called
            bookData(book.getTitle(), book.getAuthor(), book.getYearPublished(), book.getIsbn());
        }
    }
}