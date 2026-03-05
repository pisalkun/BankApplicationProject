package com.example.app;

import com.example.app.model.Account;

public class App {
  public static void main(String[] args) {
    Account acc1 = new Account("Pisal", "1234567", 1000.0, "129211");
    acc1.Deposit(10000.0);
    acc1.Withdraw(50.0);
  }
}
