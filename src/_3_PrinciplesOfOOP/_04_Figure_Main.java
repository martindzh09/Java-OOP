package _3_PrinciplesOfOOP;

import java.util.*;

class _04_Figure_Main {

    // (Static) method 1 - List with options
    static void optionsList() {
        System.out.println("\n" + "-------------");
        System.out.println("F I G U R E S");
        System.out.println("-------------");

        System.out.println("1. Triangle   |");
        System.out.println("2. Rectangle  |");
        System.out.println("3. Square     |");

        System.out.println("-------       |");
        System.out.println("4. Print DATA |");
        System.out.println("--------------");
    }

    // Main method (program 4.0)
    public static void main() {
        Scanner scrStr = new Scanner(System.in);
        Scanner scrNum = new Scanner(System.in);

        // ArrayList where different figures are saved
        ArrayList<_04_Figure> figures = new ArrayList<>();

        String option;

        do {
            optionsList(); // (static) method 1 is called

            System.out.println("\n" + "Choose an option... ");
            option = scrStr.nextLine();

            switch (option) {
                case "1":
                    System.out.println("--------");
                    System.out.println("TRIANGLE");
                    System.out.println("--------");

                    boolean existingTriangle;
                    double a, b, c;

                    do {
                        System.out.println("\n" + "Input data for side 'a': ");

                        do {
                            a = scrNum.nextDouble();

                            if (a <= 0) {
                                System.out.println("\n" + "Invalid data for side!");
                                System.out.println("Input again... ");
                            }
                        } while (a <= 0);

                        System.out.println("\n" + "Input data for side 'b': ");

                        do {
                            b = scrNum.nextDouble();

                            if (b <= 0) {
                                System.out.println("\n" + "Invalid data for side!");
                                System.out.println("Input again... ");
                            }
                        } while (b <= 0);

                        System.out.println("\n" + "Input data for side 'a': ");

                        do {
                            c = scrNum.nextDouble();

                            if (c <= 0) {
                                System.out.println("\n" + "Invalid data for side!");
                                System.out.println("Input again... ");
                            }
                        } while (c <= 0);

                        existingTriangle = (a + b > c) && (b + c > a) && (a + c > b);

                        if (!existingTriangle) {
                            System.out.println("Not a valid data for existing triangle :( ");
                        }
                    } while (!existingTriangle);

                    figures.add(new _04_1_Triangle(a, b, c));

                    break;

                case "2":
                    System.out.println("---------");
                    System.out.println("RECTANGLE");
                    System.out.println("---------");

                    double length, width;

                    System.out.println("\n" + "Input data for length: ");

                    do {
                        length = scrNum.nextDouble();

                        if (length <= 0) {
                            System.out.println("\n" + "Invalid data for length!");
                            System.out.println("Input again... ");
                        }
                    } while (length <= 0);

                    System.out.println("\n" + "Input data for width: ");

                    do {
                        width = scrNum.nextDouble();

                        if (width <= 0) {
                            System.out.println("\n" + "Invalid data for width!");
                            System.out.println("Input again... ");
                        }
                    } while (width <= 0);

                    figures.add(new _04_2_Rectangle(length, width));

                    break;

                case "3":
                    System.out.println("------");
                    System.out.println("SQUARE");
                    System.out.println("------");

                    double side;

                    System.out.println("\n" + "Input data for side: ");

                    do {
                        side = scrNum.nextDouble();

                        if (side <= 0) {
                            System.out.println("\n" + "Invalid data for side!");
                            System.out.println("Input again... ");
                        }
                    } while (side <= 0);

                    figures.add(new _04_3_Square(side));

                    break;

                default:
                    if (!option.equals("4")) {
                        System.out.println("\n" + "Invalid option!");
                    }
            }
        } while (!option.equals("4"));

        if (!figures.isEmpty()) {
            for (_04_Figure figure : figures) {
                System.out.println("\n" + "--------------------------");
                System.out.printf("Figure: %s", figure.getName());
                System.out.printf("%nPerimeter: %.2f cm%n", figure.getPerimeter());
            }
        }
        else {
            System.out.println("\n" + "* No data is saved!");
        }

        System.out.println("\n" + "-----------------------");
        System.out.println("Exiting the program... ");

        scrNum.close(); scrStr.close();
    }
}