package com.practice.pizzeria.services;

import com.practice.pizzeria.persistance.entity.OrderEntity;
import com.practice.pizzeria.persistance.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAllOrders(){
        return this.orderRepository.findAll();
    }

}
