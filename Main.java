package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Checking checking = new Checking("Ethan","12345",23);
//        Savings savings = new Savings("Hello","44456",80);
//
//        checking.showInfo();
//        System.out.println();
//        savings.showInfo();
//
////        savings.deposit(3000);
////        savings.withdraw(1000);
////        savings.transfer("Jeff", 250);
//
//        savings.compound();

        List<BankAccount> accounts = new LinkedList<BankAccount>();


        String file = "/Users/ethanfang/Desktop/NewBankAccounts.csv";

        List<String[]> newAccountHolder = com.company.utilities.csv.read(file);
        for (String[] accountHolder: newAccountHolder) {
            System.out.println("New Account");
            String name = accountHolder[0];
            String securityNumber = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")) {
                System.out.println("Opening a savings account");
                accounts.add(new Savings(name, securityNumber, initDeposit));
            } else if (accountType.equals("Checking")) {
                System.out.println("Opening a checking account");
                accounts.add(new Checking(name, securityNumber, initDeposit));
            } else {
                System.out.println("Error reading account type");
            }
        }

        for (BankAccount acc: accounts) {
            System.out.println("\n*************");
            acc.showInfo();
        }
    }
}
