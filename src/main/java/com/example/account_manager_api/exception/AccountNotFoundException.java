package com.example.account_manager_api.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(Long id) {
        super("ID가 " + id + "인 계좌를 찾을 수 없습니다.");
    }
}
