package com.easycode.ddd_hex_example.infraestructure.adapter.input;

import com.easycode.ddd_hex_example.application.port.input.CreateOrderUserCase;
import com.easycode.ddd_hex_example.application.port.input.GetOrderUseCase;
import com.easycode.ddd_hex_example.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderRestAdapter {




    private final CreateOrderUserCase createOrderUserCase;

    private final GetOrderUseCase getOrderUseCase;



    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order){
        return createOrderUserCase.createOrder(order);
    }

    @GetMapping("/{orderId}")
    public Mono<Order> getOrder(@PathVariable int orderId){
        return getOrderUseCase.getOrder(orderId);
    }


}
