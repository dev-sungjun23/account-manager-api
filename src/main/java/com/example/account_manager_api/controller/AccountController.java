package com.example.account_manager_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @PostMapping
    public String createAccount(@RequestParam String owner, @RequestParam int initialBalance) {
        //실제 로직은 나중에 서비스에서 처리하도록 분리할 예정
        return owner + "님의 계좌가 생성되었습니다. 초기 잔액 : " + initialBalance + "원";
    }
}
