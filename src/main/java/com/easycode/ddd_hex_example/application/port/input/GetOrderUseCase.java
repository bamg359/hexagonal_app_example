package com.easycode.ddd_hex_example.application.port.input;

import com.easycode.ddd_hex_example.domain.model.Order;
import reactor.core.publisher.Mono;

public interface GetOrderUseCase {

    Mono<Order> getOrder(int orderId);
}
