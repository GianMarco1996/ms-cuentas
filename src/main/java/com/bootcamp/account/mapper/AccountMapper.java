package com.bootcamp.account.mapper;

import com.bootcamp.account.model.Account;
import com.bootcamp.account.model.AccountRequest;
import com.bootcamp.account.model.AccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements EntityMapper<Account, AccountResponse, AccountRequest> {

    @Override
    public AccountResponse toModel(Account domain) {
        AccountResponse account = new AccountResponse();
        account.setId(domain.getId());
        account.setAccountNumber(domain.getAccountNumber());
        account.setProductId(domain.getProductId());
        account.setCustomerId(domain.getCustomerId());
        account.setCurrentBalance(domain.getCurrentBalance());
        account.setOpeningDate(domain.getOpeningDate());
        account.setAccountStatus(domain.getAccountStatus());
        return account;
    }

    @Override
    public Account toDocument(AccountRequest model) {
        Account account = new Account();
        account.setAccountNumber(model.getAccountNumber());
        account.setProductId(model.getProductId());
        account.setCustomerId(model.getCustomerId());
        account.setCurrentBalance(model.getCurrentBalance());
        account.setOpeningDate(model.getOpeningDate());
        account.setAccountStatus(model.getAccountStatus());
        return account;
    }
}