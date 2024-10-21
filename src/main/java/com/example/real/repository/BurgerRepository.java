package com.example.real.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real.model.burger.Burger;

public interface BurgerRepository extends JpaRepository<Burger, Long>{
    
}
