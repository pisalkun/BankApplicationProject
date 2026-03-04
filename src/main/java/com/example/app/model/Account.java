package com.example.app.model;

public class Account {
  private String AccountHolder;
  private String AccountNumber;
  private double Balance;
  private String Password;

  public Account(String AccountHolder, String AccountNumber, double initializeBalance, String Password) {
    this.AccountHolder = AccountHolder;
    this.AccountNumber = AccountNumber;
    this.Balance = initializeBalance;
    this.Password = Password;
  }

  // GETTER FOR VIEW {data}
  public String getAccountHolder() {
    return AccountHolder;
  }

  public String getAccountNumber() {
    return AccountNumber;
  }

  public double getBalance() {
    return Balance;
  }

  // METHOD FOR MODIFY VALUE {data}
  public void Deposit(double amount) {
    if (!(amount > 0)) {
      System.out.println("Desposited fail please  insert correct value!");
    }
    Balance += amount;
    System.out.println("Successfully deposited: " + amount);
  }

  public void Withdraw(double amount) {
    if (!(amount > 0 && amount <= Balance)) {
      System.out.println("Withdraw fail please insert correct value!");
      return;
    }
    Balance -= amount;
    System.out.println("Successfully withdraw: " + amount);
  }

  public void ShowBalance(String inputPassword) {
    if (!Password.equals(inputPassword)) {
      System.out.println("Incorrect password can not view balance.");
      return;
    }
    System.out.println("Amount: " + getBalance());
  }
}
