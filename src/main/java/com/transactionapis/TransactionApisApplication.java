package com.transactionapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@SpringBootApplication
public class TransactionApisApplication {

    @Bean
    public RestTemplate getBuilder() {
        return new  RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(TransactionApisApplication.class, args);
    }

}
