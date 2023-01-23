package ru.job4j.fast_food.service;

import ru.job4j.fast_food.model.Dish;
import ru.job4j.fast_food.model.Food;

public interface DishService {
    void addDish(Dish dish);
    Dish findByFood(Food food);
    void updateDish(Dish dish);
    void deleteDish(Dish dish);
}
