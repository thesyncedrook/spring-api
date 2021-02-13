package com.transactionapis.service;

import com.transactionapis.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    public void withdraw(Transaction transaction);
    public void deposit(Transaction transaction);
    public double getBalance(String accountNumber);
    public List<Transaction> transactions getTransactions(String)
}
