package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;

class _09_1_BankAccountOperations {
    public static void main(String[] args) {
        Scanner scrStr = new Scanner(System.in);
        Scanner scrNum = new Scanner(System.in);

        System.out.println("\n" + "-- Adding a new bank account --");

        System.out.println("\n" + "Name of the owner of the account: ");
        String name = scrStr.nextLine();

        System.out.println("\n" + "IBAN: ");
        String iban;

        do {
            iban = scrStr.nextLine();

            if (iban.length() > 34) {
                System.out.println("\n" + "Invalid IBAN format! (up to 34 characters)");
            }
        } while (iban.length() > 34);

        System.out.println("\n" + "DEFAULT BALANCE: 0.00 euro");

        // creating a new bank account with a name and an IBAN
        _09_BankAccount bankAccount = new _09_BankAccount(name, iban, 0.00);

        String option;
        do {
            System.out.println("\n" + "------------------------------------------------------");
            System.out.println("| 1. DEPOSIT / 2. WITHDRAW / 3. PRINT DATA | 4. EXIT |");
            System.out.println("------------------------------------------------------");

            System.out.println("\n" + "Choose an option... ");
            option = scrStr.nextLine();

            switch (option) {
                case "1":
                    // depositing only if pin code is validated successfully
                    bankAccount.deposit(_09_BankAccount.checkPinCode());
                    break;

                case "2":
                    // withdrawing is a critical operation - only if pin code is validated successfully
                    bankAccount.withdraw(_09_BankAccount.checkPinCode());
                    break;

                case "3":
                    // part of the data is printed - balance will be hidden unless password is true
                    bankAccount.printData(_09_BankAccount.checkPinCode());
                    break;

                default:
                    if (!option.equals("4")) {
                        System.out.println("\n" + "Invalid option!");
                    }
            }
        } while (!option.equals("4"));

        System.out.println("\n" + "Exiting the program... ");

        scrStr.close();
        scrNum.close();
    }
}