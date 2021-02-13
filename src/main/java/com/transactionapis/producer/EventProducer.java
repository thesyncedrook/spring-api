package com.transactionapis.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class EventProducer {
    @Autowired
    private WebClient.Builder builder;

}
