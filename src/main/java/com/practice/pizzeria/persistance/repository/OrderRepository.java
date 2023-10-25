package com.practice.pizzeria.persistance.repository;

import com.practice.pizzeria.persistance.entity.OrderEntity;
import com.practice.pizzeria.persistance.projections.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {


    @Query(value = "select po.id_order as idOrder, cu.name as customerName, po.date as orderDate, " +
            "po.total as orderTotal, group_concat(pi.name) as pizzaNames " +
            "from pizza_order po " +
            "inner join customer cu on po.id_customer = cu.id_customer " +
            "    inner join order_item oi on po.id_order = oi.id_order " +
            "    inner join pizza pi on oi.id_pizza = pi.id_pizza " +
            "where po.id_order = :orderId " +
            "group by po.id_order, cu.name, po.date, po.total", nativeQuery = true)
    OrderSummary findSummary(@Param("orderId") Integer orderId);
}
