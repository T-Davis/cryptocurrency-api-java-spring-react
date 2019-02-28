package com.trevor.reactivespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/price/v1")
public class PriceController {

    // Todo: change returntype to domain model
    @GetMapping(value = "/{name}")
    public Mono<String> getPrice(@PathVariable String name) {

        // Todo: use autowired service
        return Mono.fromSupplier(() -> "price");
    }
}
