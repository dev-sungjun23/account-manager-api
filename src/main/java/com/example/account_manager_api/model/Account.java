package com.example.account_manager_api.model;

public class Account {
    private static long nextId = 1;

    private Long id;
    private String owner;
    private int balance;

    public Account(String owner, int balance) {
        this.id = nextId++;
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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
