package com.example.app.service;

import com.example.app.model.Account;

public class BankService {
  private Account account;

  public BankService(Account account) {
    this.account = account;
  }

  public void Deposit(String amount, String password) {
    account.Deposit(amount, password);
  }

  public void Withdraw(String amount, String password) {
    account.Withdraw(amount, password);
  }

  public void ShowBalance(String passwrod) {
    account.ShowBalance(passwrod);
  }

  public void ChangePassword(String password, String newPassword) {
    account.ResetPassword(newPassword, password);
  }

  public void ChangeUsername(String password, String Username) {
    account.SetAccountHolderName(Username, password);
  }

  public void ViewTransaction() {
    account.ShowTransaction();
  }
}
