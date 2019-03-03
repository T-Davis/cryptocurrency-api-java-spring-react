package com.trevor.reactivespring.controller;

import com.trevor.reactivespring.Model.Purchase;
import com.trevor.reactivespring.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/purchase/v1")
public class PurchaseController {

    private CoinbaseService coinbaseService;

    @Autowired
    public PurchaseController(CoinbaseService coinbaseService) {
        this.coinbaseService = coinbaseService;
    }

    @PostMapping(value = "/{cryptoName}")
    public Mono<Purchase> createPurchase(@PathVariable String cryptoName) {
        return coinbaseService.createPurchase(cryptoName);
    }
}
