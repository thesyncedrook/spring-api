package com.transactionapis.controller;

import com.transactionapis.domain.Account;
import com.transactionapis.domain.Transaction;
import com.transactionapis.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/CreateAccount")
    public String CreateAccount(@RequestBody Account account) {

        try {
            account.setTransactions(new ArrayList<Transaction>());
            transactionService.createAccount(account);
            return "Account Created";
        } catch (Exception e) {
            return "There is some error";
        }
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody Transaction transaction) {
        transactionService.withDraw(transaction);
        return "Transaction created";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestBody Transaction transaction) {
        transactionService.deposit(transaction);
        return "transaction created and successful";
    }

    @GetMapping("/getLatestBalance/{accountNumber}")
    public double getLatestBalance(@PathVariable("accountNumber") String accountNumber) {
        double balance = transactionService.getBalance(accountNumber);
        return balance;
    }

    @GetMapping("/getWithdrawlTransactions/{accountNumber}")
    public List<Transaction> getWithdrawlTransactions(@PathVariable ("accountNumber") String accountNumber){
        List list =transactionService.getWithdrawlTransactions(accountNumber);
        return list;
    }
}
