package domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    private String city;
    private String street;
    private int building;
    private int room;
}
