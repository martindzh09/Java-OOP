package _4_ConstructorsAndEncapsulation;

class _03_Member {
    private final int id;
    String name;
    private final int age;
    private final double monthlyFee;
    private boolean subscription;

    _03_Member(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

        // if a little child is a member of the gym
        if (age >= 1 && age <= 7) {
            this.monthlyFee = 0.00;
        }
        // if an older child is a member of the gym
        else if (age >= 8 && age <= 14) {
            this.monthlyFee = 2.00;
        }
        // if a teenager or adult is a member of the gym
        else if (age >= 15 && age <= 19) {
            this.monthlyFee = 5.00;
        }
        // anybody older than a 19-years old adult
        else {
            this.monthlyFee = 10.00;
        }
    }

    int getId() {
        return id;
    }

    void activate() {
        this.subscription = true;
    }

    void deactivate() {
        this.subscription = false;
    }

    void printInfo() {
        System.out.println("\n" + "ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Monthly fee: " + String.format("%.2f Euro", this.monthlyFee));

        if (this.subscription) {
            System.out.println("Subscription status: ACTIVE");
        }
        else {
            System.out.println("Subscription status: INACTIVE (action needed)");
        }
    }
}