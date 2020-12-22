package com.company;

public abstract class BankAccount implements BaseInterestRate {
    private double balance = 0;
    String name;
    String accountNumber;
    String securityNumber;
    double rate;
    static int index = 10000;

    public BankAccount(String name, String securityNumber, double initDeposit) {
        this.name = name;
        this.securityNumber = securityNumber;
        balance = initDeposit;

        index++;
        this.accountNumber = generateAccountNumber();

        setRate();
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    public void deposit(double depositMoney) {
        balance += depositMoney;
        System.out.println("Depositing $" + depositMoney);
        printBalance();
    }

    public void withdraw(double withdrawMoney) {
        balance -= withdrawMoney;
        System.out.println("Withdrawing $" + withdrawMoney);
        printBalance();
    }

    public void transfer(String toWhere, double transferMoney) {
        balance -= transferMoney;
        System.out.println("Transferring $" + transferMoney + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    // showInfo method should reveal relevant account info as well as info specific to the checking or savings account
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Rate: " + rate + "%");
    }

    // 11 digit Account number generated with the following process: 1 or 2 depending on Savings
    // or Checking, last 2 digits of SSN, unique 5 digit number, and random 3 digit number
    // savings account holder are assigned a safety deposit box,
    // identified by a 3 digit number and accessed with a 4 digit code
    public String generateAccountNumber() {
        String setIDNumber = "1234567890";

        String lastTwoOfSecurityNumber = securityNumber.substring(securityNumber.length() - 2, securityNumber.length());
        int uniqueID = index;
        int random3Digit = 0;

        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.random() * setIDNumber.length());
            random3Digit = random3Digit * 10 + random;
        }

        return lastTwoOfSecurityNumber + uniqueID + random3Digit;

    }

    public abstract void setRate();

}
