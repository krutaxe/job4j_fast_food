package model;

import lombok.Data;

import java.util.List;

@Data
public class Dish {
    private int id;
    private String name;
    private List<Food> foods;
    private int priceDish;
}
