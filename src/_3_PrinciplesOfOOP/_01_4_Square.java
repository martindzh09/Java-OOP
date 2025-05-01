package _3_PrinciplesOfOOP;

// Subclass "Rectangle" (2)
class _01_4_Square extends _01_Shape {
    // new specific field in subclass
    double side;

    // constructor of class "_01_4_Square"
    _01_4_Square(double side) {
        // calling constructor of the superclass
        super("Square");
        this.side = side;
    }

    @Override
    double getArea() { // abstract method 1 is implemented
        return side * side;
    }

    @Override
    String getName() { // abstract method 2 is implemented
        return shapeName;
    }
}