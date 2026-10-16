package _4_ConstructorsAndEncapsulation;

class _05_Car {
    private final int id;
    String brand;
    String model;
    String regNumber;
    int year;

    // static (belongs to class) counter for cars added
    static int addedCars = 0;

    _05_Car(int id, String brand, String model, String regNumber, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.regNumber = regNumber;
        this.year = year;

        addedCars++; // incrementing static variable every time constructor method is used
    }

    int getId() {
        return this.id;
    }

    static void removedCar() {
        addedCars--;
    }

    void printInfo() {
        System.out.println("\n" + "____________________________________");
        System.out.println("_05_Car #" + this.id + ": " + this.brand + " "
                + this.model + ", " + this.regNumber + " (" + this.year + ")");
    }
}