package _3_PrinciplesOfOOP;

public class _05_Book {
    private final String title; // field 1
    private final String author; // field 2
    private final int yearPublished; // field 3
    private final String isbn; // field 4

    // Constructor
    _05_Book(String title, String author, int yearPublished, String isbn) {
        // fields are assigned values, parameters of class' constructor
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
    }

    // getter of field 1
    String getTitle() {
        return title;
    }

    // getter of field 2
    String getAuthor() {
        return author;
    }

    // getter of field 3
    int getYearPublished() {
        return yearPublished;
    }

    // getter of field 4
    String getIsbn() {
        return isbn;
    }
}