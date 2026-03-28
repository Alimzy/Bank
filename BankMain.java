package AccountPackage;

import Account.Bank;

import java.util.Scanner;

public class BankMain {
    private static Bank bank;

    static void main() {
        bank = new Bank("Access Bank");
        displayMainMenu();
    }

    private static void displayMainMenu() {
        String mainMenu = """
                Welcome to Access Bank!!!
                1-> Create Account
                2-> Deposit
                3 -> Withdraw
                4 -> Transfer
                5 -> Check Balance
                6 - > Exit
                """;
        char response = input(mainMenu).charAt(0);
        switch (response){
            case '1'-> createAccount();
            case '2' -> depositAmount();
            case '3' -> withdraw();
            case '4'-> transfer();
            case '5' -> checkBalance();
            default -> exit();
        }

    }

    private static void checkBalance() {
        String accountNumber = input("Enter your Account Number: ");
        int pin = Integer.parseInt(input("Enter pin Number: "));
        try{
            int balance = bank.checkAccountBalance(accountNumber, pin);
            print("Balance is: "+ balance);
        }
        catch (Exception e){
            print(e.getMessage());
        }
        finally{
            displayMainMenu();
        }
    }

    private static void transfer() {
        String fromAccount = input("Enter your Account Number: ");
        String toAccount = input("Enter her Account Number: ");
        int pin = Integer.parseInt(input("Enter pin Number: "));
        int amount = Integer.parseInt(input("Enter Amount: "));
        try{
            bank.transfer(fromAccount,pin, toAccount, amount);
            print("Transfer Successful");
            int balance = bank.checkAccountBalance(fromAccount, pin);
            print("Balance is " + balance);
        }
        catch(Exception ex){
            print(ex.getMessage());
        }
        finally {
            displayMainMenu();
        }
    }

    private static void withdraw() {
        String accountNumber = input("Enter Account Number: ");
        int pin = Integer.parseInt(input("Enter pin Number: "));
        int amount = Integer.parseInt(input("Enter Amount: "));
        try{
            bank.withdrawAmount(accountNumber,amount, pin);
            int balance = bank.checkAccountBalance(accountNumber, pin);
            print("Withdraw sucessfull!!!");
            print("New Balance: " + balance);
        }
        catch (Exception e){
            print(e.getMessage());
        }
        finally {
            displayMainMenu();
        }
    }

    private static void depositAmount() {
        String accountNumber = input("Enter Account Number: ");
        int amount = Integer.parseInt(input("Enter Amount: "));
        try {
            bank.depositAmount(accountNumber, amount);
            print("Deposit successful");
        }
        catch (Exception ex){
            print(ex.getMessage());
        }
        finally {
            displayMainMenu();
        }
    }

    private static void createAccount() {

        String name = input("Enter Name: ");
        String phoneNumber = input("Enter Phone Number: ");
        int pin   = Integer.parseInt(input("Enter 4 digit Pin: "));
        int age   = Integer.parseInt(input("Enter your age: "));
        try {
            bank.createAccount(pin, name, phoneNumber,age);
            print("Account created successfully");
        }
        catch(Exception ex){
            print(ex.getMessage());
        }
        finally {
            displayMainMenu();
        }
    }

    private static void exit() {
        print("Good bye from the app");
        System.exit(0);
    }

    private static String input(String message) {
        Scanner input = new Scanner(System.in);
        print(message);
        return  input.nextLine();
    }

    private static void print(String mainMenu) {
        System.out.println(mainMenu);
    }

}