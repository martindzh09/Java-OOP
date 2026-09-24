package _4_ConstructorsTasks;
import java.util.Scanner; import java.util.ArrayList;

class _01_Hotel_Main {
    private static final Scanner scr = new Scanner(System.in);

    static String returnAnswer() {
        String answer;
        do {
            answer = scr.nextLine();

            if (!(answer.equals("y") || answer.equals("n"))) {
                System.out.println("Invalid answer! Try again.");
            }
        } while (!(answer.equals("y") || answer.equals("n")));

        return answer;
    }

    public static void main(String[] args) {
        // A new collection is created in order to save all orders for different packs
        ArrayList<_01_Hotel> requestedOrders = new  ArrayList<>();
        String choice;

        do {
            System.out.println();
            System.out.println("-- Choose whether to change your services for your\n" +
                    "stay or keep the default pack (no parking and internet included in it). --");

            System.out.println(" ______________________________________ ");
            System.out.println("| CHANGE (c) / DEFAULT (d) / END (end) |" + "\n");
            boolean invalidChoice;

            do {
                invalidChoice = false;
                choice = scr.nextLine();

                switch (choice) {
                    case "c":
                        System.out.println("_____________________________________________________________" +
                                "_________________________________");
                        System.out.println("*On the next 3 questions answer with single lowercase letters - " +
                                "'y' to accept or 'n' to decline.");
                        String answer;

                        System.out.println("\n" + "| Do you prefer using our PARKING included in your price? |");
                        boolean useParking;
                        answer = returnAnswer();

                        useParking = answer.equals("y");

                        System.out.println("\n" + "| Would you like an included BREAKFAST every day within your stay? |");
                        boolean includeBreakfast;
                        answer = returnAnswer();

                        includeBreakfast = answer.equals("y");

                        System.out.println("\n" + "| Would you like to benefit from our super fast " +
                                "INTERNET network during your stay? |");
                        boolean freeInternet;
                        answer = returnAnswer();

                        freeInternet = answer.equals("y");

                        _01_Hotel customPack = new _01_Hotel(useParking, includeBreakfast, freeInternet);
                        System.out.println("\n" + "| CUSTOM PACK ORDERED |");
                        System.out.println(" --------------------- ");
                        customPack.allData();

                        requestedOrders.add(customPack); // adding a custom pack to list of all orders
                        break;

                    case "d":
                        _01_Hotel defaultPack = new _01_Hotel();
                        System.out.println("\n" + "| DEFAULT PACK ORDERED |");
                        System.out.println(" ---------------------- ");
                        defaultPack.allData();

                        requestedOrders.add(defaultPack);
                        break;

                    default:
                        if (!choice.equals("end"))
                            invalidChoice = true;
                }
            } while (invalidChoice);
        } while (!choice.equals("end"));

        System.out.println("\n" + "| LISTING ALL ORDERS REQUESTED (from first to last) |");
        double hotelsTotalProfit = 0.00;

        if (requestedOrders.isEmpty()) {
            System.out.println("There are no orders requested :|.");
        }
        else {
            for (int i = 0; i < requestedOrders.size(); i++) {
                int orderNum = i + 1;

                System.out.println("\n| #" + orderNum + " |");
                requestedOrders.get(i).allData();

                hotelsTotalProfit += requestedOrders.get(i).packPrice;
            }
        }

        System.out.printf("%n| Total profit of %d ordered packs: %.2f euro |%n",
                requestedOrders.size(), hotelsTotalProfit);

        scr.close();
    }
}