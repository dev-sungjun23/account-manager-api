package com.example.account_manager_api.service;

import com.example.account_manager_api.dto.AccountResponse;
import com.example.account_manager_api.dto.AccountUpdateRequest;
import com.example.account_manager_api.exception.AccountNotFoundException;
import com.example.account_manager_api.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService {
    private final List<Account> accounts = new ArrayList<>();

    public Account createAccount(String owner, int initialBalance) {
        Account account = new Account(owner, initialBalance);
        accounts.add(account);
        return account;
    }

    public List<AccountResponse> getAllAccounts() {
        List<AccountResponse> responses = new ArrayList<>();
        for (Account acc : accounts) {
            responses.add(new AccountResponse(acc.getId(), acc.getOwner(), acc.getBalance()));
        }
        return responses;
    }

    public String updateAccount(Long id, AccountUpdateRequest request) {
        for (Account acc : accounts) {
            if(acc.getId().equals(id)){
                acc.setOwner(request.getOwner());
                acc.setBalance(request.getBalance());
                return "계좌 정보가 수정되었습니다.";
            }
        }
        return "해당 ID의 계좌를 찾을 수 없습니다.";
    }

    public String deleteAccount(Long id) {
        return accounts.removeIf(acc -> acc.getId().equals(id))
                ? "계좌가 삭제되었습니다."
                : "해당 ID의 계좌를 찾을 수 없습니다.";
    }

    public AccountResponse getAccountById(Long id) {
        for (Account acc : accounts) {
            if (acc.getId().equals(id)) {
                return new AccountResponse(acc.getId(), acc.getOwner(), acc.getBalance());
            }
        }
        //throw new NoSuchElementException("해당 ID의 계좌를 찾을 수 없습니다.");
        throw new AccountNotFoundException(id);
    }
}
