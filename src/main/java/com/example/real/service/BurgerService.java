package com.example.real.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.model.burger.Burger;
import com.example.real.repository.BurgerRepository;

@Service
public class BurgerService {
    @Autowired
    BurgerRepository repository;

    public Burger insertBurger(Burger burger) {
        return repository.save(burger);
    }

    public List<Burger> findAllBurgers () {
        return repository.findAll();
    }

    public void deleteBurgerById(Long id) {
        Optional<Burger> opBurger = repository.findById(id);

        if(opBurger.isEmpty()) {
            System.out.println("Não existe um burger com o id: " + id);
        }

        repository.deleteById(id);
    }
}
