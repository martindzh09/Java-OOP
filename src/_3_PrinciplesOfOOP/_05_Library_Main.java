package _3_PrinciplesOfOOP;

import java.util.*;

class _05_Library_Main {
    static Scanner scrStr = new Scanner(System.in); // scanner (1), String data
    static Scanner scrInt = new Scanner(System.in); // scanner (2), Integer data

    // Method 1 - List with options
    static void optionsList() {
        System.out.println("\n" + "-------------");
        System.out.println("O P T I O N S");
        System.out.println("-------------");

        System.out.println("_____________________________________");
        System.out.println("1. Add NEW BOOK in the library I     |");
        System.out.println("2. Add NEW BOOK in the library II    |");
        System.out.println("3. SEARCH for a specific book        |");
        System.out.println("4. Data for ALL BOOKS in the library |");
        System.out.println("-------------------------------------");

        System.out.println("5. EXIT                              |");
        System.out.println("-------------------------------------");
    }

    // Method 2 - Input data for book's characteristics; (returned as a whole object)
    static _05_Book bookData() {
        System.out.println("\n" + "What is the TITLE of the book?");
        String title = scrStr.nextLine();

        System.out.println("\n" + "Who is the AUTHOR of the book?");
        String author = scrStr.nextLine();

        System.out.println("\n" + "When was it first PUBLISHED?");
        int yearPublished = scrInt.nextInt();

        System.out.println("\n" + "Input a valid ISBN of the book... ");
        String isbn = scrStr.nextLine();

        return new _05_Book(title, author, yearPublished, isbn);
    }

    // Main method (05)
    public static void main() {
        String option;

        /* instancing an object (a library) the program works (operates) with;
            books could be added, found and listed */
        _05_Library library = new _05_Library();

        do {
            optionsList(); // (main class' static) method 1 is called

            System.out.println("____________________________________________");
            System.out.println("Choose an option from the following above... ");
            option = scrStr.nextLine();

            switch (option) {
                case "1":
                    // a new book is added using method 2 in class "_05_Library"; (only 1 parameter passes through)
                    library.addBook(bookData()); // (main class' static) method 2 is called

                    break;

                case "2":
                    /* instancing an additional object - a book which characteristics are "transferred" as
                        parameters of a new book in the library */
                    _05_Book bookTransfer = bookData(); // (main class' static) method

                    // a new book is added using the overloaded method 2 in class "_05_Library"
                    library.addBook(bookTransfer.getTitle(), bookTransfer.getAuthor(),
                            bookTransfer.getYearPublished(), bookTransfer.getIsbn());

                    break;

                case "3":
                    System.out.println("________________________________________________");
                    System.out.println("Type in TITLE of the book you are looking for... ");
                    String bookToFind = scrStr.nextLine();

                    // method 4 (of class "_05_Library" is called)
                    library.searchBook(bookToFind);

                    break;

                case "4":
                    library.allBooksData(); // method 5 (of class "_05_Library") is called

                    break;

                default:
                    if (!option.equals("5")) {
                        System.out.println("\n" + "Invalid option!");
                    }
            }
        } while (!option.equals("5"));

        System.out.println("\n" + "______________________");
        System.out.println("Exiting the program... ");
    }
}