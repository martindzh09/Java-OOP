package _3_PrinciplesOfOOP;

abstract class _04_Figure {
    String figureName;

    // (abstract) superclass' constructor (1.0)
    _04_Figure(String figureName) {
        this.figureName = figureName;
    }

    // (Abstract) method 1 - Getting parameter of figure
    abstract double getPerimeter();

    // Method 2 - Getting figure's name
    String getName() {
        return figureName;
    }
}

// Inheritor 1 - Triangle
class _04_1_Triangle extends _04_Figure {
    double a, b, c;

    // constructor (1.1)
    _04_1_Triangle(double a, double b, double c) {
        super("Triangle");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override // 1st implementation of abstract method 1
    double getPerimeter() {
        return a + b + c;
    }
}

// Inheritor 2 - Rectangle
class _04_2_Rectangle extends _04_Figure {
    double length;
    double width;

    // constructor (1.2)
    _04_2_Rectangle(double length, double width) {
        super("Rectangle");

        this.length = length;
        this.width = width;

    }

    @Override // 2nd implementation of abstract method 1
    double getPerimeter() {
        return (2 * length) + (2 * width);
    }
}

// Inheritor 3 - Square
class _04_3_Square extends _04_Figure {
    double side;

    // constructor (1.3)
    _04_3_Square(double side) {
        super("Square");
        this.side = side;
    }

    @Override // 3rd implementation of abstract method 1
    double getPerimeter() {
        return 4 * side;
    }
}