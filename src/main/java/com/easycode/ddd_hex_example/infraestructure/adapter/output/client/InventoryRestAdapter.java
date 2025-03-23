package com.easycode.ddd_hex_example.infraestructure.adapter.output.client;

import com.easycode.ddd_hex_example.application.port.output.InventoryOutPutPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class InventoryRestAdapter implements InventoryOutPutPort {


    private final WebClient webClient;

    @Override
    public Mono<Boolean> checkInventory(int productId, int quantity) {

        // Here we should call the inventory endpoint  to check the inventory

        return Mono.just(true); // Dummy Value
    }
}
