package ru.job4j.fast_food.model;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String street;
    private int building;
    private int room;
}
