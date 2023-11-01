package com.example.mapper;

import com.example.pojo.Account;
import com.example.pojo.AccountTransaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    Account getAccount();

    List<Account> queryAllAccounts();

    int addAccount(Account account);

    int updateAccount(Account account);

    Account queryAccountId(String accountId);

    List<AccountTransaction> queryAccountTransaction(String accountId);

}
