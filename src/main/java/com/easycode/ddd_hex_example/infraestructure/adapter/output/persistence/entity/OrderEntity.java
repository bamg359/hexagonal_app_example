package com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
public class OrderEntity {

    @Id
    private int Id;
    private String status;



}
