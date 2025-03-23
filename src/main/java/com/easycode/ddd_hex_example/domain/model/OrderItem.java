package com.easycode.ddd_hex_example.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {


    private int productId;
    private int quantity;



}
