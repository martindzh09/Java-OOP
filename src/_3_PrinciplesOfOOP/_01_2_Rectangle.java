package _3_PrinciplesOfOOP;

// Subclass "Rectangle" (2)
class _01_2_Rectangle extends _01_Shape {
    // new specific fields in subclass
    double height;
    double width;

    // constructor of class "_01_2_Rectangle"
    _01_2_Rectangle(double height, double width) {
        // calling constructor of the superclass
        super("Rectangle");

        this.height = height;
        this.width = width;
    }

    @Override
    double getArea() { // abstract method 1 is implemented
        return height * width;
    }

    @Override
    String getName() { // abstract method 2 is implemented
        return shapeName;
    }
}