package _3_PrinciplesOfOOP;

import java.util.Scanner;

// Superclass 6.0
abstract class _06_MediaItem {
    // scanner (1) (of superclass)
    private static final Scanner scrSuperClass = new Scanner(System.in);

    // a specific passkey before any changes of fields below by setter-methods
    private static final String passkey = "_06_MediaItem"; // (final) field 2

    String mediaType; // field 3
    private String mediaTitle; // (hidden) field 4
    private int yearPublished; // (hidden) field 5

    // superclass' constructor (0)
    _06_MediaItem(String mediaType, String mediaTitle, int yearPublished) {
        this.mediaType = mediaType;
        this.mediaTitle = mediaTitle;
        this.yearPublished = yearPublished;
    }

    // accessing private field 4 (getter 4)
    String getMediaTitle() {
        return mediaTitle;
    }

    // accessing and assigning private field 4 a new value (setter 4)
    void setMediaTitle(String enableChanges) {
        if (enableChanges.equals(passkey)) {
            System.out.println("\n" + "________________");
            System.out.println("- Service mode -");

            System.out.println("\n" + "Input a new title different from the previous one... ");
            String changedTitle;

            do {
                changedTitle = scrSuperClass.nextLine();

                if (changedTitle.equals(this.mediaTitle)) {
                    System.out.println("\n" + "New title cannot match the previous one!");
                    System.out.println("Type in again... ");
                }
            } while (changedTitle.equals(this.mediaTitle));

            System.out.println("\n" + "Confirm changed title (y/n)... ");
            String confirmation;

            do {
                confirmation = scrSuperClass.nextLine();

                if (!confirmation.startsWith("y") && !confirmation.startsWith("Y") &&
                        !confirmation.startsWith("n") && !confirmation.startsWith("N")) {
                    System.out.println("\n" + "* Make sure you type in your answer correctly!");
                    System.out.println("Type in again... ");
                }
            } while (!confirmation.startsWith("y") && !confirmation.startsWith("Y") &&
                    !confirmation.startsWith("n") && !confirmation.startsWith("N"));

            if (confirmation.startsWith("y") || confirmation.startsWith("Y")) {
                this.mediaTitle = changedTitle;
                System.out.println("\n" + "New title is successfully set.");
            } else {
                System.out.printf("%nTitle '%s' is unchanged.", this.mediaTitle);
            }
        }
        else {
            System.out.println("\n" + "--------------");
            System.out.println("Access denied!");
            System.out.println("--------------");
        }
    }

    // accessing private field 5 (getter 5)
    int getYearPublished() {
        return yearPublished;
    }

    // accessing and assigning private field 5 a new value (setter 5 - overloaded)
    void setYearPublished(String enableChanges) {
        if (enableChanges.equals(passkey)) {
            System.out.println("\n" + "________________");
            System.out.println("- Service mode -");

            System.out.println("\n" + "Input a new year of publication different from the previous one... ");
            int changedYearPublished;

            do {
                do {
                    changedYearPublished = Integer.parseInt(scrSuperClass.nextLine());

                    if (changedYearPublished <= 500 || changedYearPublished > 2025) {
                        System.out.println("Invalid data for year!!!");
                        System.out.println("\n" + "Type in again... ");
                    }
                } while (changedYearPublished <= 500 || changedYearPublished > 2025);

                if (changedYearPublished == this.yearPublished) {
                    System.out.println("\n" + "New year of publication cannot match the previous one!");
                    System.out.println("Type in again... ");
                }
            } while (changedYearPublished == this.yearPublished);

            System.out.println("\n" + "Confirm changed year of publication (y/n)... ");
            String confirmation;

            do {
                confirmation = scrSuperClass.nextLine();

                if ((!confirmation.startsWith("y") && !confirmation.startsWith("Y")) &&
                        (!confirmation.startsWith("n") && !confirmation.startsWith("N"))) {
                    System.out.println("\n" + "* Make sure you type in your answer correctly!");
                    System.out.println("Type in again... ");
                }
            } while ((!confirmation.startsWith("y") && !confirmation.startsWith("Y")) &&
                    (!confirmation.startsWith("n") && !confirmation.startsWith("N")));

            if (confirmation.startsWith("y") || confirmation.startsWith("Y")) {
                this.yearPublished = changedYearPublished;
                System.out.println("\n" + "New year of publication is successfully set.");
            }
            else {
                System.out.printf("%nYear of publication '%d' is unchanged.%n", this.yearPublished);
            }
        }
        else {
            System.out.println("\n" + "--------------");
            System.out.println("Access denied!");
            System.out.println("--------------");
        }
    }

    // superclass' abstract method 1 - Description of a media item
    abstract String getDetails();
}

// subclass 6.1
class _06_1_Book extends _06_MediaItem {
    String author; // (added) field 4
    String isbn; // (added) field 5

    // (inheritor's) constructor 1
    _06_1_Book(String mediaType, String mediaTitle, int yearPublished, String author, String isbn) {
        super(mediaType, mediaTitle, yearPublished); // referring to superclass' constructor

        this.author = author;
        this.isbn = isbn;
    }

    // abstract method's implementation 1
    String getDetails() {
        System.out.println("\n" + "-----------");
        System.out.println("| BOOK ITEM |");

        return String.format("Title: %s%nYear of publication: %d%nAuthor: %s%nISBN: %s%n",
                getMediaTitle(), getYearPublished(), author, isbn);
    }
}

// subclass 6.2
class _06_2_Movie extends _06_MediaItem {
    String director; // (added) field 4
    double duration; // (added) field 5 (* in minutes)

    // (inheritor's) constructor 2
    _06_2_Movie(String mediaType, String mediaTitle, int yearPublished, String director, double duration) {
        super(mediaType, mediaTitle, yearPublished); // referring to superclass' constructor

        this.director = director;
        this.duration = duration;
    }

    // abstract method's implementation 2
    String getDetails() {
        System.out.println("\n" + "------------");
        System.out.println("| MOVIE ITEM |");

        return String.format("Title: %s%nYear of publication: %d%nDirector: %s%nDuration (in minutes): %.2f%n",
                getMediaTitle(), getYearPublished(), director, duration);
    }
}

// subclass 6.3
class _06_3_Music extends _06_MediaItem {
    String artist; // (added) field 4
    String genre; // (added) field 5

    // (inheritor's) constructor 3
    _06_3_Music(String mediaType, String mediaTitle, int yearPublished, String artist, String genre) {
        super(mediaType, mediaTitle, yearPublished); // referring to superclass' constructor

        this.artist = artist;
        this.genre = genre;
    }

    // abstract method's implementation 3
    String getDetails() {
        System.out.println("\n" + "------------");
        System.out.println("| MUSIC ITEM |");

        return String.format("Title: %s%nYear of publication: %d%nArtist: %s%nGenre: %s%n",
                getMediaTitle(), getYearPublished(), artist, genre);
    }
}