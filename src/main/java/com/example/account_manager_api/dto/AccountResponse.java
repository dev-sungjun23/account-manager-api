package com.example.account_manager_api.dto;

import com.example.account_manager_api.model.Account;

public class AccountResponse {
    private Long id;
    private String owner;
    private int balance;

    public AccountResponse(Account account) {
        this.id = account.getId();
        this.owner = account.getOwner();
        this.balance = account.getBalance();
    }


    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }
}
