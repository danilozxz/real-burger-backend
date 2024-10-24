package com.example.real.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.real.dto.burger.BurgerDTO;
import com.example.real.exception.BurgerNotFoundException;
import com.example.real.model.burger.Burger;
import com.example.real.service.BurgerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/burger")
public class BurgerController {
    @Autowired
    BurgerService service;

    @PostMapping("add")
    public Burger insertBurger(@RequestBody Burger burger) {
        return service.insertBurger(burger);
    }

    @GetMapping("all")
    public List<Burger> findAllBurgers () {
        return service.findAllBurgers();
    }
    
    @DeleteMapping("delete/{id}")
    public void deleteBurgerById(@PathVariable Long id) {
        service.deleteBurgerById(id);
    }

    @PutMapping("update/{id}") 
    public Burger updateBurger(@PathVariable Long id, @RequestBody BurgerDTO burger) throws BurgerNotFoundException {
        return service.updateBurger(id, burger);
    }
}
