package model;

import lombok.Data;

@Data
public class Dish {
    private int id;

    private String name;

    private int priceDish;

    @Override
    public String toString() {
        return String.format("Dish(id=%s ,name=%s ,priceDish=%s)",
                this.id,
                this.name,
                this.priceDish);
    }
}
