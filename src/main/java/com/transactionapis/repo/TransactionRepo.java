package com.transactionapis.repo;

import com.transactionapis.domain.Account;
import com.transactionapis.domain.Transaction;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TransactionRepo extends MongoRepository<Account,String> {

  /*  Page<Transaction> findByAccountNumber(boolean published, Pageable pageable);
    Page<Transaction> findByTitleContainingIgnoreCase(String title, Pageable pageable);*/
    Account findByAccountNumber(String accountNumber);

}
