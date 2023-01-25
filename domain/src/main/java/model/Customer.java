package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    private String surname;
    private int age;
    private int phoneNumber;

    @ManyToOne
    @JoinColumn
    private Address address;
}
