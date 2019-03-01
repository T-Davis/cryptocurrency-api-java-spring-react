package com.trevor.reactivespring.service;

import com.trevor.reactivespring.Model.CoinbaseResponse;
import com.trevor.reactivespring.Model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class CoinbaseServiceImpl implements CoinbaseService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private ReactiveMongoOperations reactiveMongoOperations;

    @Override
    public Mono<CoinbaseResponse> getCryptoPrice(String priceName) {
        return webClient.get()
                .uri("https://api.coinbase.com/v2/prices/{crypto/buy}", priceName)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CoinbaseResponse.class));
    }

    @Override
    public Mono<Purchase> createPurchase(String priceName) {
        // Get crypto price from coinbase API -> save to DB
        return getCryptoPrice(priceName).flatMap(
                price -> reactiveMongoOperations.save(
                        new Purchase(priceName, price.getData().getAmount(), LocalDateTime.now())
                )
        );
    }
}
