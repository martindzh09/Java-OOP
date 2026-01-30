package _1_ClassesAndObjects;

import java.util.Scanner;

public class _03_Person {
    String firstName;
    String lastName;

    int age;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // creating an object of the class '_03_Person'
        _03_Person personality = new _03_Person();

        // assigning a value (scanned in the console)
        System.out.println("\n" + "What is your first name?");
        personality.firstName = scr.nextLine();

        System.out.println("\n" + "What is your last name?");
        personality.lastName = scr.nextLine();

        System.out.println("\n" + "How old are you?");
        do { // invalid data for age
            personality.age = scr.nextInt();

            if (personality.age < 1) {
                System.out.println("Invalid age!");
            }
        } while (personality.age < 1);

        // count of hyphens each border is consisted of
        int bordersLength = 25 + personality.firstName.length() +
                personality.lastName.length() + String.valueOf(personality.age).length();

        System.out.println(); // single line spacing before

        // upper border
        for (int i = 0; i < bordersLength; i++) {
            System.out.print("-");
        }

        System.out.printf("\n" + "-> You are %s %s; %d-years old.",
                personality.firstName, personality.lastName, personality.age);

        System.out.println(); // single line spacing after

        // bottom border
        for (int i = 0; i < bordersLength; i++) {
            System.out.print("-");
        }
    }
}