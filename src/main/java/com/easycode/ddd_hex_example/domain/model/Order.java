package com.easycode.ddd_hex_example.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Order {

    private int orderId;
    private OrderStatus status;

    List<OrderItem> orderItems;

}
