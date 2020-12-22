package com.company;

public class Checking extends BankAccount implements BaseInterestRate{
    private String name;
    private String securityNumber;
    private int debitCard;
    private int pin;


    public Checking(String name, String securityNumber, double intiDeposit) {
        super(name, securityNumber, intiDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    // checking account holders are assigned a debit card with a 12 digit number and 4 digit PIN
    public void setDebitCard() {
        debitCard = (int) (Math.random() * Math.pow(10,12));
        pin = (int) (Math.random() * Math.pow(10,4));
    }

    @Override
    public void setRate(){
        rate = baseInterestRate() * .15;
    }

    public void showInfo() {
        System.out.println("Checking account");
        System.out.println("*****************");
        super.showInfo();
        System.out.println("Debit card: " + debitCard);
        System.out.println("Pin: " + pin);
    }




}
