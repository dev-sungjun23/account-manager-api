package com.example.account_manager_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String owner;
   private int balance;

   protected Account() {} //JPA 기본 생성자

    public Account(String owner, int balance) {
       this.owner = owner;
       this.balance = balance;
    }

    //Getter & Setter 생략 가능 (필요한 만큼 작성)
    public Long getId() {
       return id;
    }

    public String getOwner() {
       return owner;
    }

    public void setOwner(String owner) {
       this.owner = owner;
    }

    public int getBalance() {
       return balance;
    }

    public void setBalance(int balance) {
       this.balance = balance;
    }
}
