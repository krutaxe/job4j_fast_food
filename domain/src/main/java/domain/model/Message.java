package domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Message {
    private int id;
    private String message;
    private List<Customer> customers;
}
