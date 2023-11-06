package com.practice.pizzeria.persistance.repository;

import com.practice.pizzeria.persistance.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends ListCrudRepository<UserEntity, String> {
}
