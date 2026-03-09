package com.example.app.model;

import java.util.List;
import java.lang.annotation.AnnotationFormatError;
import java.util.ArrayList;

public class Account {
  private String accountHolderName;
  private String accountNumber;
  private double balance;
  private String password;

  private static String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
  private static String stringRegex = "^[+-]?\\d*(\\.\\d+)?$";

  private List<Transaction> Transactions = new ArrayList<>();

  // Constructor
  public Account(String accountHolderName, String accountNumber, double initializeBalance, String password) {
    if (!isValidPassword(password)) {
      throw new IllegalArgumentException("Invalid password format");
    }
    this.password = password;
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.balance = initializeBalance;
  }

  // Getter
  public String getAccountHolderName() {
    return accountHolderName;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getPassword() {
    return password;
  }

  public double getBalance() {
    return balance;
  }

  // Deposit method
  public void Deposit(String inputAmount, String inputPassword) {

    authentication(inputPassword);

    if (!inputAmount.matches(stringRegex)) {
      throw new IllegalArgumentException("Amount should be number only!");
    }
    double amount = Double.parseDouble(inputAmount);
    if (!(amount > 0)) {
      throw new IllegalArgumentException("Amount should be positive number!");
    }

    this.exercuteDeposit(amount, "Deposit");
  }

  private void exercuteDeposit(double amount, String type) {
    this.balance += amount;
    Transaction t = new Transaction(Transaction.generatId(), this.accountNumber, type, amount);
    this.Transactions.add(t);
  }

  // Withdraw method
  public void Withdraw(String inputAmount, String inputPassword) {

    authentication(inputPassword);
    if (!inputAmount.matches(stringRegex)) {
      throw new IllegalArgumentException("Amount should be number only!");
    }
    double amount = Double.parseDouble(inputAmount);
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount should be positive number!");
    }

    if (amount > this.balance) {
      throw new IllegalArgumentException("Insufficient balance!");
    }

    this.exercuteWithdraw(amount, "Withdraw");
  }

  private void exercuteWithdraw(double amount, String type) {
    this.balance -= amount;
    Transaction t = new Transaction(Transaction.generatId(), this.accountNumber, type, amount);
    this.Transactions.add(t);
  }

  public void Tranfer(String inputAmount, String inputPassword, Account target) {
    authentication(inputPassword);

    if (!inputAmount.matches(stringRegex)) {
      throw new IllegalArgumentException("Amount should be number only!");
    }
    double amount = Double.parseDouble(inputAmount);
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount should be positive number!");
    }

    if (this.balance <= amount) {
      throw new IllegalArgumentException("Insufficient balance!");
    }
    if (this.getAccountNumber().equals(target.getAccountNumber())) {
      throw new IllegalArgumentException("Can not tranfer your owrn account!");
    }

    this.balance -= amount;
    this.exercuteWithdraw(amount, "Transfer out");
    target.exercuteDeposit(amount, "Transfer in");
  }

  public void ShowTransaction() {
    if (Transactions.isEmpty()) {
      throw new IllegalArgumentException("No transaction found!");
    }
    for (Transaction t : Transactions) {
      System.out.println(t);
    }
  }

  // Check balance method
  public void ShowBalance(String inputPassword) {

    authentication(inputPassword);

    System.out.println("Amount: " + getBalance() + "$");

  }

  // accountHolderName setter
  public void SetAccountHolderName(String accountHolderName, String inputPassword) {

    authentication(inputPassword);

    this.accountHolderName = accountHolderName;

  }

  // password setter
  public void ResetPassword(String newPassword, String oldPassword) {

    authentication(oldPassword);

    if (!isValidPassword(newPassword)) {
      throw new IllegalArgumentException("Incorrect password format!");
    }

    this.password = newPassword;

  }

  // Password validation
  boolean isValidPassword(String Password) {

    return Password != null && Password.matches(passwordRegex);

  }

  // Authentication
  private void authentication(String inputPassword) {

    if (!isValidPassword(inputPassword)) {
      throw new IllegalArgumentException("Invalid password!");
    }

    if (!inputPassword.equals(password)) {
      throw new IllegalArgumentException("Incorrect password!");
    }
  }
}
