package _3_PrinciplesOfOOP;

import java.util.*;

// Main class (03)
class _03_0_ShapeMain {

    // (Static) method 1 - Printing shapes' data
    static void shapesData(List<_03_Shape> shapes) {
        for (_03_Shape shape : shapes) {
            System.out.println("\n" + "--------------------------------------");
            System.out.printf("Shape type: %s%n", shape.shapeType);
            System.out.println("--------------------------------------");

            System.out.printf("Area: %s cm2%n", shape.area());
            System.out.printf("Perimeter: %.3f cm%n", shape.perimeter());
        }
    }

    // Main method (program)
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // new list collecting shapes' data
        List<_03_Shape> shapes = new ArrayList<>();

        // I. Circle
        System.out.println("\n" + "Input data for radius of CIRCLE: ");
        double radius;

        do {
            radius = scr.nextDouble();

            if (radius <= 0) {
                System.out.println("\n" + "Invalid data for radius!");
                System.out.println("Input again... ");
            }
        } while (radius <= 0);

        shapes.add(new _03_1_Circle("Circle", radius));

        // II. Rectangle
        System.out.println("\n" + "Input data for length of RECTANGLE: ");
        double length;

        do {
            length = scr.nextDouble();

            if (length <= 0) {
                System.out.println("\n" + "Invalid data for length!");
                System.out.println("Input again... ");
            }
        } while (length <= 0);

        System.out.println("\n" + "Input data for width of RECTANGLE: ");
        double width;

        do {
            width = scr.nextDouble();

            if (width <= 0) {
                System.out.println("\n" + "Invalid data for width!");
                System.out.println("Input again... ");
            }
        } while (width <= 0);

        shapes.add(new _03_2_Rectangle("Rectangle", length, width));

        // III. Triangle
        System.out.println("\n" + "Input data for side 'a' of TRIANGLE: ");
        double a;

        do {
            a = scr.nextDouble();

            if (a <= 0) {
                System.out.println("\n" + "Invalid data for side 'a'!");
                System.out.println("Input again... ");
            }
        } while (a <= 0);

        System.out.println("\n" + "Input data for side 'b' of TRIANGLE: ");
        double b;

        do {
            b = scr.nextDouble();

            if (b <= 0) {
                System.out.println("\n" + "Invalid data for side 'b'!");
                System.out.println("Input again... ");
            }
        } while (b <= 0);

        System.out.println("\n" + "Input data for side 'c' of TRIANGLE: ");
        double c;

        do {
            c = scr.nextDouble();

            if (c <= 0) {
                System.out.println("\n" + "Invalid data for side 'c'!");
                System.out.println("Input again... ");
            }
        } while (c <= 0);

        shapes.add(new _03_3_Triangle("Triangle", a, b, c));

        // IV. Square
        System.out.println("\n" + "Input data for side of SQUARE: ");
        double side;

        do {
            side = scr.nextDouble();

            if (side <= 0) {
                System.out.println("\n" + "Invalid data for side!");
                System.out.println("Input again... ");
            }
        } while (side <= 0);

        shapes.add(new _03_4_Square("Square", side));

        // Printing list's data for each shape
        shapesData(shapes);

        // Printing list's data with sorted areas
        shapes.sort(Comparator.comparingDouble(_03_Shape::area));
    }
}