package com.practice.pizzeria.persistance.repository;


import com.practice.pizzeria.persistance.entity.PizzaEntity;
import com.practice.pizzeria.services.dto.UpdatePizzaPriceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer>, ListPagingAndSortingRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPriceAsc();
    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
    Page<PizzaEntity> findAllByAvailableTrue(Pageable pageable);
    @Query(value = "UPDATE pizza " +
            "SET price = :#{#updatePizzaPriceDTO.newPrice} " +
            "WHERE id_pizza = :#{#updatePizzaPriceDTO.pizzaId}", nativeQuery = true)
    @Modifying //Esta anotación sirve para hacer cualquier modificación en los Queries, si no está esta anotación, solo se podrá hacer SELECT
    void updatePrice(@Param("updatePizzaPriceDTO")UpdatePizzaPriceDTO updatePizzaPriceDTO);
}
