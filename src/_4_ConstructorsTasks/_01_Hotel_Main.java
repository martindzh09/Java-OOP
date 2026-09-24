package _4_ConstructorsTasks;
import java.util.Scanner;

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
        String choice;
        System.out.println("Choose whether to change your services for your " +
                "stay or keep the default pack (no parking and internet included in it).");

        System.out.println(" __________________________");
        System.out.println("| CHANGE (c) / DEFAULT (d) |" + "\n");
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

                    System.out.println("\n" + "| Would you like to benefit from our super fast" +
                            "internet network during your stay? |");
                    boolean freeInternet;
                    answer = returnAnswer();

                    freeInternet = answer.equals("y");

                    _01_Hotel customPack = new  _01_Hotel(useParking, includeBreakfast, freeInternet);
                    System.out.println("\n" + "| ORDERING A CUSTOM PACK |");
                    System.out.println("--------------------------");

                    customPack.allData();
                    break;

                case "d":
                    System.out.println("\n" + "| ORDERING A DEFAULT PACK |");

                    _01_Hotel defaultPack = new _01_Hotel();
                    System.out.println("---------------------------");

                    defaultPack.allData();
                    break;

                default:
                    invalidChoice = true;
            }
        } while (invalidChoice);

        scr.close();
    }
}