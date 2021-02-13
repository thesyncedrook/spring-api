package com.transactionapis.service;

import com.transactionapis.domain.Account;
import com.transactionapis.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TransactionService {

    public void createAccount(Account account);
    public double withDraw(Transaction transaction);
    public double deposit(Transaction transaction);
    public double getBalance(String accountNumber);
    public List<Transaction> getWithdrawlTransactions(String accountNumber );
}
