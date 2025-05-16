package com.example.account_manager_api.controller;

import com.example.account_manager_api.dto.AccountCreateRequest;
import com.example.account_manager_api.dto.AccountResponse;
import com.example.account_manager_api.dto.AccountUpdateRequest;
import com.example.account_manager_api.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    /*
    @PostMapping
    public String createAccount(@RequestParam String owner, @RequestParam int initialBalance) {
        //실제 로직은 나중에 서비스에서 처리하도록 분리할 예정
        return accountService.createAccount(owner, initialBalance);
    }
    */
    //@valid 붙임

    // 각 메서드에 @Operation(summary = "...", description = "...") 추가해줘
    @Operation(summary = "계좌 생성", description = "소유자 이름과 초기 잔액을 받아 계좌를 생성합니다.")
    @PostMapping
    public String createAccount(@RequestBody @Valid AccountCreateRequest request) {
        return accountService.createAccount(request.getOwner(), request.getInitialBalance());
    }

    @GetMapping
    public List<AccountResponse> getAllAccounts() {

        return accountService.getAllAccounts();
    }

    /*
    @PutMapping("/{id}")
    public String updateAccount(@PathVariable Long id, @RequestBody AccountUpdateRequest request) {
        return accountService.updateAccount(id, request);
    }
    */
    //updateAccount 메서드도 @valid 붙임
    @PutMapping("/{id}")
    public String updateAccount(@PathVariable Long id, @RequestBody @Valid AccountUpdateRequest request) {
        return accountService.updateAccount(id, request);
    }
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }

    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

}
