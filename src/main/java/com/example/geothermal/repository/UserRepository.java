package com.example.geothermal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.geothermal.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}