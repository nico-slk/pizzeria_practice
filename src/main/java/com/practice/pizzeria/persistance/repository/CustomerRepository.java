package com.practice.pizzeria.persistance.repository;

import com.practice.pizzeria.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Integer> {
//    @Query(value = "SELECT c from CustomerEntity c where c.phoneNumber = :phone")
    @Query(value = "select * from customer where phone_number = :phone", nativeQuery = true)
    CustomerEntity findByNumber(@Param("phone") String phone);
}
