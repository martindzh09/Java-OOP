package _4_ConstructorsAndEncapsulation;
import java.util.Scanner; import java.util.ArrayList;

class _02_1_CoffeeOrders {
    static void options() {
        System.out.println("\n" + "--------------------------");
        System.out.println("1. Make a new coffee      |");
        System.out.println("2. Show all coffee orders |");
        System.out.println("3. EXIT                   |");
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // creating a new list where coffee orders will be stored
        ArrayList<_02_Coffee> coffeeOrders = new ArrayList<>();

        int orderNum = 1; // assigning a number to each next order (sequentially)
        String choice;

        do {
            options(); // showing list of options
            choice = scr.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("| Order #" + orderNum + " |");
                    orderNum++; // post incrementing orders counter

                    System.out.println("_________________");
                    System.out.println("I. _02_Coffee name -> ");
                    String coffeeName = scr.nextLine();

                    System.out.println("\n" + "_________________________________________");
                    System.out.println("II. _02_Coffee size (small, medium, large) -> ");
                    String size; boolean validSizeInput;

                    do {
                        size = scr.nextLine();

                        validSizeInput = (size.startsWith("s") || size.startsWith("S")) ||
                                (size.startsWith("m") || size.startsWith("M")) ||
                                    (size.startsWith("l") || size.startsWith("L"));

                        if (!validSizeInput) {
                            System.out.println("Invalid input! Try again.");
                        }

                    } while (!validSizeInput);

                    System.out.println("\n" + "____________________");
                    System.out.println("III. _02_Coffee price -> "); double price;

                    do { // validating price
                        price = Double.parseDouble(scr.nextLine());

                        if (price <= 0.00) {
                            System.out.println("Invalid price!");
                        }
                    } while (price <= 0.00);

                    System.out.println("\n" + "-> Preparing the coffee...");

                    // a new object (coffee) is added to the list
                    coffeeOrders.add(new _02_Coffee(coffeeName, size, price, orderNum));

                    // printing details of the coffee made
                    coffeeOrders.get(orderNum - 2).printInfo();
                    break;

                case "2":
                    if (!coffeeOrders.isEmpty()) {
                        for (_02_Coffee coffee : coffeeOrders) {
                            coffee.printInfo();
                        }
                    }
                    else {
                        System.out.println("There are no coffee orders to show :(");
                    }
                    break;

                default:
                    if (!choice.equals("3")) {
                        System.out.println("Invalid choice! Try again.");
                    }
            }
        } while (!choice.equals("3"));

        System.out.println("-- Closing the coffee shop --");
    }
}