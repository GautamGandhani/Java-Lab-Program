/*
Develop a Java program to create a class Bank that maintains two kinds of account
for its customers, one called savings account and the other current account. The
savings account provides compound interest and withdrawal facilities but no cheque
book facility. The current account provides cheque book facility but no interest.
Current account holders should also maintain a minimum balance and if the balance
falls below this level, a service charge is imposed.
Create a class Account that stores customer name, account number and type of
account. From this derive the classes Cur-acct and Sav-acct to make them more
specific to their requirements. Include the necessary methods in order to achieve the
following tasks:
a) Accept deposit from customer and update the balance.
b) Display the balance.
c) Compute and deposit interest
d) Permit withdrawal and update the balance
Check for the minimum balance, impose penalty if necessary and update the balance.
*/


import java.util.Scanner;

class Account {
    String customerName;
    long accountNumber;
    String accountType;
    double balance;

   
    public Account(String customerName, long accountNumber, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of " + amount + " successful. Updated balance: " + balance);
    }

    
    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

class CurrAcct extends Account {
    double minBalance;
    double serviceCharge;

    
    public CurrAcct(String customerName, long accountNumber) {
        super(customerName, accountNumber, "Current");
        this.minBalance = 1000.0; // Set minimum balance
        this.serviceCharge = 50.0; // Set service charge
    }

   
    private void checkMinBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Minimum balance not maintained. Service charge imposed. Updated balance: " + balance);
        }
    }

    
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        } else {
            balance -= amount;
            checkMinBalance();
            System.out.println("Withdrawal of " + amount + " successful. Updated balance: " + balance);
        }
    }
}

class SavAcct extends Account {
    double interestRate;

 
    public SavAcct(String customerName, long accountNumber) {
        super(customerName, accountNumber, "Savings");
        this.interestRate = 0.05; 
    }

   
    public void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest computed and deposited. Updated balance: " + balance);
    }

    
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. Updated balance: " + balance);
        }
    }
}

public class ProgramBank {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Creating a savings account
        SavAcct savingsAccount = new SavAcct("John Doe", 123456789);

        // Creating a current account
        CurrAcct currentAccount = new CurrAcct("Jane Doe", 987654321);

        // Deposit and display balance for savings account
        savingsAccount.deposit(1000);
        savingsAccount.displayBalance();

        // Withdraw from savings account
        savingsAccount.withdraw(500);
        savingsAccount.displayBalance();

        // Compute and deposit interest for savings account
        savingsAccount.computeAndDepositInterest();
        savingsAccount.displayBalance();

        // Deposit and display balance for current account
        currentAccount.deposit(2000);
        currentAccount.displayBalance();

        // Withdraw from current account
        currentAccount.withdraw(1500);
        currentAccount.displayBalance();

        // Withdraw more than current balance (insufficient funds)
        currentAccount.withdraw(3000);

        scanner.close();
    }
}

