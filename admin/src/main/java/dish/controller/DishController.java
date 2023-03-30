package dish.controller;

import lombok.AllArgsConstructor;
import domain.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import dish.srvice.DishService;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class DishController {
    private final DishService dishService;

    @GetMapping("/{id}")
    public String findByName(Model model, @PathVariable("id") int id) {
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        return "show";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "index";
    }

    @GetMapping("/addDishForm")
    public String create() {
        return "created";
    }

    @PostMapping("/")
    public String add(@ModelAttribute Dish dish) {
        dishService.add(dish);
        return "redirect:/api/";
    }

    @PostMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        dishService.delete(id);
        return "redirect:/api/";
    }
}
