package com.practice.pizzeria.services.dto;

import lombok.Data;

@Data
public class UpdatePizzaPriceDTO {
    private Integer pizzaId;
    private Double newPrice;
}
