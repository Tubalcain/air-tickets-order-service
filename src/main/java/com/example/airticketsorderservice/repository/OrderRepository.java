package com.example.airticketsorderservice.repository;

import com.example.airticketsorderservice.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    OrderEntity save(OrderEntity order);
    OrderEntity findById(int id);
}
