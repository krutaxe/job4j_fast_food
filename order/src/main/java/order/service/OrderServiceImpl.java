package order.service;

import domain.model.Order;
import domain.model.StatusOrder;
import lombok.AllArgsConstructor;
import order.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
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
        order.setStatusOrder(StatusOrder.ORDER_CREATED);
        Order newOrder = orderRepository.save(order);
        kafkaTemplate.send("preorder", newOrder);
        kafkaTemplate.send("order", newOrder);
        return newOrder;
    }

    @Override
    @KafkaListener(topics = "cooked_order")
    public void acceptOrder(String msg) {
        System.out.println("Status order: " + msg);
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
