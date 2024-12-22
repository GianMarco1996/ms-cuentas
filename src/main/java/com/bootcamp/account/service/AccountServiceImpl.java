package com.bootcamp.account.service;

import com.bootcamp.account.model.Account;
import com.bootcamp.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Flux<Account> getAccounts()  {
        return accountRepository.findAll();
    }

    @Override
    public Mono<Account> getAccount(String id)  {
        return accountRepository.findById(id);
    }

    @Override
    public Mono<Account> registerAccount(Mono<Account> account) {
        return account.flatMap(accountRepository::insert);
    }

    @Override
    public Mono<Account> updateAccount(String id, Mono<Account> account) {
        return accountRepository.findById(id)
                .flatMap(a -> account)
                .doOnNext(e -> e.setId(id))
                .flatMap(accountRepository::save);
    }

    @Override
    public Mono<Void> removeAccount(String id)  {
        return accountRepository.deleteById(id);
    }
}