package _3_PrinciplesOfOOP;

// Abstract superclass "_01_Shape"
abstract class _01_Shape {
    String shapeName;

    // superclass' constructor
    _01_Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    // Abstract method 1 - Area of shape
    abstract double getArea();

    // Abstract method 2 - Name of shape
    abstract String getName();
}