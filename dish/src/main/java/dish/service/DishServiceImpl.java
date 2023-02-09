package dish.service;

import dish.model.Dish;
import dish.repository.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findDishById(int id) {
        return dishRepository.findById(id);
    }

    @Override
    public Dish addDish(Dish dish) {
       return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(int id) {
        dishRepository.deleteById(id);
    }
}
