package com.trevor.reactivespring.service;

import com.trevor.reactivespring.Model.CoinbaseResponse;
import com.trevor.reactivespring.Model.Purchase;
import reactor.core.publisher.Mono;

public interface CoinbaseService {

    Mono<CoinbaseResponse> getCryptoPrice(String priceName);

    Mono<Purchase> createPurchase(String priceName);
}
