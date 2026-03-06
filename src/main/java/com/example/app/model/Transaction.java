package com.example.app.model;

import java.time.LocalDateTime;

public class Transaction {
  private String id;
  private String accountNumber;
  private String type;
  private double amount;
  private LocalDateTime date;

  public Transaction(String id, String accountNumber, String type, double amount) {
    this.id = id;
    this.accountNumber = accountNumber;
    this.type = type;
    this.amount = amount;
    this.date = LocalDateTime.now();
  }

  public static String generatId() {
    return "TZB" + System.currentTimeMillis();
  }

  // Show Transaction Histroy
  @Override
  public String toString() {
    return id + " | " + accountNumber + " | " + type + " | " + amount + "$" + " | " + date;
  }
}
