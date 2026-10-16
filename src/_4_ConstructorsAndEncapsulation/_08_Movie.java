package _4_ConstructorsAndEncapsulation;

class _08_Movie {
    String title;
    String genre;
    private final double durationInMinutes;
    private final double ratingInStars;

    _08_Movie(String title, String genre, double durationInMinutes, double ratingInStars) {
        this.title = title;
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;
        this.ratingInStars = ratingInStars;
    }

    double getDurationInMinutes() {
        return durationInMinutes;
    }

    double getRatingInStars() {
        return ratingInStars;
    }

    void printInfo() {
        System.out.printf("%n| %s -- %s -- %.2f min -- rate: %.1f stars |%n", title, genre, durationInMinutes, ratingInStars);
    }
}