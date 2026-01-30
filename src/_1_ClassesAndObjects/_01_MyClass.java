package _1_ClassesAndObjects;

public class _01_MyClass {
    int x = 3;
    int y = 5;

    public static void main(String[] args) {
        // creating an instance (object) of the class '_01_MyClass'
        _01_MyClass myObject = new _01_MyClass();

        // the field 'x' of the class is accesses via the object
        System.out.println(myObject.x);

        // the field 'y' of the class is accessed through the object
        System.out.println(myObject.y);
    }
}
