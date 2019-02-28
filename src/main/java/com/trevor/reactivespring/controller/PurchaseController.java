package com.trevor.reactivespring.controller;

import com.trevor.reactivespring.Model.Purchase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/coin/purchase/v1")
public class PurchaseController {

    @PostMapping(value = "/{name}")
    public Mono<Purchase> createPurchase(@PathVariable("name") String name) {
        return Mono.fromSupplier(() -> new Purchase("name", "price", LocalDateTime.now()));
    }
}
