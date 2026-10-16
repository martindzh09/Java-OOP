package _4_ConstructorsAndEncapsulation;

class _06_Task {
    private final int id;
    String taskTitle;
    private final String description;
    private final int priority;
    private boolean finished;

    _06_Task(int id, String taskTitle, String description, int priority) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.description = description;
        this.priority = priority;
        this.finished = false; // assigned a default value
    }

    int getId() {
        return this.id;
    }

    // inverted stands for the opposite
    boolean getFinishedInverted() {
        return !this.finished;
    }
    void setFinished() {
        this.finished = true;
    }

    void printInfo() {
        System.out.println("\n" + "| #" + this.id + " " + this.taskTitle + " |");
        System.out.println("Description: " + this.description);
        System.out.println("Priority: " + this.priority);

        if (this.finished) {
            System.out.println("Status: FINISHED :)");
        }
        else {
            System.out.println("Status: UNFINISHED :(");
        }
    }
}