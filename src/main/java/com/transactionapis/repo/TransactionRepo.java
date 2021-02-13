package com.transactionapis.repo;

import com.transactionapis.domain.Transaction;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TransactionRepo extends MongoRepository<Transaction,String> {

  /*  Page<Transaction> findByAccountNumber(boolean published, Pageable pageable);

    Page<Transaction> findByTitleContainingIgnoreCase(String title, Pageable pageable);*/

    public Optional<Transaction> findByAccountNumber(String accountNumber);
}
