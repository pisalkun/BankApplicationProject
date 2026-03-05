package com.example.app;

import java.util.Scanner;

import com.example.app.model.Account;

public class App {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {

      Account acc = new Account("pisal", "001", 1000, "Password#@1!");

      System.out.println("Password: ");
      String inputPassword = sc.next();

      System.out.println("Amount: ");
      String amount = sc.next();

      acc.Deposit(amount, inputPassword);
      System.out.println("Deposit successfully!");

      acc.ShowBalance(inputPassword);

      sc.close();

    } catch (Exception e) {

      System.out.println("ERROR: " + e.getMessage());

    }
  }
}
