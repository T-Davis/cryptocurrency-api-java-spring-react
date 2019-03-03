package com.trevor.reactivespring.controller;

import com.trevor.reactivespring.Model.Purchase;
import com.trevor.reactivespring.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class PurchaseHandler {

    private CoinbaseService coinbaseService;

    @Autowired
    public PurchaseHandler(CoinbaseService coinbaseService) {
        this.coinbaseService = coinbaseService;
    }

    public Mono<ServerResponse> getPurchaseById(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(coinbaseService.getPurchaseById(serverRequest.pathVariable("id")), Purchase.class);
    }

    public Mono<ServerResponse> getAllPurchases(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(coinbaseService.getAllPurchases()
                        .collectList(), new ParameterizedTypeReference<List<Purchase>>() {
                });
    }

}
