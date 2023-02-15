package order.service;

import lombok.AllArgsConstructor;
import order.model.Order;
import order.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private KafkaTemplate<Integer, Order> kafkaTemplate;

    @Override
    public Optional<Order> getById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        Order newOrder = orderRepository.save(order);
        kafkaTemplate.send("order", newOrder);
        return newOrder;
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
