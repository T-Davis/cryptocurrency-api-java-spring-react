package com.trevor.reactivespring.service;

import com.trevor.reactivespring.Model.CoinbaseResponse;
import com.trevor.reactivespring.Model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CoinbaseServiceImpl implements CoinbaseService {

    private WebClient webClient;
    private ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    public CoinbaseServiceImpl(WebClient webClient, ReactiveMongoOperations reactiveMongoOperations) {
        this.webClient = webClient;
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

    @Override
    public Mono<CoinbaseResponse> getCryptoPrice(String cryptoName) {
        return webClient.get()
                .uri("https://api.coinbase.com/v2/prices/{crypto}/buy", cryptoName)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CoinbaseResponse.class));
    }

    @Override
    public Mono<Purchase> createPurchase(String cryptoName) {
        // Get crypto price from coinbase API -> save to DB
        return getCryptoPrice(cryptoName).flatMap(
                price -> reactiveMongoOperations.save(
                        new Purchase(cryptoName, price.getData().getAmount(), LocalDateTime.now())
                )
        );
    }

    @Override
    public Mono<Purchase> getPurchaseById(String id) {
        return reactiveMongoOperations.findById(id, Purchase.class);
    }

    @Override
    public Flux<Purchase> getAllPurchases() {
        return reactiveMongoOperations.findAll(Purchase.class);
    }
}
