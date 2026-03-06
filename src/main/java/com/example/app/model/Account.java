package com.example.app.model;

public class Account {
  private String accountHolderName;
  private String accountNumber;
  private double balance;
  private String password;

  private static String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
  private static String stringRegex = "^[+-]?\\d*(\\.\\d+)?$";

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
  public String getAccountHolder() {
    return accountHolderName;
  }

  public String getAccountNumber() {
    return accountNumber;
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

    balance += amount;

  }

  // Withdraw method
  public void Withdraw(String inputAmount, String inputPassword) {

    authentication(inputPassword);
    if (!inputPassword.matches(stringRegex)) {
      throw new IllegalArgumentException("Amount should be number only!");
    }
    double amount = Double.parseDouble(inputAmount);
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount should be positive number!");
    }

    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient balance!");
    }

    balance -= amount;
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
  public void ResetPassword(String Password, String newPassword, String oldPassword) {

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
