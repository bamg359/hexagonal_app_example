package com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence;


import com.easycode.ddd_hex_example.application.port.output.OrderOutPutPort;
import com.easycode.ddd_hex_example.domain.model.Order;
import com.easycode.ddd_hex_example.domain.model.OrderItem;
import com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.mapper.OrderMapper;
import com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.repository.OrderItemRepository;
import com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderOutPutPort {


    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;

    @Override
    public Mono<Order> saveOrder(Order order){
        return orderRepository.save(orderMapper.toOrderEntity(order))
                .map(orderMapper::toOrderDomain);

    }


    @Override
    public Mono<OrderItem> saveOrderItems(int orderId, OrderItem orderItem) {
        return orderItemRepository.save(orderMapper.toOrderItemEntity(orderId, orderItem))
                .map(orderMapper::toOrderItemDomain);
    }

    @Override
    public Mono<Order> findOrderById(int orderId) {
        return null;
    }
}
