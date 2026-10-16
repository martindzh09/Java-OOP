package _4_ConstructorsAndEncapsulation;

public class _10_Package {
    private final int num;
    String recipientName;
    String city;
    double weight;
    private String status;

    // static field used for assigning a unique number of each new package added
    static int counter = 10;

    public _10_Package(String nameRecipient, String city, double weight) {
        this.num = counter;
        counter++;

        this.recipientName = nameRecipient;
        this.city = city;
        this.weight = weight;

        // value is set by default after saving package's data
        this.status = "Pending";
    }

    public int getNum() {
        return num;
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printInfo() {
        System.out.printf("%n| #%d --> %s | %s | %.2f kg / Status: %s |%n", num, recipientName, city, weight, status);
    }
}