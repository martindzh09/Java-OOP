package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class _05_1_CarRepairShop {
    static void options() {
        System.out.println("\n" + "--------------------------------------------");
        System.out.println("1. ADD a car to the repair shop");
        System.out.println("2. REMOVE a car when repaired");
        System.out.println("3. List ALL CARS present in the repair shop");
        System.out.println("____________________________________________");
        System.out.println("4. EXIT");
        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scrStr = new Scanner(System.in);
        Scanner scrNum = new Scanner(System.in);

        // a new list of cars is created - storing each new car entering the repair shop
        ArrayList<_05_Car> cars = new ArrayList<>();

        /* used for generating unique ID (Integer type) of each next member added; starting >0 */
        AtomicInteger uniqueId = new AtomicInteger(0);

        String option;
        int index = 0; // used for printing object's data immediately after adding it to the list

        do {
            options();
            System.out.println("\n" + "Choose an option... ");

            option = scrStr.nextLine();

            switch (option) {
                case "1":
                    int id = uniqueId.incrementAndGet(); // unique IDs in a sequence are assigned

                    System.out.println("\n" + "Brand of the car: ");
                    String brand = scrStr.nextLine();

                    System.out.println("\n" + "Model of " + brand + " car: ");
                    String model = scrStr.nextLine();

                    System.out.println("\n" + "Write down the registration number of the car... (BG) ");
                    String regNumber = scrStr.nextLine();

                    System.out.println("\n" + "What year does " + brand + " " + model + " produced?");
                    int year;

                    do {
                        year = scrNum.nextInt();

                        if (year <= 1886 || year > 2026) {
                            System.out.println("Invalid year!");
                        }
                    } while (year <= 1886 || year > 2026);

                    System.out.println("\n" + "-- CAR ADDED TO THE REPAIR SHOP --");
                    cars.add(new _05_Car(id, brand, model, regNumber, year));

                    cars.get(index).printInfo();
                    index++; // incrementing index after using its value
                    break;

                case "2":
                    if (!cars.isEmpty()) {
                        System.out.println("\n" + "Enter a valid ID to remove a car:  ");
                        int searchId;

                        do {
                            searchId = scrNum.nextInt();

                            if (searchId < 1) {
                                System.out.println("Invalid ID!");
                            }
                        } while (searchId < 1);

                        int saveIndex = -1;

                        if (!cars.isEmpty()) {
                            for (_05_Car car : cars) {
                                if (car.getId() == searchId) {
                                    saveIndex = cars.indexOf(car);
                                }
                            }
                        } else {
                            System.out.println("\n" + "Repair shop is empty!");
                        }

                        if (saveIndex != -1) {
                            cars.get(saveIndex).printInfo();
                            System.out.println("\n" + "[removing]");
                            cars.remove(saveIndex);

                            // calling a static method to update (decrement) value of static variable
                            _05_Car.removedCar();
                            index--; // value of index is decremented (reset) to prevent out of bounds exceptions
                        }
                        else {
                            System.out.println("\n" + "ID " + searchId + " does not exist!");
                        }
                    } else {
                        System.out.println("\n" + "No cars to remove! Repair shop is empty!");
                    }
                    break;

                case "3":
                    if (!cars.isEmpty()) {
                        for (_05_Car car : cars) {
                            car.printInfo();
                        }
                        // accessing static field 'addedCars' of class "_05_Car"
                        System.out.println("\n" + "TOTAL CARS: " + _05_Car.addedCars);
                    } else {
                        System.out.println("\n" + "Repair shop is empty!");
                    }
                    break;

                default:
                    if (!option.equals("4")) {
                        System.out.println("Invalid option!");
                    }
            }
        } while (!option.equals("4"));

        System.out.println("\n" + "Closing repair shop...");

        scrNum.close();
        scrStr.close();
    }
}