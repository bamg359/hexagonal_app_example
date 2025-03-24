package com.easycode.ddd_hex_example.domain.service;


import com.easycode.ddd_hex_example.application.port.input.CreateOrderUserCase;
import com.easycode.ddd_hex_example.application.port.input.GetOrderUseCase;
import com.easycode.ddd_hex_example.application.port.output.InventoryOutPutPort;
import com.easycode.ddd_hex_example.application.port.output.OrderOutPutPort;
import com.easycode.ddd_hex_example.domain.model.Order;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService implements CreateOrderUserCase, GetOrderUseCase {


    private final OrderOutPutPort orderOutPutPort;
    private final InventoryOutPutPort inventoryOutPutPort;


    @Override
    public Mono<Order> createOrder(Order order) {
        return orderOutPutPort.saveOrder(order)
                .flatMap(orderSaved -> Flux.fromIterable(order.getItems())
                        .flatMap(orderItem -> inventoryOutPutPort.checkInventory(orderItem.getProductId(), orderItem.getQuantity())
                                .flatMap(isAviable -> {
                                    if (Boolean.FALSE.equals(isAviable)) {
                                        return Mono.error(new RuntimeException("Not Enough Inventory for product: " + orderItem.getProductId()));
                                    }

                                    return orderOutPutPort.saveOrderItems(orderSaved.getOrderId(), orderItem);

                                }))
                        .collectList()
                        .map(orderItems -> {
                            orderSaved.setItems(orderItems);
                            return orderSaved;
                        }));

    }

    @Override
    public Mono<Order> getOrder(int orderId) {
        return orderOutPutPort.findOrderById(orderId);
    }
}