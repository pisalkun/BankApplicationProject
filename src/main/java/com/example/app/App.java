package com.example.app;

import java.util.Scanner;

import com.example.app.model.Account;

public class App {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {

      Account acc = new Account("pisal", "001", 1000, "Password#@1!");
      System.out.println("Deposit section please enter: ");
      System.out.println("Password: ");
      String inputPassword = sc.next();

      System.out.println("Amount: ");
      String amountDeposit = sc.next();

      acc.Deposit(amountDeposit, inputPassword);
      System.out.println("Deposit " + amountDeposit + "$" + " successfully." );

      System.out.println("Withdraw section please enter :");
      System.out.println("Password: ");
      String input = sc.next();

      System.out.println("Amount: ");
      String amountWithDraw = sc.next();

      acc.Withdraw(amountWithDraw, input);
      System.out.println("Withdraw " + amountWithDraw + "$" + " successfully.");

      acc.ShowBalance(inputPassword);
      acc.ShowTransaction();
      sc.close();
    } catch (Exception e) {

      System.out.println("ERROR: " + e.getMessage());

    }
  }
}
