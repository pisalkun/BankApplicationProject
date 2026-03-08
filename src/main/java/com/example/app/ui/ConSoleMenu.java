package com.example.app.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.app.model.Account;
import com.example.app.service.BankService;

public class ConSoleMenu {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<BankService> bankServices = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();
    int choice;
    BankService activeService = null;
    System.out.println("----------Welcome to LazySal Banking System----------");
    do {
      System.out.println("Please Chose the choice below:");
      System.out.println("1.Sign up: ");
      System.out.println("2.Login: ");
      System.out.println("3.Deposit: ");
      System.out.println("4.Withdraw: ");
      System.out.println("5.Tranfer: ");
      System.out.println("6.Show account balance: ");
      System.out.println("7.Show account information: ");
      System.out.println("Choice: ");
      choice = sc.nextInt();
      sc.nextLine();
      try {
        switch (choice) {
          case 1:
            System.out.println("Username: ");
            String username = sc.next();
            System.out.println("Account Number: ");
            String accountNumber = sc.next();
            System.out.println("Password: ");
            String password = sc.next();
            System.out.println("First Deposit: ");
            double amount = sc.nextDouble();
            Account newAccount = new Account(username, accountNumber, amount, password);
            accounts.add(newAccount);
            System.out.println("Account create successfully");
            break;
          case 2:
            System.out.println("Username: ");
            String inputUsername = sc.next();
            System.out.println("Password");
            String inputPassword = sc.next();
            Account foundAccount = null;
            for (Account acc : accounts) {
              if (acc.getAccountHolderName().equals(inputUsername) && acc.getPassword().equals(inputPassword)) {
                foundAccount = acc;
                break;
              }
            }
            if (foundAccount != null) {
              activeService = new BankService(foundAccount);
              System.out.println("Login successfully. Welcome go our bank.");
            } else {
              System.out.println("ERROR: no accounts found to match your information!. Please check your information again!");
              activeService = null;
            }
            break;
          default:
            break;
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    } while (choice != 8);
    sc.close();
  }
}
