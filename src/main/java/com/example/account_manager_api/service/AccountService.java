package com.example.account_manager_api.service;

import com.example.account_manager_api.dto.AccountResponse;
import com.example.account_manager_api.dto.AccountUpdateRequest;
import com.example.account_manager_api.model.Account;
import com.example.account_manager_api.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    //수동생성 제거 , AccountRepoisotry를 주입 받아서 사용
    //private final List<Account> accounts = new ArrayList<>();
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String owner, int initialBalance) {
        Account account = new Account(owner, initialBalance);
        accountRepository.save(account);
        return account;
    }

    public AccountResponse getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID가" + id + "인 계좌를 찾을 수 없습니다."));
        return new AccountResponse(account);
    }

    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountResponse::new)
                .collect(Collectors.toList());

    }

    public String updateAccount(Long id, AccountUpdateRequest request) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID가" + id + "인 계좌를 찾을 수 없습니다."));
        account.setOwner(request.getOwner());
        account.setBalance(request.getBalance());
        accountRepository.save(account); //변경 감지는 @Transactional로도 가능
        return "계좌 정보가 수정되었습니다.";
    }

    public String deleteAccount(Long id) {
        if(!accountRepository.existsById(id)) {
            return "해당 ID의 계좌를 찾을 수 없습니다.";
        }
        accountRepository.deleteById(id);
        return "계좌가 삭제되었습니다.";
    }

}
