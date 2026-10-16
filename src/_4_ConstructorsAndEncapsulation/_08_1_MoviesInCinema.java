package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;
import java.util.ArrayList;

class _08_1_MoviesInCinema {
    public static void main(String[] args) {
        Scanner scrStr = new Scanner(System.in);
        Scanner scrNum = new Scanner(System.in);

        // creating a new collection of movies
        ArrayList<_08_Movie> movies = new ArrayList<>();

        String option;

        do {
            System.out.println("\n" + "----------------------------");
            System.out.println("1. Add a movie");
            System.out.println("2. Show all movies");
            System.out.println("3. Highest rated movie");
            System.out.println("4. _08_Movie duration > 120 min");
            System.out.println("____________________________");
            System.out.println("5. EXIT");
            System.out.println("--------");

            System.out.println("\n" + "Choose an option: ");
            option = scrStr.nextLine();

            switch (option) {
                case "1":
                    System.out.println("\n" + "I. Title of the movie: ");
                    String title = scrStr.nextLine();

                    System.out.println("\n" + "II. Genre of the movie: ");
                    String genre = scrStr.nextLine();

                    System.out.println("\n" + "III. Duration of '" + title + "' in minutes: ");
                    double durationInMinutes;

                    do {
                        durationInMinutes = scrNum.nextDouble();

                        if (durationInMinutes <= 0.00) {
                            System.out.println("Invalid data!");
                        }
                    } while (durationInMinutes <= 0.00);

                    System.out.println("\n" + "IV. Rating in stars (1-5): ");
                    double ratingInStars;

                    do {
                        ratingInStars = scrNum.nextDouble();

                        if (ratingInStars < 1.0 || ratingInStars > 5.0) {
                            System.out.println("Invalid data!");
                        }
                    } while (ratingInStars < 1.0 || ratingInStars > 5.0);

                    System.out.println("\n" + "Adding new movie... ");
                    movies.add(new _08_Movie(title, genre, durationInMinutes, ratingInStars));
                    break;

                case "2":
                    if (!movies.isEmpty()) {
                        for (_08_Movie movie : movies) {
                            movie.printInfo();
                        }
                    } else {
                        System.out.println("\n" + "Data for movies is not updated!");
                    }
                    break;

                case "3":
                    if (!movies.isEmpty()) {
                        // assigning a default max value to compare with (on 0 index)
                        double maxRating = movies.getFirst().getRatingInStars();
                        int indexMax = 0; // by default

                        for (int i = 0; i < movies.size(); i++) {
                            if (movies.get(i).getRatingInStars() > maxRating) {
                                maxRating = movies.get(i).getRatingInStars();
                                indexMax = i;
                            }
                        }

                        System.out.println("\n" + "-- Highest rated movie --");
                        movies.get(indexMax).printInfo();
                    }
                    else {
                        System.out.println("\n" + "Data for movies is not updated!");
                    }
                    break;

                case "4":
                    if (!movies.isEmpty()) {
                        System.out.println("\n" + "-- Movies with duration more than 120 minutes --");
                        boolean foundMovies = false;

                        for (_08_Movie movie : movies) {
                            if (movie.getDurationInMinutes() > 120) {
                                movie.printInfo();
                                foundMovies = true;
                            }
                        }

                        if (!foundMovies) {
                            System.out.println("* There are not any movies with duration > 120 minutes!");
                        }
                    } else {
                        System.out.println("\n" + "Data for movies is not updated!");
                    }
                    break;

                default:
                    if (!option.equals("5")) {
                        System.out.println("Invalid option!");
                    }
            }
        } while (!option.equals("5"));

        System.out.println("\n" + "Exiting the program... ");

        scrNum.close();
        scrStr.close();
    }
}