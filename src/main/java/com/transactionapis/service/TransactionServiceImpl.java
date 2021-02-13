package com.transactionapis.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.transactionapis.domain.Account;
import com.transactionapis.domain.Transaction;
import com.transactionapis.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;



    @Override
    public void createAccount(Account account) {
        account.setLastUpdateTimeStamp(LocalDateTime.now());
        transactionRepo.save(account);
    }

    @Override
    public double withDraw(Transaction transaction) {
        Account account = transactionRepo.findByAccountNumber(transaction.getAccountNumber());
        double balance = account.getBalance() - transaction.getAmount();
        account.setLastUpdateTimeStamp(LocalDateTime.now());
        account.setBalance(balance);
        transaction.setTransactionTs(LocalDateTime.now());
        transaction.setTransactionType("WITHDRAW");
        ArrayList list = account.getTransactions();
        list.add(transaction);
        transactionRepo.save(account);
        return balance;
    }

    @Override
    public double deposit(Transaction transaction) {

        Account account = transactionRepo.findByAccountNumber(transaction.getAccountNumber());
        double balance = account.getBalance() + transaction.getAmount();
        account.setLastUpdateTimeStamp(LocalDateTime.now());
        account.setBalance(balance);
        transaction.setTransactionTs(LocalDateTime.now());
        transaction.setTransactionType("DEPOSIT");
        ArrayList list = account.getTransactions();
        list.add(transaction);
        transactionRepo.save(account);
        return balance;
    }

    @Override
    public double getBalance(String accountNumber) {
        Optional<Account> account=transactionRepo.findById(accountNumber);
        double balance=account.get().getBalance();
        return balance;
    }

    @Override
    public List<Transaction> getWithdrawlTransactions(String accountNumber) {
        Optional<Account> account=transactionRepo.findById(accountNumber);
        List list=account.get().getTransactions();
        return list;
    }
}
