package com.practice.pizzeria.services;

import com.practice.pizzeria.persistance.entity.PizzaEntity;
import com.practice.pizzeria.persistance.repository.PizzaRepository;
import com.practice.pizzeria.services.dto.UpdatePizzaPriceDTO;
import com.practice.pizzeria.services.exceptions.EmailAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll() {
        return this.pizzaRepository.findAll();
    }

    public PizzaEntity getPizza(Integer idPizza){
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity savePizza (PizzaEntity pizza) {
        return this.pizzaRepository.save(pizza);
    }

    public Boolean pizzaExist(Integer idPizza) {
        return this.pizzaRepository.existsById(idPizza);
    }

    public void deletePizza(Integer idPizza) {
        this.pizzaRepository.deleteById(idPizza);
    }

    public List<PizzaEntity> getAllAvailable() {
        return this.pizzaRepository.findAllByAvailableTrueOrderByPriceAsc();
    }

    public PizzaEntity findPizzaByName(String name) {
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public Page<PizzaEntity> pagedPizzaList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.pizzaRepository.findAll(pageable);
    }

    public Page<PizzaEntity> getAllAvailablePageable(Integer page, Integer size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        System.out.println(page);
        return this.pizzaRepository.findAllByAvailableTrue(pageable);
    }

    @Transactional(noRollbackFor = EmailAPIException.class)
    public void updatePrice(UpdatePizzaPriceDTO dto) {
        this.pizzaRepository.updatePrice(dto);
        this.sendEmail();
    }

    public void sendEmail() {
        throw new EmailAPIException();
    }
}
