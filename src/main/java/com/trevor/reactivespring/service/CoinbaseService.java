package com.trevor.reactivespring.service;

import com.trevor.reactivespring.Model.CoinbaseResponse;
import com.trevor.reactivespring.Model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoinbaseService {

    Mono<CoinbaseResponse> getCryptoPrice(String cryptoName);

    Mono<Purchase> createPurchase(String cryptoName);

    Mono<Purchase> getPurchaseById(String id);

    Flux<Purchase> getAllPurchases();
}
