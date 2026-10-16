package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;

class _07_Room {
    private static final String adminAccessCode = "0000";

    static String getAdminAccessCode() {
        return adminAccessCode;
    }

    int num;
    private final String type;
    private double pricePerNight;
    private boolean isTaken;

    _07_Room(int num, String type) {
        this.num = num;
        this.type = type;

        switch (type) {
            case "single":
                this.pricePerNight = 45.00;
                break;

            case "double":
                this.pricePerNight = 65.99;
                break;

            case "apartment":
                this.pricePerNight = 90.50;
                break;
        }

        this.isTaken = false;
    }

    boolean getIsTaken() {
        return this.isTaken;
    }

    // booking a room
    void book() {
        this.isTaken = true;
    }

    // leaving room and freeing space for new guests
    void release() {
        this.isTaken = false;
    }

    // calculating price by given data for count of nights
    double calculatePrice(int countNights) {
        return this.pricePerNight * countNights;
    }

    void setPricePerNight(String password) {
        Scanner scrFloat = new Scanner(System.in);

        if (password.equals(adminAccessCode)) {
            System.out.println("\n" + "Change current price " + String.format("%.2f Euro... ", pricePerNight));

            double newPrice;

            do {
                newPrice = scrFloat.nextDouble();

                if (newPrice <= 0.00) {
                    System.out.println("Invalid data for price!");
                }
                if (newPrice == pricePerNight) {
                    System.out.println("New price cannot equal " + String.format("%.2f Euro!", pricePerNight));
                }
            } while (newPrice <= 0.00 || newPrice == pricePerNight);

            System.out.println("\n" + "Changing price per night for ROOM " + num + "...");
            this.pricePerNight = newPrice;
        }
        else {
            System.out.println("Invalid password! Access denied!");
        }
    }

    void printInfo() {
        if (this.isTaken) {
            System.out.printf("\n| ROOM %d | %s | %.2f Euro/night / Status: TAKEN |%n", num, type, pricePerNight);
        }
        else {
            System.out.printf("\n| ROOM %d | %s | %.2f Euro/night / Status: AVAILABLE FOR BOOKING |%n",num, type, pricePerNight);
        }
    }
}