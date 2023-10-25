package com.practice.pizzeria.persistance.repository;

import com.practice.pizzeria.persistance.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
}
