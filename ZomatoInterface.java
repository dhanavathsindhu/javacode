package com.example.frontend.demo.frontend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.frontend.demo.frontend.model.Zomato;

public interface ZomatoInterface extends JpaRepository<Zomato, Integer>{


}