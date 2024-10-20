package com.example.real.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.real.model.user.User;

public interface UserRepository extends JpaRepository<User, String>{
   UserDetails findByLogin(String login);
}
