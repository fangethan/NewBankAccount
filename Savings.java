package com.company;

public class Savings extends BankAccount implements BaseInterestRate{
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    public Savings(String name, String securityNumber, double initDeposit) {
        super(name, securityNumber, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    // 3 digit safety deposit box id
    // 4 digit safety deposit box key
    public void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    // both accounts will use an interface that determines the base interest rate
    // savings accounts will use .25 points less than the base rate
    // checking accounts will use 15% of the base rate

    public void showInfo() {
        System.out.println("Savings account");
        System.out.println("*****************");
        super.showInfo();
        System.out.println("Safety Deposit Box ID: " + safetyDepositBoxID);
        System.out.println("Safety Deposit Box Key: " + safetyDepositBoxKey);
    }

    @Override
    public void setRate(){
        rate = baseInterestRate() - .25;
    }




}
