package _3_PrinciplesOfOOP;

// Subclass "_01_1_Circle" (1)
class _01_1_Circle extends _01_Shape {
    double radius; // new specific field in subclass

    // constructor of class "_01_1_Circle"
    _01_1_Circle(double radius) {
        // calling constructor of the superclass
        super("Circle");
        this.radius = radius;
    }

    @Override
    double getArea() { // abstract method 1 is implemented
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    String getName() { // abstract method 2 is implemented
        return shapeName;
    }
}