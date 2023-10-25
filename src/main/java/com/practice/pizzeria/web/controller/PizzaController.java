package com.practice.pizzeria.web.controller;

import com.practice.pizzeria.persistance.entity.PizzaEntity;
import com.practice.pizzeria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public PizzaEntity getPizza(@PathVariable Integer idPizza) {
        return pizzaService.getPizza(idPizza);
    }

    @PostMapping("/")
    public ResponseEntity<PizzaEntity> savePizza(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() == null || !this.pizzaService.pizzaExist(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> updatePizza(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() != null && this.pizzaService.pizzaExist(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> deletePizza(@PathVariable Integer idPizza) {
        if (this.pizzaService.pizzaExist(idPizza)) {
            this.pizzaService.deletePizza(idPizza);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAllAvailable() {
        return ResponseEntity.ok(this.pizzaService.getAllAvailable());
    }

    @GetMapping("/available/{pizzaName}")
    public ResponseEntity<PizzaEntity> getPizzaByName(@PathVariable String pizzaName) {
        return ResponseEntity.ok(this.pizzaService.findPizzaByName(pizzaName));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PizzaEntity>> getPagedPizzaList(@RequestParam(defaultValue = "0") Integer page,
                                                               @RequestParam(defaultValue = "5") Integer size) {
        return ResponseEntity.ok(this.pizzaService.pagedPizzaList(page, size));
    }

    @GetMapping("/pageSort")
    public ResponseEntity<Page<PizzaEntity>> getAllAvailablePageable(@RequestParam(defaultValue = "0") Integer page,
                                                                     @RequestParam(defaultValue = "5") Integer size,
                                                                     @RequestParam(defaultValue = "price") String sortBy,
                                                                     @RequestParam(defaultValue = "ASC") String sortDirection) {
        return ResponseEntity.ok(this.pizzaService.getAllAvailablePageable(page, size, sortBy, sortDirection));
    }
}
