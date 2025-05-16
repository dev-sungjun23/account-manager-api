package com.example.account_manager_api.dto;

public class AccountResponse {
    private Long id;
    private String owner;
    private int balance;

    public AccountResponse(Long id, String owner, int balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
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
