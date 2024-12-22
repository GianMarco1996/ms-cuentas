package com.bootcamp.account.service;

import com.bootcamp.account.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    Flux<Account> getAccounts();
    Mono<Account> getAccount(String id);
    Mono<Account> registerAccount(Mono<Account> account);
    Mono<Account> updateAccount(String id, Mono<Account> account);
    Mono<Void> removeAccount(String id);
}