package com.example.account_manager_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AccountUpdateRequest{

    @Schema(description = "계좌 소유자 이름", example = "유성준")
    @NotBlank(message = "소유자 이름은 필수입니다.")
    private String owner;

    @Schema(description = "초기 잔액", example = "10000")
    @Min(value = 0, message = "초기 잔액은 0원 이상이어야 합니다.")
    private int balance;

    public AccountUpdateRequest() {}

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
