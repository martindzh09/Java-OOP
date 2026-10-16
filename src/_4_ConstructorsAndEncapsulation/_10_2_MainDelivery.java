package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;

public class _10_2_MainDelivery {
    private static final Scanner scrMain = new Scanner(System.in);

    // Static method - Input and return password
    public static String passwordInput() {
        System.out.println("\n" + "_______________");
        System.out.println("Enter password: ");

        String password = scrMain.nextLine();
        System.out.println("_______________");

        return password;
    }

    // Main method
    public static void main(String[] args) {
        // Instancing a new object service operations will be performed with
        _10_1_DeliveryService deliveryService = new _10_1_DeliveryService();

        String option;

        do {
            System.out.println("\n" + "________________");
            System.out.println("DELIVERY SERVICE");
            System.out.println("------------------------- ");
            System.out.println("1. Add a new package     |");
            System.out.println("#2 Show all packages     |");
            System.out.println("#3 Send a package        |");
            System.out.println("#4 Deliver a package     |");
            System.out.println("#5 Show pending packages |");
            System.out.println("#6 Show heaviest package |");
            System.out.println("-------------------------");
            System.out.println("| 7. Exit |");
            System.out.println(" --------- ");

            System.out.println("\n" + "Choose an option: ");
            option = scrMain.nextLine();

            switch (option) {
                case "1":
                    // adding a new package
                    deliveryService.addPackage();
                    break;

                case "2":
                    // Showing all packages
                    deliveryService.showAllPackages(passwordInput());
                    break;

                case "3":
                    // Sending a package
                    deliveryService.sendPackage(passwordInput());
                    break;

                case "4":
                    // Delivering a package
                    deliveryService.deliverPackage(passwordInput());
                    break;

                case "5":
                    // Showing data of pending packages
                    deliveryService.printPendingPackages(passwordInput());
                    break;

                case "6":
                    // Showing heaviest package/s
                    deliveryService.findHeaviestPackage(passwordInput());
                    break;

                default:
                    if (!option.equals("7")) {
                        System.out.println("Invalid option!\nTry again... ");
                    }
            }
        } while (!option.equals("7"));

        System.out.println("\n" + "Exiting the program... ");

        scrMain.close();
    }
}