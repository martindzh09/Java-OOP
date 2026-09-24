package _4_ConstructorsTasks;

class _01_Hotel {
    private final boolean freeParking;
    private final boolean freeBreakfast;
    private final boolean freeInternet;

    // Constructor 1 - Assigning default values to fields
    _01_Hotel() {
        this.freeParking = true;
        this.freeBreakfast = false;
        this.freeInternet = false;
    }

    // Constructor 2 - Overloading constructor 1 as user intends to customize the service
    _01_Hotel(boolean freeParking, boolean freeBreakfast, boolean freeInternet) {
        this.freeParking = freeParking;
        this.freeBreakfast = freeBreakfast;
        this.freeInternet = freeInternet;
    }

    void allData() {
        // Only available services (with value 'true') are printed as messages

        if (this.freeParking)
            System.out.println("| -> Free parking is included, you are able to leave your car there. |");

        if (this.freeBreakfast)
            System.out.println("| -> Free breakfast is included, you can enjoy our meals every morning. |");

        if (this.freeInternet)
            System.out.println("| -> Free internet access is included, you will be given a password at the reception. |");
    }
}