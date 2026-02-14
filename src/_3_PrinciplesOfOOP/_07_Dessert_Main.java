package _3_PrinciplesOfOOP;
import java.util.Scanner;

class _07_Dessert_Main {
    // Static method 1
    static void optionsList() {
        System.out.println("\n" + "|_ SWEET'S SHOP _|");

        System.out.println("| 1. Show all desserts                  |");
        System.out.println("| 2. Sales by ID and quantity available |");
        System.out.println("| 3. Update stock of a certain dessert  |");
        System.out.println("| 4. Change PRICE                       |");
        System.out.println("| 5. Modification of DISCOUNT           |");
        System.out.println("| 6. Total profit                       |");
        System.out.println("| 7. Customers' most bought product     |");
        System.out.println(" --------------------------------------- ");

        System.out.println("| 0. _EXIT_ |");
    }

    // Main method of "_07_Dessert_Main"
    public static void main(String[] args) {
        Scanner scrString = new Scanner(System.in); // scanner for 'String' type
        Scanner scrNum = new Scanner(System.in); // scanner for number types

        System.out.println("__________________________________________");
        System.out.println("I. How many desserts does your shop offer?");
        System.out.println("__________________________________________");

        int n;
        do {
            n = scrNum.nextInt();

            if (n < 1) {
                System.out.println("Invalid data :|\nInput again... ");
            }
        } while (n < 1);

        _07_Dessert[] desserts = new _07_Dessert[n];

        System.out.println("_______________________________");
        System.out.println("II. Input data for each dessert");
        System.out.println("_______________________________" + "\n");

        for (int i = 0; i < desserts.length; i++) {
            System.out.printf("%n-------- |%d| --------%n", (i + 1));
            System.out.println("Input ID for dessert: ");

            int id = scrNum.nextInt();

            System.out.println("-----------------------");
            System.out.println("Input NAME for dessert: ");

            String name = scrString.nextLine();

            System.out.println("---------------------");
            System.out.println("Input PRICE for dessert: ");

            double price;
            do {
                price = scrNum.nextDouble();

                if (price <= 0.00) {
                    System.out.println("Invalid price :|\nInput again... ");
                }
            } while (price <= 0.00);

            System.out.println("---------------------");
            System.out.println("Input STOCK for dessert: ");

            int stock;
            do {
                stock = scrNum.nextInt();

                if (stock < 0) {
                    System.out.println("Invalid data for stock :|\nInput again... ");
                }
            } while (stock < 0);

            boolean onSale = false; // a first default value 'false' is set

            // Object, part of the array, is assigned data via parameters
            desserts[i] = new _07_Dessert(id, name, price, stock, 0, onSale);
        }

        int option; double totalProfit = 0.00;
        do {
            optionsList(); // static method 1 is called

            System.out.println("___________________");
            System.out.println("Choose an option... ");

            option = scrNum.nextInt();
            int id; // *used below in some cases

            switch (option) {
                case 1:
                    for (_07_Dessert dessert : desserts) {
                        dessert.allDetails();
                    }
                    break;

                case 2:
                    System.out.println("________________");
                    System.out.println("Type in an ID... ");

                    id = scrNum.nextInt();

                    for (_07_Dessert dessert : desserts) {
                        if (id == dessert.getId()) {
                            int quantity;
                            System.out.println("\n" + "How many portions of '" +
                                    dessert.getName() + "' would you like to buy?");
                            do {
                                quantity = scrNum.nextInt();

                                if (quantity <= 0) {
                                    System.err.println("Invalid data for quantity :|");
                                    System.out.println("Input again... ");
                                }
                            } while (quantity <= 0);

                            double price;

                            if (quantity > dessert.getStock()) {
                                System.out.println("Not enough stock available right now :(");
                                System.out.println("We apologize for the inconvenience!");
                            }
                            else {
                                if (dessert.getOnSale()) {
                                    // price with discount of 10%
                                    price = dessert.getPrice() - (0.1 * dessert.getPrice());

                                    System.out.println("\n" + "-- Discount of 10% --");
                                }
                                else {
                                    price = dessert.getPrice();
                                }

                                dessert.setStock(dessert.getStock() - quantity);
                                totalProfit += price * quantity;
                                dessert.setSold(dessert.getSold() + quantity);

                                System.out.printf("Your sum is: %.2f euro %n", (price * quantity));
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("________________");
                    System.out.println("Type in an ID... ");

                    id = scrNum.nextInt();

                    for (_07_Dessert dessert : desserts) {
                        if (id == dessert.getId()) {
                            int quantity;
                            System.out.println("\n" + "How many portions of '" +
                                    dessert.getName() +"' would you like to ADD?");
                            do {
                                quantity = scrNum.nextInt();

                                if (quantity <= 0) {
                                    System.out.println("Invalid data for quantity :|");
                                    System.out.println("Input again... ");
                                }
                            } while (quantity <= 0);

                            dessert.setStock(dessert.getStock() + quantity);
                            System.out.println("Dessert's current stock has just been updated.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("________________");
                    System.out.println("Type in an ID... ");

                    id = scrNum.nextInt();

                    for (_07_Dessert dessert : desserts) {
                        if (id == dessert.getId()) {
                            double price;
                            System.out.println("\n" + "Input a new price... ");
                            do {
                                price = scrNum.nextDouble();

                                if (price <= 0.00) {
                                    System.out.println("Invalid data for price :|");
                                    System.out.println("Input again... ");
                                }
                            } while (price <= 0.00);

                            dessert.setPrice(price);
                            System.out.println("Dessert's price has just been changed.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("________________");
                    System.out.println("Type in an ID... ");

                    id = scrNum.nextInt();

                    for (_07_Dessert dessert : desserts) {
                        if (id == dessert.getId()) {
                            if (dessert.getOnSale()) {
                                dessert.setOnSale(false);
                                System.out.println("*Dessert's price will not be discounted.");
                            }
                            else {
                                dessert.setOnSale(true);
                                System.out.println("*Dessert's price will be reduced by 10% until you change it.");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n" + "________________________________");
                    System.out.printf("Total sum of all sales: %.2f euro%n", totalProfit);
                    System.out.println("--------------------------------");
                    break;

                case 7:
                    // the first one value is set for max
                    int soldMax = desserts[0].getSold();

                    for (_07_Dessert dessert : desserts) {
                        if (dessert.getSold() > soldMax) {
                            // value is changed whether a greater one is found
                            soldMax = dessert.getSold();
                        }
                    }

                    System.out.println("\n" + "_______________________________");
                    System.out.println("The most sold dessert/s is/are: ");

                    // A possible case - two or more desserts' sold quantities are equal
                    for (_07_Dessert dessert : desserts) {
                        if (dessert.getSold() == soldMax) {
                            dessert.allDetails();
                        }
                    }
                    break;

                default:
                    if (option != 0) {
                        System.out.println("Invalid option");
                    }
            }
        } while (option != 0);

        // It occurs when the last option (0) is selected
        System.out.println("\n" + "Exiting the program... ");

        scrNum.close(); scrString.close();
    }
}