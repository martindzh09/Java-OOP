package _4_ConstructorsAndEncapsulation;

class _02_Coffee {
    String coffeeName;
    String size;
    double price;

    /* * Program's logic (in main class) does not require necessarily accessing this
        private field, no getter or setters are made */
    private final int orderNum;

    _02_Coffee(String coffeeName, String size, double price, int orderNum) {
        this.coffeeName = coffeeName;
        this.size = size;
        this.price = price;
        this.orderNum = orderNum;
    }

    void printInfo() {
        // conditional statements used to determine size of coffee by user input
        if (this.size.startsWith("s") || this.size.startsWith("S")) {
            this.size = "small";
        }
        else if (this.size.startsWith("m") || this.size.startsWith("M")) {
            this.size = "medium";
        }
        else if (this.size.startsWith("l") || this.size.startsWith("L")) {
            this.size = "large";
        }

        System.out.println("\n" + "________________ |№" + (this.orderNum - 1) + "| ________________");
        System.out.println(coffeeName + " | " + size + " | " + String.format("%.2f Euro", price));
    }
}