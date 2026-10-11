package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;

class _04_1_OnlineShop {
    static void options() {
        System.out.println("--------------------------");
        System.out.println("1. Enter and sell product |");
        System.out.println("2. EXIT                   |");
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner scrStr = new Scanner(System.in); Scanner scrNum = new Scanner(System.in);

        String choice;

        do {
            options();
            choice = scrStr.nextLine();

            if (choice.equals("1")) {
                System.out.println("\nEnter product's name: ");
                String productName = scrStr.nextLine();

                System.out.println("\nEnter product's price: ");
                double price;

                do {
                    price = scrNum.nextDouble();

                    if (price <= 0.00) {
                        System.out.println("Invalid price!");
                    }
                } while (price <= 0.00);

                System.out.println("\nWhat is the quantity you would like to buy?");
                int quantity;

                do {
                    quantity = scrNum.nextInt();

                    if (quantity <= 0) {
                        System.out.println("Invalid quantity!");
                    }
                } while (quantity <= 0);

                _04_Product product = new _04_Product(productName, price);

                System.out.println("\n| Before changes |");
                product.printInfo();

                product.sell(quantity);
                System.out.println("\n| After changes |");
                product.printInfo();
            }
            else {
                if (!choice.equals("2")) {
                    System.out.println("Invalid input!");
                }
            }
        } while (!choice.equals("2"));

        System.out.println("\nExiting online shop...");
        scrStr.close(); scrNum.close();
    }
}