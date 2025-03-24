package com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.repository;


import com.easycode.ddd_hex_example.infraestructure.adapter.output.persistence.entity.OrderEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends R2dbcRepository<OrderEntity, Integer> {

}
