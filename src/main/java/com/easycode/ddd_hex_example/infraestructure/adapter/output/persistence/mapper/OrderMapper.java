package com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.mapper;


import com.easycode.ddd_hex_example.domain.model.Order;
import com.easycode.ddd_hex_example.domain.model.OrderItem;
import com.easycode.ddd_hex_example.domain.model.OrderStatus;
import com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.entity.OrderEntity;
import com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class OrderMapper {


    public OrderEntity toOrderEntity(Order order) {
        return OrderEntity.builder()
                .status(order.getStatus().toString())
                .build();
    }

    public OrderItemEntity toOrderItemEntity(Integer orderId , OrderItem orderItem) {
        return OrderItemEntity.builder()
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity())
                .orderId(orderId)
                .build();
    }


    public OrderItem toOrderItemDomain(OrderItemEntity orderItem) {
        return new OrderItem(orderItem.getProductId(), orderItem.getQuantity());
    }


    public Order toOrderDomain(OrderEntity orderEntity) {
        return new Order(orderEntity.getId(), Collections.emptyList(), OrderStatus.valueOf(orderEntity.getStatus()));
    }

    public Order toOrderDomain(OrderEntity orderEntity, List<OrderItem> orderItems) {
        return new Order(orderEntity.getId(), orderItems, OrderStatus.valueOf(orderEntity.getStatus()));
    }



}
