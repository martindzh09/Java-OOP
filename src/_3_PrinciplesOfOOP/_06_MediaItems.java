package _3_PrinciplesOfOOP;

import java.util.ArrayList; import java.util.Scanner;

import java.util.Comparator;

class _06_MediaItems {
    private static final Scanner scrStr = new Scanner(System.in); // scanner (1) - String data
    private static final Scanner scrNum = new Scanner(System.in); // scanner (2) - Numbers data

    // field 1 - An ArrayList where different media items are stored
    ArrayList<_06_MediaItem> mediaItems = new ArrayList<>();

    // Method 2 - Adding new media item as a whole new object
    void addMediaItem(_06_MediaItem mediaItem) {
        mediaItems.add(mediaItem);
    }

    // * Overloading method 2 - Each of mediaItem details is passed as a parameter
    void addMediaItem(String mediaType, String mediaTitle, int yearPublished) {
        switch (mediaType) {
            case "Book":
                System.out.println("\n" + "Input data for AUTHOR of the book: ");
                String author = scrStr.nextLine();

                System.out.println("\n" + "Input a valid ISBN of the book: ");
                String isbn = scrStr.nextLine();

                // a new object of type 'Book' is added to ArrayList of media items
                mediaItems.add(new _06_1_Book(mediaType, mediaTitle, yearPublished, author, isbn));

                break;

            case "Movie":
                System.out.println("\n" + "Who is the DIRECTOR of the movie?");
                String director = scrStr.nextLine();

                System.out.println("\n" + "How many minutes is the movie DURATION?");
                double duration;

                do {
                    duration = scrNum.nextDouble();

                    if (duration <= 0) {
                        System.out.println("\n" + "Time could not be negative value!");
                        System.out.println("Input again... ");
                    }
                } while (duration <= 0);

                // a new object of type 'Movie' is added to ArrayList of media items
                mediaItems.add(new _06_2_Movie(mediaType, mediaTitle, yearPublished, director, duration));

                break;

            case "Music":
                System.out.println("\n" + "Who is the ARTIST of the song (music)?");
                String artist = scrStr.nextLine();

                System.out.println("\n" + "What is the GENRE of the song (music)?");
                String genre = scrStr.nextLine();

                // a new object of type 'Music' is added to ArrayList of media items
                mediaItems.add(new _06_3_Music(mediaType, mediaTitle, yearPublished, artist, genre));

                break;
        }
    }

    // Method 3 - Searching for a certain media item
    void searchMediaItem() {
        if (!mediaItems.isEmpty()) {
            System.out.println("\n" + "Type in title of media item you are looking for... ");
            String titleToSeek = scrStr.nextLine();

            int timesNotFound = 0;

            for (_06_MediaItem mediaItem : mediaItems) {
                if (mediaItem.getMediaTitle().equals(titleToSeek)) {
                    System.out.println("\n" + "'" + titleToSeek + "' is successfully found");

                    // superclass' abstract method 1 is called; method is implemented in subclasses
                    System.out.print(mediaItem.getDetails());
                } else {
                    timesNotFound++;
                }
            }

            if (timesNotFound == mediaItems.size()) {
                System.out.println("\n" + "_____________________________");
                System.out.println("'" + titleToSeek + "' is not found :(");
            }
        }
        else {
            System.out.println("\n" + "* You cannot search for elements unless you add some!");
        }
    }

    // Method 4 - Details changes - (title of media or year of publication)
    void changeDetails() {
        if (!mediaItems.isEmpty()) {
            System.out.println("\n" + "------------------");
            System.out.println("Saved media items");
            System.out.println("------------------");


            for (int i = 0; i < mediaItems.size(); i++) {
                System.out.println("\n" + "---");
                System.out.println("#" + (i + 1));
                System.out.println("---");

                // details for each media item are printed
                System.out.print(mediaItems.get(i).getDetails());
            }

            System.out.println("\n" + "Select number of the media item you would like to make changes to... ");
            int mediaItemNum;

            do {
                mediaItemNum = Integer.parseInt(scrStr.nextLine());

                if (mediaItemNum <= 0 || mediaItemNum > mediaItems.size()) {
                    System.out.println("\n" + "* Invalid of non-existent number of media item");
                    System.out.println("\n" + "Select again... ");
                }
            } while (mediaItemNum <= 0 || mediaItemNum > mediaItems.size());

            System.out.println("\n" + "---------------------------------------------");
            System.out.println("Media item #" + mediaItemNum + " is selected... ");
            System.out.print(mediaItems.get(mediaItemNum - 1).getDetails());

            System.out.println("------------------------------------------");
            System.out.println("\n" + "1) Change media item's TITLE");
            System.out.println("2) Change media item's YEAR OF PUBLICATION");
            System.out.println("------------------------------------------");

            System.out.println("\n" + "Choose an option: ");
            String optionChosen;

            do {
                optionChosen = scrStr.nextLine();

                if (!optionChosen.equals("1") && !optionChosen.equals("2")) {
                    System.out.println("\n" + "Choose again a correct option... ");
                }
            } while (!optionChosen.equals("1") && !optionChosen.equals("2"));

            String passkey; // needed when trying to change any details

            switch (optionChosen) {
                case "1":
                    System.out.println("\n" + "Enter a passkey... ");
                    passkey = scrStr.nextLine();

                    // setter 4 is called
                    mediaItems.get(mediaItemNum - 1).setMediaTitle(passkey);
                    break;

                case "2":
                    System.out.println("\n" + "Enter a passkey... ");
                    passkey = scrStr.nextLine();

                    // setter 5 is called
                    mediaItems.get(mediaItemNum - 1).setYearPublished(passkey);
                    break;
            }
        }
        else {
            System.out.println("\n" + "* There haven't been any saved media items yet :|");
        }
    }

    // Method 5 - Sorting media items by titles
    void sortMediaItemsTitles() {
        if (!(mediaItems.size() < 2)) {
            // sorting media items by their titles
            mediaItems.sort(Comparator.comparing(_06_MediaItem::getMediaTitle));

            System.out.println("\n" + "* Media items are " +
                    "successfully sorted by alphabetical order of their titles!");

            System.out.println("* Check option 7 to see changes after sorting by titles");
        }
        else {
            System.out.println("\n" + "* At least two media items need to be saved to occur sorting");
        }
    }

    // Method 6 - Sorting media items by years of publication
    void sortMediaItemsYearsPublished() {
        if (!(mediaItems.size() < 2)) {
            // sorting media items by their years of publication
            mediaItems.sort(Comparator.comparingInt(_06_MediaItem::getYearPublished));

            System.out.println("\n" + "* Media items are successfully sorted by years of publication!");
            System.out.println("* Check option 7 to see changes after sorting by years of publication");
        }
        else {
            System.out.println("\n" + "* At least two media items need to be saved to occur sorting");
        }
    }

    // Method 7 - Printing all saved data for media items
    void printData() {
        if (!mediaItems.isEmpty()) {
            for (_06_MediaItem mediaItem : mediaItems) {
                System.out.print(mediaItem.getDetails());
            }
        }
        else {
            System.out.println("\n" + "* No data has been saved in the ArrayList yet -> []");
        }
    }
}