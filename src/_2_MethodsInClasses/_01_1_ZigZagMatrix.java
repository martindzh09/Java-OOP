package _2_MethodsInClasses;

public class _01_1_ZigZagMatrix {

    public static void main(String[] args) {
        // creating an object, instance of the class "01_ZigZagMatrix"
        _01_0_ZigZagMatrix object = new _01_0_ZigZagMatrix();

        // assigning a value to field using Method I from the same class
        object.n = object.matrixSizing(); // field 1 is assigned a value

        // assigning data to 2D array using Method II from the same class where this field is defined
        object.matrix = object.matrixData(object.n); // field 2 is assigned a value

        // calling Method III from the superclass object is instanced from
        object.zigZagPrint(object.matrix); // a field from the superclass is used as a parameter
    }
}