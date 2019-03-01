package com.trevor.reactivespring.service;

import com.trevor.reactivespring.Model.CoinbaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class CoinbaseServiceImpl implements CoinbaseService {

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<CoinbaseResponse> getCryptoPrice(String priceName) {
        return webClient.get()
                .uri("https://api.coinbase.com/v2/prices/{crypto/buy}", priceName)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CoinbaseResponse.class));
    }
}
