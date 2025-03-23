package com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.repository;

import com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.entity.OrderItemEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface OrderItemRepository extends R2dbcRepository<OrderItemEntity, Integer> {
    Flux<OrderItemEntity> findAllByOrderId(int orderId);
}
