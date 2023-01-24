package model;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int phoneNumber;
    private Address address;
    private String login;
    private String password;
}
