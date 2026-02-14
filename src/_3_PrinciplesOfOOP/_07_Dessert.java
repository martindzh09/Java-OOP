package _3_PrinciplesOfOOP;

class _07_Dessert {
    private final int id; // field 1
    String name; // field 2
    double price; // field 3
    private int stock; // field 4
    private int sold; // field 5
    boolean onSale; // field 6

    // Constructor of class
    _07_Dessert(int id, String name, double price, int stock, int sold, boolean onSale) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
        this.onSale = onSale;
    }

    // getter 1
    int getId() {
        return this.id;
    }

    // getter 2
    String getName() {
        return this.name;
    }

    // getter 3
    double getPrice() {
        return this.price;
    }

    // getter 4
    int getStock() {
        return this.stock;
    }

    // getter 5
    int getSold() {
        return this.sold;
    }

    // getter 6
    boolean getOnSale() {
        return this.onSale;
    }

    // setter 3 (for field 3)
    void setPrice(double price) {
        this.price = price;
    }

    // setter 4 (for field 4)
    void setStock(int stock) {
        this.stock = stock;
    }

    // setter 5 (for field 5)
    void setSold(int sold) {
        this.sold = sold;
    }

    // setter 6 (for field 6)
    void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    // A method printing all dessert's data
    void allDetails() {
        System.out.println("\n" + "________________________");

        System.out.println("Dessert: '" + this.name + "'");
        System.out.printf("Price: %.2f euro%n", this.price);
        System.out.println("Current stock: " + this.stock);
        System.out.println("Sold desserts: " + this.sold);

        if (onSale) {
            System.out.println("On Sale: YES (10% off)");
        }
        else {
            System.out.println("On Sale: NO :(");
        }
    }
}