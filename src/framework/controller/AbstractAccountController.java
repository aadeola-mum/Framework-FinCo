package framework.controller;

import framework.account.AbstractAccount;
import framework.account.Account;
import framework.service.IAccountService;

import java.util.*;

public abstract class AbstractAccountController<T> {
    protected IAccountService accountService;

    public AbstractAccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    public abstract boolean deposit(String name, double amount);
    public abstract boolean withdraw(String name, double amount);
    public abstract double getBalance(String name);
    public abstract void addInterest();
    public abstract List<T> getAllAccounts();
}
