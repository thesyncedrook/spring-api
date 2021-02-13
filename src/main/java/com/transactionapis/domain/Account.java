package com.transactionapis.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document(collection = "Account")
public class Account {

    @Id
    @Field("account")
    String accountNumber;
    LocalDateTime lastUpdateTimeStamp;
    double balance;

    public LocalDateTime getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(LocalDateTime lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public Account(String accountNumber, LocalDateTime lastUpdateTimeStamp, double balance,
                   ArrayList<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
        this.balance = balance;
        this.transactions = transactions;
    }

    ArrayList<Transaction> transactions;



    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
