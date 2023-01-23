package ru.job4j.fast_food.model;

import lombok.Data;

import java.util.List;

@Data
public class Delivery {
    private int id;
    private List<Order> orders;
    private List<Customer> customers;
    private boolean isDelivered;

}
