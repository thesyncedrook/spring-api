package com.transactionapis.service;

import com.transactionapis.domain.Transaction;
import com.transactionapis.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public void withdraw(Transaction transaction) {
        String accountNumber
        transactionRepo.findByAccountNumber()
    }
}
