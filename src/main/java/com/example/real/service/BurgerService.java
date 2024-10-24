package com.example.real.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.dto.burger.BurgerDTO;
import com.example.real.exception.BurgerNotFoundException;
import com.example.real.model.burger.Burger;
import com.example.real.repository.BurgerRepository;

@Service
public class BurgerService {
    @Autowired
    BurgerRepository repository;

    public Burger insertBurger(Burger burger) {
        return repository.save(burger);
    }

    public List<Burger> findAllBurgers() {
        return repository.findAll();
    }

    public void deleteBurgerById(Long id) {
        Optional<Burger> opBurger = repository.findById(id);

        if (opBurger.isEmpty()) {
            System.out.println("Não existe um burger com o id: " + id);
        }

        repository.deleteById(id);
    }

    public Burger updateBurger(Long id, BurgerDTO burgerDTO) throws BurgerNotFoundException {
        Burger existingBurger = repository.findById(id)
                .orElseThrow(() -> new BurgerNotFoundException("Burger não encontrado"));

        if (burgerDTO.name() != null) {
            existingBurger.setName(burgerDTO.name());
        }
        if (burgerDTO.category() != null) {
            existingBurger.setCategory(burgerDTO.category());
        }
        if (burgerDTO.ingredients() != null) {
            existingBurger.setIngredients(burgerDTO.ingredients());
        }
        if (burgerDTO.price() != 0) { 
            existingBurger.setPrice(burgerDTO.price());
        }

        return repository.save(existingBurger);
    }

}
