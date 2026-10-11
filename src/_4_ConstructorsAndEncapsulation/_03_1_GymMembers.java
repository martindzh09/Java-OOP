package _4_ConstructorsAndEncapsulation;
import java.util.Scanner; import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class _03_1_GymMembers {
    // used for options with restricted access
    private static final String adminPass = "1234";

    static void options() {
        System.out.println("\n" + "--------------------------------------------");
        System.out.println("I. Add a new member to the gym");
        System.out.println("II. Change subscription of a member by ID");
        System.out.println("III. Print info for a member by ID");
        System.out.println("IV. Print info for all members (admin access)");
        System.out.println("V. EXIT");
        System.out.println("--------------------------------------------");
    }

    static int checkId(ArrayList<_03_Member> members) {
        Scanner scrId = new Scanner(System.in);

        System.out.println("\n" + "Enter a valid ID -> ");
        int id;

        do {
            id = scrId.nextInt();

            if (id < 100) {
                System.out.println("Invalid ID!");
            }
        } while (id < 100);

        int saveIndex = -1;

        if (!members.isEmpty()) {
            for (_03_Member member : members) {
                if (member.getId() == id) {
                    saveIndex = members.indexOf(member);
                }
            }
        }
        else {
            System.out.println("\n" + "(There have not been any members added yet.)");
        }

        return saveIndex;
    }

    public static void main(String[] args) {
        Scanner scrStr = new Scanner(System.in); Scanner scrNum = new Scanner(System.in);

        // creating a new collection where data for each member will be stored
        ArrayList<_03_Member> members = new ArrayList<>();

        // used for generating unique ID (Integer type) of each next member added
        AtomicInteger uniqueId = new AtomicInteger(99);

        String optionChoice;
        int getIndex = 0;

        do {
            options(); // printing list of options
            int searchIDIndex;

            System.out.println("\n" + "Choose an option as you type one digit (1-5).");
            optionChoice = scrStr.nextLine();

            switch (optionChoice) {
                case "1":
                    System.out.println("| ADDING A NEW MEMBER |");
                    int id = uniqueId.incrementAndGet();

                    System.out.println("\n" + "Name -> ");
                    String name = scrStr.nextLine();

                    System.out.println("\n" + "Age -> ");
                    int age;

                    do {
                        age = scrNum.nextInt();

                        if (age <= 0) {
                            System.out.println("Invalid age!");
                        }
                    } while (age <= 0);

                    members.add(new _03_Member(id, name, age));

                    // printing info for the new member
                    System.out.println("\n" + "| INFO FOR NEW MEMBER |");
                    members.get(getIndex).printInfo(); getIndex++;

                    // id search is used in other cases
                    System.out.println("* Remember the ID *");
                    break;

                case "2":
                    if (!members.isEmpty()) {
                        System.out.println("\n" + "| CHANGING SUBSCRIPTION OF MEMBER |");
                        System.out.println("-- activation (a) / deactivation (d) --");

                        String option;
                        boolean invalidOption;

                        do {
                            option = scrStr.nextLine();

                            invalidOption = !option.startsWith("a") && !option.startsWith("A") &&
                                    !option.startsWith("d") && !option.startsWith("D");

                            if (invalidOption) {
                                System.out.println("Invalid choice! Try again.");
                            }
                        } while (invalidOption);

                        // checking for a present id in the list and getting index of member it is assigned to
                        searchIDIndex = checkId(members);

                        if (searchIDIndex != -1) {
                            if (option.startsWith("a") || option.startsWith("A")) {
                                // an activation of subscription is occurred
                                members.get(searchIDIndex).activate();

                                // printing info to view the changes
                                members.get(searchIDIndex).printInfo();
                            } else {
                                // a deactivation of subscription is occurred
                                members.get(searchIDIndex).deactivate();

                                // printing info to view the changes
                                members.get(searchIDIndex).printInfo();
                            }
                        } else {
                            System.out.println("\n" + "/ ID is not found! Check option 4 as an admin. /");
                        }
                    }
                    else {
                        System.out.println("\n" + "(There have not been any members added yet.)");
                    }
                    break;

                case "3":
                    if (!members.isEmpty()) {
                        searchIDIndex = checkId(members);

                        if (searchIDIndex != -1) {
                            // printing info for a certain member of the gym
                            members.get(searchIDIndex).printInfo();
                        } else {
                            System.out.println("\n" + "/ ID is not found! Check option 4 as an admin. /");
                        }
                    }
                    else {
                        System.out.println("\n" + "(There have not been any members added yet.)");
                    }
                    break;

                case "4":
                    System.out.println("\n" + "| INFO FOR ALL MEMBERS |");
                    System.out.println("Password (admin): ");

                    String password; int countTries = 0;

                    do {
                        password = scrStr.nextLine();

                        if (!password.equals(adminPass)) {
                            System.out.println("Invalid password!");
                            countTries++;
                        }
                        else {
                            break;
                        }
                    } while (countTries < 3);

                    if (password.equals(adminPass)) {
                        if (!members.isEmpty()) {
                            for (_03_Member member : members) {
                                member.printInfo();
                            }
                        }
                        else {
                            System.out.println("\n" + "(There have not been any members added yet.)");
                        }
                    }
                    break;

                default:
                    if (!optionChoice.equals("5")) {
                        System.out.println("Invalid choice! Try again.");
                    }
            }
        } while (!optionChoice.equals("5"));

        System.out.println("\n" + "Exiting the program... ");

        scrNum.close(); scrStr.close();
    }
}