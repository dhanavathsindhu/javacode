package com.example.frontend.demo.frontend.service;

import java.util.List;

import com.example.frontend.demo.frontend.model.Zomato;

public interface ZomatoService {
	Zomato saveRestaurents(Zomato obj);
	List<Zomato> fetchAllRestaurents();
	Zomato fetchById(int restaurantId) throws Exception;
	Zomato updateRestaurents(int restaurantId, Zomato newVal);
	void deleteRestaurents(int id);
	
}
