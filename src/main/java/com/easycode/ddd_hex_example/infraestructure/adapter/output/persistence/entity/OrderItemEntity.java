package com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_items")
@Data
@Builder
@AllArgsConstructor
public class OrderItemEntity {

    @Id
    private int id;
    @Column("product_id")
    private int productId;
    private int quantity;
    @Column("order_id")
    private int orderId;
}
