package service;

import model.Dish;
import model.Food;

public interface DishService {
    void addDish(Dish dish);

    Dish findByFood(Food food);

    void updateDish(Dish dish);

    void deleteDish(Dish dish);
}
