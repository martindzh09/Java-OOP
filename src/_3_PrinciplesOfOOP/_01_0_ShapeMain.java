package _3_PrinciplesOfOOP;

import java.util.*;

class _01_0_ShapeMain {

    // Static Method 1 - List with options for shapes
    static void optionsList() {
        System.out.println("\n" + "OPTIONS:");
        System.out.println("--------");

        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("4. Square");

        System.out.println("------------------------------------------");
        System.out.println("5. Review of saved data (ends the program)");
    }

    // Main method (program 01)
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // ArrayList where shapes are saved
        ArrayList<_01_Shape> shapes = new ArrayList<>();

        int option;

        do {
            optionsList(); // (static) method 1 is called

            System.out.println("\n" + "Which of the options do you choose?");
            option = scr.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n" + "CIRCLE");

                    System.out.println("\n" + "Input data for radius of the circle: ");
                    double radius;

                    do {
                        radius = scr.nextDouble();

                        if (radius <= 0) {
                            System.out.println("\n" + "Invalid data for RADIUS!");
                            System.out.println("Input again... ");
                        }
                    } while (radius <= 0);

                    // referring to an object of type _01_1_Circle, an inheritor class "_01_Shape"
                    _01_Shape circle = new _01_1_Circle(radius);

                    // adding a new object of type "_01_Shape" ("_01_1_Circle") in the ArrayList
                    shapes.add(circle);

                    System.out.printf("%nData for %s: %n", circle.getName());
                    System.out.println("-----------------------------");
                    System.out.printf("Area: %.2f cm2%n", circle.getArea());

                    break;

                case 2:
                    System.out.println("\n" + "RECTANGLE");

                    System.out.println("\n" + "Input data for LENGTH: ");
                    double length;

                    do {
                        length = scr.nextDouble();

                        if (length <= 0) {
                            System.out.println("\n" + "Invalid data for length!");
                            System.out.println("Input again... ");
                        }
                    } while (length <= 0);

                    System.out.println("\n" + "Input data for WIDTH: " );
                    double width;

                    do {
                        width = scr.nextDouble();

                        if (width <= 0) {
                            System.out.println("\n" + "Invalid data for width!");
                            System.out.println("Input again... ");
                        } else if (width > length) {
                            System.out.println("\n" + "* Width is usually less than the length!");
                            System.out.println("Input again... ");
                        }
                    } while (width <= 0 || width > length);

                    // referring to an object of type _01_2_Rectangle, an inheritor class "_01_Shape"
                    _01_Shape rectangle = new _01_2_Rectangle(length, width);

                    // adding a new object of type "_01_Shape" ("_01_2_Rectangle") in the ArrayList
                    shapes.add(rectangle);

                    System.out.printf("%nData for %s: %n", rectangle.getName());
                    System.out.println("-----------------------------");
                    System.out.printf("Area: %.2f cm2%n", rectangle.getArea());

                    break;

                case 3:
                    System.out.println("\n" + "TRIANGLE");

                    System.out.println("\n" + "Input data for SIDE of triangle: ");
                    double side;

                    do {
                        side = scr.nextDouble();

                        if (side <= 0) {
                            System.out.println("\n" + "Invalid data for side!");
                            System.out.println("Input again... ");
                        }
                    } while (side <= 0);

                    System.out.println("\n" + "Input data for HEIGHT to this side: ");
                    double height;

                    do {
                        height = scr.nextDouble();

                        if (height <= 0) {
                            System.out.println("\n" + "Invalid data for height!");
                            System.out.println("Input again... ");
                        }
                    } while (height <= 0);

                    // referring to an object of type _01_2_Rectangle, an inheritor class "_01_Shape"
                    _01_Shape triangle = new _01_3_Triangle(side, height);

                    // adding a new object of type "_01_Shape" ("_01_3_Triangle") in the ArrayList
                    shapes.add(triangle);

                    System.out.printf("%nData for %s: %n", triangle.getName());
                    System.out.println("-----------------------------");
                    System.out.printf("Area: %.2f cm2%n", triangle.getArea());

                    break;

                case 4:
                    System.out.println("\n" + "SQUARE");

                    System.out.println("\n" + "Input data for SIDE of square: ");
                    double sideSquare;

                    do {
                        sideSquare = scr.nextDouble();

                        if (sideSquare <= 0) {
                            System.out.println("\n" + "Invalid data for side!");
                            System.out.println("Input again... ");
                        }
                    } while (sideSquare <= 0);

                    // referring to an object of type _01_2_Rectangle, an inheritor class "_01_Shape"
                    _01_Shape square = new _01_4_Square(sideSquare);

                    // adding a new object of type "_01_Shape" ("_01_4_Square") in the ArrayList
                    shapes.add(square);

                    System.out.printf("%nData for %s: %n", square.getName());
                    System.out.println("-----------------------------");
                    System.out.printf("Area: %.2f cm2%n", square.getArea());

                    break;

                default:
                    if (option != 5) {
                        System.out.println("\n" + "Wrong option is chosen!");
                    }
            }
        } while (option != 5);

        System.out.println("\n" + "Count of each shape type you saved in ArrayList: ");
        System.out.println("------------------------------------------------");

        int circles = 0, rectangles = 0, triangles = 0, squares = 0;

        // counting shapes by their names
        for (_01_Shape shape : shapes) {
            if (shape.getName().equals("Circle")) {
                circles++;
            } else if (shape.getName().equals("Rectangle")) {
                rectangles++;
            } else if (shape.getName().equals("Triangle")) {
                triangles++;
            } else if (shape.getName().equals("Square")) {
                squares++;
            }
        }

        System.out.printf("CIRCLES: %d", circles);
        System.out.printf("%nRECTANGLES: %d", rectangles);
        System.out.printf("%nTRIANGLES: %d", triangles);
        System.out.printf("%nSQUARES: %d%n", squares);

        scr.close();
    }
}