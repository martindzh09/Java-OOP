package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class _06_1_TasksList {
    static void options() {
        System.out.println("\n" + "________________________ ");
        System.out.println("1. ADD                  |");
        System.out.println("2. SHOW ALL             |");
        System.out.println("3. MARK AS FINISHED     |");
        System.out.println("4. SHOW ONLY UNFINISHED |");
        System.out.println("5. Exit                 |");
        System.out.println("------------------------" + "\n");
    }

    public static void main(String[] args) {
        Scanner scrStr = new Scanner(System.in);
        Scanner scrInt = new Scanner(System.in);

        ArrayList<_06_Task> tasks = new ArrayList<>();

        /* used for generating unique ID (Integer type) of each next member added; starting >10 */
        AtomicInteger uniqueId = new AtomicInteger(10);

        String option;

        do {
            options();
            option = scrStr.nextLine();

            switch (option) {
                case "1":
                    int id = uniqueId.getAndIncrement(); // generating an id

                    System.out.println("\n" + "-- Set a title for the task --");
                    String title = scrStr.nextLine();

                    System.out.println("\n" + "-- Describe the task --");
                    String description = scrStr.nextLine();

                    System.out.println("\n" + "-- Set task a priority from not important (1) to very important (5) --");
                    int priority;

                    do {
                        priority = scrInt.nextInt();

                        if (priority < 1 || priority > 5) {
                            System.out.println("Invalid data! (1-5)");
                        }
                    } while (priority < 1 || priority > 5);

                    System.out.println("\n" + "Adding a new task..., *check option 2");
                    tasks.add(new _06_Task(id, title, description, priority));
                    break;

                case "2":
                    if (!tasks.isEmpty()) {
                        System.out.println("\n" + "-- ALL TASKS DATA --");
                        for (_06_Task task : tasks) {
                            task.printInfo();
                        }
                    }
                    else {
                        System.out.println("\n" + "No tasks are added :|");
                    }
                    break;

                case "3":
                    if (!tasks.isEmpty()) {
                        System.out.println("\n" + "-- CHANGE STATUS OF A TASK BY ID --");

                        System.out.println("\n" + "Enter a valid ID: ");
                        int searchId;

                        do {
                            searchId = scrInt.nextInt();

                            if  (searchId < 10) {
                                System.out.println("Invalid ID!");
                            }
                        } while (searchId < 10);

                        boolean existingId = false;

                        for  (_06_Task task : tasks) {
                            if (task.getId() == searchId) {
                                existingId = true;

                                if (task.getFinishedInverted()) {
                                    task.setFinished();
                                    System.out.println("\n" + "_06_Task #" + searchId + " is finished.");
                                }
                                else {
                                    System.out.println("\n" + "* _06_Task's status is already set FINISHED");
                                }
                                break;
                            }
                        }

                        if (!existingId) {
                            System.out.println("ID " + searchId + " does not exist!") ;
                        }
                    } else {
                        System.out.println("\n" + "No tasks are added :|");
                    }
                    break;

                case "4":
                    if (!tasks.isEmpty()) {
                        boolean unfinishedTasks = false;

                        for (_06_Task task : tasks) {
                            if (task.getFinishedInverted()) {
                                unfinishedTasks = true;
                                task.printInfo();
                            }
                        }

                        if (!unfinishedTasks) {
                            System.out.println("\n" + "* All tasks are finished");
                        }
                    } else {
                        System.out.println("\n" + "No tasks are added :|");
                    }
                    break;

                default:
                    if (!option.equals("5")) {
                        System.out.println("Invalid option! (1-5)");
                    }
            }
        } while (!option.equals("5"));

        System.out.println("\n" + "Exiting the program...");
    }
}