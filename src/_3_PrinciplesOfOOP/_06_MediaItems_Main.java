package _3_PrinciplesOfOOP;

import java.util.Scanner;

class _06_MediaItems_Main {

    // Method 1 - List with options
    static void optionsList() {
        System.out.println("\n" + "-------------");
        System.out.println("O P T I O N S");
        System.out.println("-------------");

        System.out.println("------------------------------------");
        System.out.println("1. Add new media item I             |");
        System.out.println("2. Add new media item II            |");
        System.out.println("3. Search for a media item          |");
        System.out.println("4. Change details for title or year |");
        System.out.println("5. Sorting media items by title     |");
        System.out.println("6. Sorting media items by year      |");
        System.out.println("7. Print all data                   |");
        System.out.println("------------------------------------");

        System.out.println("8. EXIT                             |");
        System.out.println("------------------------------------");
    }

    // Main program (06)
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.println("\n" + "| Welcome! |");

        // instancing a new object where different media items are stored (in field 1)
        _06_MediaItems mediaItemsControl = new _06_MediaItems();

        String option;
        do {
            optionsList(); // (static) method 1 is called

            System.out.println("\n" + "___________________");
            System.out.println("Select an option... ");

            option = scr.nextLine();

            String mediaType, mediaTitle; int yearPublished;

            switch (option) {
                case "1":
                    System.out.println("\n" + "What type of media item you would " +
                            "like to save (Book, Movie, Music)?");

                    do {
                        mediaType = scr.nextLine();

                        if (!mediaType.equals("Book") && !mediaType.equals("Movie") && !mediaType.equals("Music")) {
                            System.out.println("\n" + "Invalid type of media item!");
                            System.out.println("Input again... ");
                        }
                    } while (!mediaType.equals("Book") && !mediaType.equals("Movie") && !mediaType.equals("Music"));

                    System.out.println("\n" + "What is the TITLE of " + mediaType + " item?");
                    mediaTitle = scr.nextLine();

                    System.out.println("\n" + "Which YEAR was it first published?");


                    do {
                        yearPublished = Integer.parseInt(scr.nextLine());

                        if (yearPublished <= 500 || yearPublished > 2025) {
                            System.out.println("\n" + "Invalid year of publication!");
                            System.out.println("Input again... ");
                        }
                    } while (yearPublished <= 500 || yearPublished > 2025);

                    switch (mediaType) {
                        case "Book":
                            System.out.println("\n" + "Input data for AUTHOR of the book: ");
                            String author = scr.nextLine();

                            System.out.println("\n" + "Input a valid ISBN of the book: ");
                            String isbn = scr.nextLine();

                            // method 2 is called (from class "_06_MediaItems")
                            mediaItemsControl.addMediaItem
                                    (new _06_1_Book(mediaType, mediaTitle,yearPublished, author, isbn));
                            break;

                        case "Movie":
                            System.out.println("\n" + "Who is the DIRECTOR of the movie?");
                            String director = scr.nextLine();

                            System.out.println("\n" + "How many minutes is the movie DURATION?");
                            double duration;

                            do {
                                duration = Double.parseDouble(scr.nextLine());

                                if (duration <= 0) {
                                    System.out.println("\n" + "Time could not be negative value!");
                                    System.out.println("Input again... ");
                                }
                            } while (duration <= 0);

                            // method 2 is called (from class "_06_MediaItems")
                            mediaItemsControl.addMediaItem
                                    (new _06_2_Movie(mediaType, mediaTitle, yearPublished, director, duration));
                            break;

                        case "Music":
                            System.out.println("\n" + "Who is the ARTIST of the song (music)?");
                            String artist = scr.nextLine();

                            System.out.println("\n" + "What is the GENRE of the song (music)?");
                            String genre = scr.nextLine();

                            // method 2 is called (from class "_06_MediaItems")
                            mediaItemsControl.addMediaItem
                                    (new _06_3_Music(mediaType, mediaTitle, yearPublished, artist, genre));
                            break;
                    }
                    break;

                case "2":
                    System.out.println("\n" + "What type of media item you would " +
                            "like to save (Book, Movie, Music)?");

                    do {
                        mediaType = scr.nextLine();

                        if (!mediaType.equals("Book") && !mediaType.equals("Movie") && !mediaType.equals("Music")) {
                            System.out.println("\n" + "Invalid type of media item!");
                            System.out.println("Input again... ");
                        }
                    } while (!mediaType.equals("Book") && !mediaType.equals("Movie") && !mediaType.equals("Music"));

                    System.out.println("\n" + "What is the TITLE of " + mediaType + " item?");
                    mediaTitle = scr.nextLine();

                    System.out.println("\n" + "Which YEAR was it first published?");

                    do {
                        yearPublished = Integer.parseInt(scr.nextLine());

                        if (yearPublished <= 500 || yearPublished > 2025) {
                            System.out.println("\n" + "Invalid year of publication!");
                            System.out.println("Input again... ");
                        }
                    } while (yearPublished <= 500 || yearPublished > 2025);

                    // overloaded method 2 is called (from class "_06_MediaItems")
                    mediaItemsControl.addMediaItem(mediaType, mediaTitle, yearPublished);
                    break;

                case "3":
                    // method 3 is called (from class "_06_MediaItems")
                    mediaItemsControl.searchMediaItem();
                    break;

                case "4":
                    // method 4 is called (from class "_06_MediaItems")
                    mediaItemsControl.changeDetails();
                    break;

                case "5":
                    // method 5 is called (from class "_06_MediaItems")
                    mediaItemsControl.sortMediaItemsTitles();
                    break;

                case "6":
                    // method 6 is called (from class "_06_MediaItems")
                    mediaItemsControl.sortMediaItemsYearsPublished();
                    break;

                case "7":
                    // method 7 is called (from class "_06_MediaItems")
                    mediaItemsControl.printData();
                    break;

                default:
                    if (!option.equals("8")) {
                        System.out.println("\n" + "Invalid option!!!");
                    }
            }
        } while (!option.equals("8"));

        System.out.println("\n" + "Exiting the program....");

        scr.close();
    }
}