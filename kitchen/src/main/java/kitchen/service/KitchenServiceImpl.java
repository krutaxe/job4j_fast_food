package kitchen.service;

import domain.model.Kitchen;
import domain.model.Order;
import domain.model.StatusOrder;
import kitchen.repository.KitchenRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class KitchenServiceImpl implements KitchenService {
    private final KitchenRepository repository;
    private KafkaTemplate<Integer, Order> kafkaTemplate;

    @Override
    @KafkaListener(topics = "preorder", groupId = "app.1")
    public void acceptOrder(Order order) {
        Kitchen kitchen = new Kitchen();
        kitchen.setOrderId(order.getId());
        kitchen.setStatusOrder(order.getStatusOrder());
        kitchen.setPaidOrder(order.isPaid());
        repository.save(kitchen);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                orderProcessing(kitchen);
            }
        }, 60, TimeUnit.SECONDS);
    }

    @Override
    public void orderProcessing(Kitchen kitchen) {
        Random random = new Random();
        if (random.nextBoolean()) {
            kitchen.setStatusOrder(StatusOrder.READY_FOR_DELIVERY);
        } else {
            kitchen.setStatusOrder(StatusOrder.CANCELED);
        }
        repository.save(kitchen);
        Order order = new Order();
        order.setStatusOrder(kitchen.getStatusOrder());
        order.setId(kitchen.getOrderId());
        kafkaTemplate.send("cooked_order", order);
    }

}
