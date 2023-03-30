package dish.controller;

import dish.service.DishService;
import domain.model.Dish;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DishRestController {
    private final DishService dishService;

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable("id") int id) {
        Optional<Dish> dish = dishService.findDishById(id);
        if (dish.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dish.get(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Dish>> findAllDish() {
        return new ResponseEntity<>(dishService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        return new ResponseEntity<>(dishService.addDish(dish), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public void deleteDish(@PathVariable("id") int id) {
         dishService.deleteDish(id);
    }
}
