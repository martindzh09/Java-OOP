package _1_ClassesAndObjects;

public class _02_FieldsValue {
    int x = 15;

    // 'final' - constant value modifier
    final int z = 3; // value cannot be changed

    public static void main() {
        // creating an object of the class '_02_FieldsValue'
        _02_FieldsValue myObject = new _02_FieldsValue();

        // a value of the field 'x' is changed
        myObject.x = 1;
        System.out.println(myObject.x);

        // final value 'z' cannot be changed
        System.out.println(myObject.z);
    }
}
