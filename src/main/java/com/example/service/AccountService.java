package com.example.service;

import com.example.mapper.AccountMapper;
import com.example.pojo.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    private final AccountMapper accountMapper;

    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    public Account getAccount() {
        return accountMapper.getAccount();
    }

    public List<Account> queryAllAccounts(){
        return accountMapper.queryAllAccounts();
    }

    public int addAccount(Account account){
        int res = accountMapper.addAccount(account);
        if(res == 1){
            throw new RuntimeException("addAccount error");
        }
        return res;
    }

    public Account queryAccountId(String accountId){
        return accountMapper.queryAccountId(accountId);
    }

    public int updateAccount(Account account){
        return accountMapper.updateAccount(account);
    }

}
