package _4_ConstructorsAndEncapsulation;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class _10_1_DeliveryService {
    private static final Scanner scrStr = new Scanner(System.in);
    private static final Scanner scrNum = new Scanner(System.in);

    private final String servicePassword = "1111";

    // Service class manages packages
    private final ArrayList<_10_Package> packages = new ArrayList<>();

    // 1. Adding a package to the list
    public void addPackage() {
        System.out.println("\n" + "/ Adding a new package /");

        System.out.println("Name of the recipient: ");
        String recipientName = scrStr.nextLine();

        System.out.println("\n" + "City package will be delivered to: ");
        String city = scrStr.nextLine();

        System.out.println("\n" + "Weight of the package in kilograms: ");
        double weight = -1.00;

        do {
            try {
                weight = scrNum.nextDouble();

                if (weight <= 0.00) {
                    System.out.println("Invalid data for weight!\nInput again... ");
                }
            } catch (InputMismatchException e) {
                System.out.println("^ Invalid data type! (Double data required)\nInput again... ");
                scrNum.next();
            }
        } while (weight <= 0.00);

        System.out.println("\n" + "-- Adding package #" + _10_Package.counter + " --");
        packages.add(new _10_Package(recipientName, city, weight));
    }

    // Private method. Validation of package number input and check whether it exists in list or not
    private int getIndexByNumberOfPackage() {
        System.out.println("Enter a number of package: ");
        int num = -1;

        do {
            try {
                num = scrNum.nextInt();

                if (num < 10) {
                    System.out.println("Invalid data for number of package (>= 10)!\nInput again... ");
                }
            } catch (InputMismatchException e) {
                System.out.println("^ Invalid data type! (Integer data required)\nInput again... ");
                scrNum.next();
            }
        } while (num < 10);

        // default value - negative index
        int saveIndex = -1;

        for (int i = 0; i < num; i++) {
            if (packages.get(i).getNum() == num) {
                saveIndex = i;
                break;
            }
        }

        return saveIndex;
    }

    // 2. Listing all packages in the list (authorized access)
    public void showAllPackages(String servicePassword) {
        if (servicePassword.equals(this.servicePassword)) {
            if (!packages.isEmpty()) {
                System.out.println("\n" + "/ Showing all packages /");

                for (_10_Package p : packages) {
                    p.printInfo();
                }
            } else {
                System.out.println("\n* NO PACKAGES IN THE LIST *");
            }
        } else {
            System.out.println("ACCESS DENIED");
        }
    }

    // 3. Sending a package, changing its status (authorized access)
    public void sendPackage(String servicePassword) {
        if (servicePassword.equals(this.servicePassword)) {
            if (!packages.isEmpty()) {
                System.out.println("\n" + "/ Sending a package /");

                int index = getIndexByNumberOfPackage(); // private method is called

                if (index != -1) {
                    if (packages.get(index).getStatus().equals("Pending")) {
                        // sending package - status is changed to "Sent"
                        packages.get(index).setStatus("Sent");
                        System.out.println("_10_Package #" +  packages.get(index).getNum() + " is set status SENT.");
                    }
                    else {
                        System.out.println("\n" + "** _10_Package is either already sent or delivered **");
                    }
                }
                else {
                    // default value -1 for index is not changed, a package with that number is not found
                    System.out.println("* _10_Package is not found!");
                }
            } else {
                System.out.println("\n* NO PACKAGES IN THE LIST *");
            }
        } else {
            System.out.println("ACCESS DENIED");
        }
    }

    // 3. Delivering a package, changing its status (authorized access)
    public void deliverPackage(String servicePassword) {
        if (servicePassword.equals(this.servicePassword)) {
            if (!packages.isEmpty()) {
                System.out.println("\n" + "/ Delivering a package /");

                int index = getIndexByNumberOfPackage(); // private method is called

                if (index != -1) {
                    if (packages.get(index).getStatus().equals("Sent")) {
                        // delivering package to the recipient - status is changed to "Delivered"
                        packages.get(index).setStatus("Delivered");
                        System.out.println("_10_Package #" +  packages.get(index).getNum() + " is set status DELIVERED.");
                    }
                    else {
                        System.out.println("\n" + "** _10_Package is not sent yet or its status is already 'Delivered' **");
                    }
                }
                else {
                    // default value -1 for index is not changed, a package with that number is not found
                    System.out.println("* _10_Package is not found!");
                }
            } else {
                System.out.println("\n* NO PACKAGES IN THE LIST *");
            }
        } else {
            System.out.println("ACCESS DENIED");
        }
    }

    // 4. Printing packages with status "Pending" (authorized access)
    public void printPendingPackages(String servicePassword) {
        if (servicePassword.equals(this.servicePassword)) {
            if (!packages.isEmpty()) {
                System.out.println("/ Showing pending packages /");

                boolean foundPendingPackages = false;

                for (_10_Package p : packages) {
                    if (p.getStatus().equals("Pending")) {
                        p.printInfo();
                        foundPendingPackages = true;
                    }
                }

                if (!foundPendingPackages) {
                    System.out.println("* No pending packages.");
                }
            } else {
                System.out.println("\n* NO PACKAGES IN THE LIST *");
            }
        } else {
            System.out.println("ACCESS DENIED");
        }
    }

    // 5. Finding the heaviest one/ones package/s in the list (authorized access)
    public void findHeaviestPackage(String servicePassword) {
        if (servicePassword.equals(this.servicePassword)) {
            if (!packages.isEmpty()) {
                System.out.println("\n" + "/ Finding heaviest package /");

                /* setting first package as a default one, weights of
                    the rest are compared to its weight below */
                _10_Package heaviestPackage = packages.getFirst();

                // used for repeating same max weight multiple times
                double saveRepeatedWeightValue = -1.00;

                for (_10_Package p : packages) {
                    if (p.getWeight() > heaviestPackage.getWeight()) {
                        heaviestPackage = p;
                    }
                    else if (p.getWeight() == heaviestPackage.getWeight()) {
                        saveRepeatedWeightValue = p.getWeight();
                    }
                }

                System.out.printf("------| MAX = %.2f kg |------", heaviestPackage.getWeight());

                // only one package is the heaviest one
                if (saveRepeatedWeightValue == -1.00) {
                    heaviestPackage.printInfo();
                }
                // more than one packages are registered with the same value remaining the gratest
                else {
                    for (_10_Package p : packages) {
                        if (p.getWeight() == saveRepeatedWeightValue) {
                            p.printInfo();
                        }
                    }
                }
            } else {
                System.out.println("\n* NO PACKAGES IN THE LIST *");
            }
        } else {
            System.out.println("ACCESS DENIED");
        }
    }
}