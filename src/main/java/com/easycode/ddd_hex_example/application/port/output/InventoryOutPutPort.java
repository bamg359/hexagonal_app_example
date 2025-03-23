package com.easycode.ddd_hex_example.application.port.output;

import reactor.core.publisher.Mono;

public interface InventoryOutPutPort {

    Mono<Boolean> checkInventory(int productId, int quantity);


}
