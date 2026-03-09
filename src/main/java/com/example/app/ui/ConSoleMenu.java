package com.example.app.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.app.model.Account;
import com.example.app.service.BankService;

public class ConSoleMenu {
  ArrayList<Account> accountList = new ArrayList<>();
  BankService activeService = null;

  public static void main(String[] args) {

  }

  public void PrintMenu() {
    System.out.println("----------welcome to our bank services----------");
    System.out.println("Please chose one of this choice");
    System.out.println("1.SignUp: ");
    System.out.println("2.LogIn: ");
    System.out.println("3.logout: ");
    System.out.println("4.Deposit: ");
    System.out.println("5.Withdraw: ");
    System.out.println("6.Tranfer: ");
    System.out.println("4.ShowBalance: ");
  }

  public void signUp(Scanner sc) {
    System.out.println("Username: ");
    String name = sc.next();
    System.out.println("Account Number: ");
    String accountNumber = sc.next();
    System.out.println("Password: ");
    String password = sc.next();
    System.out.println("First Deposit");
    double amount = sc.nextDouble();
    Account account = new Account(name, accountNumber, amount, password);
    accountList.add(account);
    System.out.println("Account sign up succesfully!");
  }

  public void logIn(Scanner sc) {
    System.out.println("Username: ");
    String name = sc.next();
    System.out.println("Password: ");
    String password = sc.next();
    Account accountFound = null;

    for (Account account : accountList) {
      if (account.getAccountHolderName().equals(name) && account.getPassword().equals(password)) {
        accountFound = account;
        break;
      }
    }

    if (accountFound != null) {
      activeService = new BankService(accountFound);
      System.out.println("Login succesfully.");
    } else {
      activeService = null;
      throw new IllegalArgumentException("ERROR:No account found to match this information!");
    }
  }

  public void logout() {
    if (activeService == null) {
      throw new IllegalArgumentException("ERROR: No account is login right now!");
    }
    activeService = null;
    System.out.println("Logout succesfully.");
  }

  public void Deposit(Scanner sc) {
    if (activeService == null) {
      throw new IllegalArgumentException("Access Denied: Please login first!");
    }
    System.out.println("Enter the password: ");
    String password = sc.next();
    System.out.println("Enter amount to deposit: ");
    String amount = sc.next();
    activeService.Deposit(amount, password);
    System.out.println("Deposit " + amount + " succesfully.");
  }

  public void Withdraw(Scanner sc) {
    if (activeService == null) {
      throw new IllegalArgumentException("Access Denied: Please login first!");
    }
    System.out.println("Password: ");
    String password = sc.next();
    System.out.println("Amount ");
    String amount = sc.next();
    activeService.Withdraw(amount, password);
    System.out.println("Withdraw " + amount + " succesfully.");
  }

  public void Transfer(Scanner sc) {
    if (activeService == null) {
      throw new IllegalArgumentException("Access Denied: Please login first!");
    }

  }
}
