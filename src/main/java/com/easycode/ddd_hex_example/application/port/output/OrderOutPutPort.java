package com.easycode.ddd_hex_example.application.port.output;

import com.easycode.ddd_hex_example.domain.model.Order;
import com.easycode.ddd_hex_example.domain.model.OrderItem;
import reactor.core.publisher.Mono;

public interface OrderOutPutPort {

    Mono<Order> saveOrder(Order order);
    Mono<OrderItem> saveOrderItems(int orderId, OrderItem orderItem);
    Mono<Order> findOrderById(int orderId);



}
