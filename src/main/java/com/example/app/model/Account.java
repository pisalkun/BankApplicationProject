package com.example.app.model;

public class Account {
  private String AccountHolder;
  private String AccountNumber;
  private double Balance;
  private String Password;

  private static String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

  public Account(String AccountHolder, String AccountNumber, double initializeBalance, String Password) {
    if (!isValidPassword(Password)) {
      System.out.println("ERROR: Incorrect password please change");
      return;
    }
    this.Password = Password;
    this.AccountHolder = AccountHolder;
    this.AccountNumber = AccountNumber;
    this.Balance = initializeBalance;
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
    if (!isValidPassword(Password)) {
      System.out.println("ERROR: User dosn't exist!");
      return;
    }
    if (!(amount > 0)) {
      System.out.println("Desposited fail please  insert correct value!");
    }

    Balance += amount;
    System.out.println("Successfully deposited: " + amount);
  }

  public void Withdraw(double amount) {
    if (!isValidPassword(Password)) {
      System.out.println("ERROR: User doesn't exist!");
      return;
    }
    if (!(amount > 0 && amount <= Balance)) {
      System.out.println("Withdraw fail please insert correct value!");
      return;
    }

    Balance -= amount;
    System.out.println("Successfully withdraw: " + amount);
  }

  public void ShowBalance(String inputPassword) {
    if (!isValidPassword(Password)) {
      System.out.println("ERROR: User doesn't exist!");
      return;
    }
    if (!Password.equals(inputPassword)) {
      System.out.println("Incorrect password can not view balance.");
      return;
    }

    System.out.println("Amount: " + getBalance());
  }

  public void ResetPassword(String Password, String newPassword) {
    if (!isValidPassword(newPassword)) {
      System.out.println("ERROR: Invalide password please change!");
      return;
    }
    this.Password = newPassword;
  }

  // VALIDATION FOR PROTECTION
  boolean isValidPassword(String Password) {
    if (Password == null || Password.isEmpty()) {
      return false;
    }
    if (!Password.matches(passwordRegex)) {
      return false;
    }
    return true;
  }
}
