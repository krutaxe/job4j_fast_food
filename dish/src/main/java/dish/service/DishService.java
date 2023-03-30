package dish.service;

import domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    List<Dish> getAll();

    Optional<Dish> findDishById(int id);

    Dish addDish(Dish dish);

    void deleteDish(int id);
}
