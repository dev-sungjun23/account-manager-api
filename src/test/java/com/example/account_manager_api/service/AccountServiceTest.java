package com.example.account_manager_api.service;

import com.example.account_manager_api.dto.AccountResponse;
import com.example.account_manager_api.dto.AccountUpdateRequest;
import com.example.account_manager_api.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    private AccountService accountService;

    @BeforeEach
    void setUp(){
        accountService = new AccountService();
    }

    @Test
    void 계좌_생성_성공() {
        //given
        String owner = "유성준";
        int initialBalance = 10000;

        //when
        Account account = accountService.createAccount(owner, initialBalance);

        //then
        assertNotNull(account);
        assertEquals(owner, account.getOwner());
        assertEquals(initialBalance, account.getBalance());
        assertTrue(account.getId() > 0);
    }

    @Test
    void 계좌_조회_성공() {
        //given
        Account created = accountService.createAccount("유성준", 5000);
        long id = created.getId();

        //when
        AccountResponse found = accountService.getAccountById(id);

        //then
        assertNotNull(found);
        assertEquals("유성준", found.getOwner());
        assertEquals(50000, found.getBalance());
        assertEquals(id, found.getId());
    }

    @Test
    void 존재하지_않는_계좌_조회시_예외() {
        long invalidId = 999L;

        assertThrows(NoSuchElementException.class, () -> {
            accountService.getAccountById(invalidId);
        });
    }

    @Test
    void 계좌_삭제_성공() {
        //given
        Account created = accountService.createAccount("유성준", 1000);
        long id = created.getId();

        //when
        accountService.deleteAccount(id);

        //then
        assertThrows(NoSuchElementException.class, () -> {
            accountService.getAccountById(id);
        });
    }

    @Test
    void 존재하지_않는_계좌_삭제시_예외() {
        //given
        long invalidId = 999L;

        //then
        assertThrows(NoSuchElementException.class, () -> {
            accountService.deleteAccount(invalidId);
        });
    }

    @Test
    void 계좌_수정_성공() {
        //given
        Account created = accountService.createAccount("유성준", 5000);
        long id = created.getId();

        AccountUpdateRequest request = new AccountUpdateRequest();
        request.setOwner("김철수");
        request.setBalance(8000);

        //when
        String result = accountService.updateAccount(id, request);

        //then
        assertEquals("계좌 정보가 수정되었습니다.", result);
        AccountResponse updated = accountService.getAccountById(id); //검증용

        assertEquals("김철수", updated.getOwner());
        assertEquals(5000, updated.getBalance()); //잔액은 그대로
    }

    @Test
    void 존재하지_않는_계좌_수정시_예외() {
        long invalidId = 999L;
        AccountUpdateRequest request = new AccountUpdateRequest();
        request.setOwner("누구냐");
        request.setBalance(1000);

        String result = accountService.updateAccount(invalidId, request);

        assertEquals("해당 ID의 계좌를 찾을 수 없습니다.", result);
    }
}
