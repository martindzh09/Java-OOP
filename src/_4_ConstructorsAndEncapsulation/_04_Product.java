package _4_ConstructorsAndEncapsulation;

class _04_Product {
    String name;
    double price;
    private int quantity = 100; // assigned a default value for each object

    _04_Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void sell(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        }
        else {
            System.out.println("\n" + "* Negative quantity *");
            this.quantity = -1;
        }
    }

    void printInfo() {
        System.out.println("-------------------------------");

        System.out.println("_04_Product name: " + this.name);
        System.out.println("_04_Product price: " + String.format("%.2f Euro", this.price));

        if (this.quantity > 0) {
            System.out.println("Quantity: " + this.quantity);
        }
        else {
            if (this.quantity == -1) {
                System.out.println("Quantity: ERROR");
            }
            else {
                System.out.println("Quantity is zero :|");
            }
        }

        System.out.println("-------------------------------");
    }
}