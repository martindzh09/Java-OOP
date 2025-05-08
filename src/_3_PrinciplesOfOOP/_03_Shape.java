package _3_PrinciplesOfOOP;

// (Abstract) superclass
abstract class _03_Shape {
    String shapeType;
    double area;
    double perimeter;

    _03_Shape(String shapeType) {
        this.shapeType = shapeType;
    }

    // Abstract method 1 - Area's data
    abstract double area();

    // Abstract method 2 - Perimeter's data
    abstract double perimeter();
}

// Subclass 0.1
class _03_1_Circle extends _03_Shape {
    double radius;

    _03_1_Circle(String shapeType, double radius) {
        super(shapeType);
        this.radius = radius;
    }

    @Override
    double area() {
        area = Math.PI * Math.pow(radius, 2);

        return area;
    }

    @Override
    double perimeter() {
        perimeter = 2 * Math.PI * radius;

        return perimeter;
    }
}

// Subclass 0.2
class _03_2_Rectangle extends _03_Shape {
    double length;
    double width;

    _03_2_Rectangle(String shapeType, double length, double width) {
        super(shapeType);

        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        area = length * width;

        return area;
    }

    @Override
    double perimeter() {
        perimeter = 2 * length + 2 * width;

        return perimeter;
    }
}

// Subclass 0.3
class _03_3_Triangle extends _03_Shape {
    double a, b, c;

    _03_3_Triangle(String shapeType, double a, double b, double c) {
        super(shapeType);

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double area() {
        // calling (non-static) method from the class
        double p = this.perimeter() / 2; // half-parameter

        area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return area;
    }

    @Override
    double perimeter() {
        perimeter = a + b + c;

        return perimeter;
    }
}

// Subclass 0.4
class _03_4_Square extends _03_Shape {
    double side;

    _03_4_Square(String shapeType, double side) {
        super(shapeType);
        this.side = side;
    }

    @Override
    double area() {
        area = Math.pow(side, 2);

        return area;
    }

    @Override
    double perimeter() {
        perimeter = 4 * side;

        return perimeter;
    }
}