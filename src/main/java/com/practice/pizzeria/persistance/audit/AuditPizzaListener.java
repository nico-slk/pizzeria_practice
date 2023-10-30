package com.practice.pizzeria.persistance.audit;

import com.practice.pizzeria.persistance.entity.PizzaEntity;
import jakarta.persistence.*;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {

    private PizzaEntity currentValue;

    @PostLoad
    public void onPostLoad(PizzaEntity pizza) {
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(pizza);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity pizza){
        System.out.println("POST UPDATE");
        System.out.println(new String("PREVIOUS VALUE: ").concat(this.currentValue.getName()));
        System.out.println(new String("CURRENT VALUE: ").concat(pizza.getName()));
    }

    @PreRemove
    public void onPreDelete(PizzaEntity pizza) {
        String message = pizza.getName().concat(" ").concat(pizza.getIdPizza().toString()).concat(" DELETED");
        System.out.println(message);
    }
}
