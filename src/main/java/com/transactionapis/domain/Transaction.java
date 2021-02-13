package com.transactionapis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.lang.annotation.Documented;
import java.time.LocalDateTime;

@Document("transactions")
public class Transaction {
    @Id
    private long id;
    private String accountNumber;
    private LocalDateTime transactionTs;
    private Double amount;
    private String transactionType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transaction(long id, String accountNumber, LocalDateTime transactionTs, Double amount,
                       String transactionType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.transactionTs = transactionTs;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getTransactionTs() {
        return transactionTs;
    }

    public void setTransactionTs(LocalDateTime transactionTs) {
        this.transactionTs = transactionTs;
    }



    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber='" + accountNumber + '\'' +
                ", transactionTs='" + transactionTs + '\'' +
                ", amount=" + amount +
                '}';
    }
}