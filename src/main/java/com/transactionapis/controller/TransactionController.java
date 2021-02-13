package com.transactionapis.controller;

import com.transactionapis.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TransactionController {


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/transactionEvent")
    public ResponseEntity<Transaction> postEvent(@RequestBody Transaction transaction){
        transaction.setTransactionType("DEPOSIT");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8085/Event",transaction,Transaction.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }

    @GetMapping("/withdraw")
    public ResponseEntity<Transaction> withdrawAmount(@RequestBody Transaction transaction){

    }
}
