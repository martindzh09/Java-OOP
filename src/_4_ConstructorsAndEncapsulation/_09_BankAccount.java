package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;

class _09_BankAccount {
    private final String accountUser;
    private final String iban;
    private double balance;

    private static final String pinCode = "1234";

    _09_BankAccount(String accountUser, String iban, double balance) {
        this.accountUser = accountUser;
        this.iban = iban;
        this.balance = balance;
    }

    static String checkPinCode() {
        Scanner scrPin = new Scanner(System.in);

        System.out.println("\n" + "ENTER PIN: ");
        String pin;
        int countInvalidTries = 0;
        boolean validPin;

        do {
            pin = scrPin.next();

            if (!pin.equals(pinCode)) {
                System.out.println("INVALID PIN!");
                validPin = false;
                countInvalidTries++;

                if (countInvalidTries != 2) {
                    System.out.println("\n" + "ENTER PIN: ");
                }
            }
            else {
                validPin = true;
            }
        } while (countInvalidTries < 2 && !validPin);

        if (validPin) {
            return pin;
        }
        else {
            return null;
        }
    }

    void deposit(String pinCode) {
        Scanner scrDeposit = new Scanner(System.in);

        if (pinCode != null) {
            System.out.println("\n" + "-> AMOUNT TO ADD: ");
            double amount;

            do {
                amount = scrDeposit.nextDouble();

                if (amount <= 0.00) {
                    System.out.println("Invalid data!");
                }
            } while (amount <= 0.00);

            balance += amount;
            System.out.println("/ + " + String.format("%.2f", amount) + " euro /");
        }
        else {
            System.out.println("#######");
        }
    }

    void withdraw(String pinCode) {
        Scanner scrWithdraw = new Scanner(System.in);

        if (pinCode != null) {
            System.out.println("\n" + "-> AMOUNT TO WITHDRAW: ");
            double amount;

            do {
                amount = scrWithdraw.nextDouble();

                if (amount <= 0.00) {
                    System.out.println("Invalid data!");
                }
            } while (amount <= 0.00);

            if (amount <= balance) {
                balance -= amount;
                System.out.println("/ - " + String.format("%.2f", amount) + " euro /");
            }
            else {
                System.out.println("\n" + "ERROR! Negative balance!");
            }
        } else {
            System.out.println("#######");
        }
    }

    void printData(String pinCode) {
        System.out.println("\n| " + accountUser + " | " + iban + " |");

        if (pinCode != null) {
            System.out.println("[ " + String.format("%.2f euro ]%n", balance));
        }
        else {
            System.out.println("[ XXXX ]");
        }
    }
}