import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Base class representing a generic bank account
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor to initialize a new bank account
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " successfully.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " successfully.");
        } else {
            System.out.println("Invalid amount or insufficient balance. Withdrawal failed.");
        }
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    // Getters and Setters for encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Class to manage the bank system operations
class BankManagementSystem {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Method to open a new account
    public void openAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
        } else {
            BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully.");
        }
    }

    // Method to deposit money into an account
    public void depositMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            accounts.get(accountNumber).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money from an account
    public void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            accounts.get(accountNumber).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to display account details
    public void displayAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).displayAccount();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to display the menu and handle user inputs
    public void menu() {
        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("a) Open account");
            System.out.println("b) Deposit Money");
            System.out.println("c) Withdraw Money");
            System.out.println("d) Display Account");
            System.out.println("e) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "a":
                    openAccount();
                    break;
                case "b":
                    depositMoney();
                    break;
                case "c":
                    withdrawMoney();
                    break;
                case "d":
                    displayAccount();
                    break;
                case "e":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

// Main class to run the program
public class main {
    public static void main(String[] args) {
        BankManagementSystem bms = new BankManagementSystem();
        bms.menu();
    }
}