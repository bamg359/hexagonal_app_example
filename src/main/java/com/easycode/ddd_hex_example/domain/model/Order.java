package com.easycode.ddd_hex_example.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Order {

    private Integer orderId;
    private List<OrderItem> items;
    private OrderStatus status;


}
