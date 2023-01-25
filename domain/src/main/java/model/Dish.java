package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Dish {
    @Id
    private int id;

    private String name;

    @OneToMany
    @JoinColumn
    private List<Food> foods;

    private int priceDish;
}
