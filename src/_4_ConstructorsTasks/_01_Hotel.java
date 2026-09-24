package _4_ConstructorsTasks;

class _01_Hotel {
    private final boolean freeParking;
    private final boolean freeBreakfast;
    private final boolean freeInternet;
    double packPrice;

    // Constructor 1 - Assigning default values to fields (default pack)
    _01_Hotel() {
        this.freeParking = true;
        this.freeBreakfast = false;
        this.freeInternet = false;

        // set a total example price value for the whole stay in the hotel
        this.packPrice = 80.00;
    }

    // Constructor 2 - Overloading constructor 1 as user intends to customize the service (custom pack)
    _01_Hotel(boolean freeParking, boolean freeBreakfast, boolean freeInternet) {
        this.freeParking = freeParking;
        this.freeBreakfast = freeBreakfast;
        this.freeInternet = freeInternet;

        this.packPrice = 0.00; /* a temporary set value, increased in conditional
            statements below, depending on each of 3 services ordered */

        if (this.freeParking) {
            this.packPrice += 40.00;
        }
        if (this.freeBreakfast) {
            this.packPrice += 50.00;
        }
        if (this.freeInternet) {
            this.packPrice += 35.00;
        }
        if (!(this.freeParking || this.freeBreakfast || this.freeInternet)) {
            this.packPrice = 75.00;
        }
    }

    void allData() {
        boolean noServices = !this.freeParking && !this.freeBreakfast && !this.freeInternet;

        if (this.freeParking)
            System.out.println("| -> FREE PARKING is included, you are able to leave your car there. |");

        if (this.freeBreakfast)
            System.out.println("| -> FREE BREAKFAST is included, you can enjoy our meals every morning. |");

        if (this.freeInternet)
            System.out.println("| -> FREE INTERNET access is included, you will be given a password at the reception. |");

        if (noServices)
            System.out.println("| -> No services are requested in this pack. |");

        System.out.printf("-> Price: %.2f euro%n", this.packPrice);
    }
}