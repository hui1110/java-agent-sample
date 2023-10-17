package com.example.controller;

import com.example.pojo.Account;
import com.example.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getaccount")
    public Account getAccount() {
        return accountService.getAccount();
    }

    @RequestMapping("/queryAllAccounts")
    public List<Account> queryAllAccounts(){
        return accountService.queryAllAccounts();
    }

    @RequestMapping("/addAccount")
    public int addAccount(){
        Account account = new Account();
        account.setAccountId("1001");
        account.setAccountName("test");
        account.setBalance(BigDecimal.valueOf(100.55));
        return accountService.addAccount(account);
    }

    @RequestMapping("/queryAccountId")
    public Account queryAccountId(){
        String accountId = "1";
        return accountService.queryAccountId(accountId);
    }

    @RequestMapping("/updateAccount")
    public int updateAccount(){
        Account account = new Account();
        account.setAccountId("1");
        account.setAccountName("huihui");
        account.setBalance(BigDecimal.valueOf(100.55));
        return accountService.updateAccount(account);
    }

}
