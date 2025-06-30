import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with balance: $" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        String record = "Deposited: ₹" + amount + " | New balance: ₹" + balance;
        transactionHistory.add(record);
        System.out.println(record);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: ₹" + balance);
            return;
        }
        balance -= amount;
        String record = "Withdrew: ₹" + amount + " | New balance: ₹" + balance;
        transactionHistory.add(record);
        System.out.println(record);
    }

    public void printStatement() {
        System.out.println("\nAccount Statement for " + accountHolder + " (Acc#: " + accountNumber + ")");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("Final balance: ₹" + balance);
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Account account = new Account("220834", "Charan", 500.0);

        account.deposit(200.0);
        account.withdraw(100.0);
        account.withdraw(700.0); // This should show insufficient funds
        account.deposit(50.0);

        account.printStatement();
    }
}
