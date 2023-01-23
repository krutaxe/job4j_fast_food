package ru.job4j.fast_food.model;

import lombok.Data;

import java.util.List;

@Data
public class Dish {
    private int id;
    private String name;
    private List<Food> foods;
    private int priceDish;
}
