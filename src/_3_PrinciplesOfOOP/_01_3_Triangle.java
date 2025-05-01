package _3_PrinciplesOfOOP;

// Subclass "Triangle" (3)
class _01_3_Triangle extends _01_Shape {
    // new specific fields in subclass
    double side;
    double height;

    // constructor of class "_01_3_Triangle"
    _01_3_Triangle(double side, double height) {
        // calling constructor of the superclass
        super("Triangle");

        this.side = side;
        this.height = height;
    }

    @Override
    double getArea() { // abstract method 1 is implemented
        return (side * height) / 2;
    }

    @Override
    String getName() { // abstract method 2 is implemented
        return shapeName;
    }
}