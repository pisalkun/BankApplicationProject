package com.example.app;

import java.util.Scanner;

import com.example.app.model.Account;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Account acc1 = new Account("Pisal", "1234567", 1000.0, "129211");
    acc1.Deposit(10000.0);
    acc1.Withdraw(50.0);
    System.out.println("View account");
    System.out.println("Please insert your password");
    String inputPassword = scanner.next();
    acc1.ShowBalance(inputPassword);
    scanner.close();
  }
}
