package com.trevor.reactivespring.controller;

import com.trevor.reactivespring.Model.CoinbaseResponse;
import com.trevor.reactivespring.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/price/v1")
public class PriceController {

    private CoinbaseService coinbaseService;

    @Autowired
    public PriceController(CoinbaseService coinbaseService) {
        this.coinbaseService = coinbaseService;
    }

    @GetMapping(value = "/{cryptoName}") // such as btc-usd
    public Mono<CoinbaseResponse> getCryptoPrice(@PathVariable String cryptoName) {
        return coinbaseService.getCryptoPrice(cryptoName);
    }
}
