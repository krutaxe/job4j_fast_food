package order.service;

import order.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> getById(int id);

    Order save(Order order);

    void delete(int id);

    List<Order> getAll();
}
