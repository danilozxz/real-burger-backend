package com.example.real.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.real.model.burger.Burger;
import com.example.real.repository.BurgerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/burger")
public class BurgerController {
    @Autowired
    BurgerRepository repository;

    @PostMapping("add")
    public Burger insertBurger(@RequestBody Burger burger) {
        return repository.save(burger);
    }

    @GetMapping("all")
    public List<Burger> findAllBurgers () {
        return repository.findAll();
    }
    
}
