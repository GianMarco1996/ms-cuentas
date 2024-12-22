package com.bootcamp.account.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "accounts")
public class Account {
    @Id
    private String id;
    private String accountNumber;
    private String productId;
    private String customerId;
    private String currentBalance;
    private String openingDate;
    private String accountStatus;
}