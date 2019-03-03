package com.trevor.reactivespring.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Purchase {

    @Id
    private String id;
    private final String cryptoName;
    private final String price;
    private final LocalDateTime createdAt;

    public Purchase(String cryptoName, String price, LocalDateTime createdAt) {
        this.cryptoName = cryptoName;
        this.price = price;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public String getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
