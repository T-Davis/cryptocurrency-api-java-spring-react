package com.trevor.reactivespring.controller;

import com.trevor.reactivespring.Model.Purchase;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class PurchaseHandler {

    public Mono<ServerResponse> listPurchases(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.fromSupplier(
                        () -> new Purchase("ffe", "123", LocalDateTime.now())
                ), Purchase.class);
    }
}
