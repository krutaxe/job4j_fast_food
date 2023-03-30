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

@Service
@AllArgsConstructor
public class KitchenServiceImpl implements KitchenService {
    private final KitchenRepository repository;
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Override
    @KafkaListener(topics = "preorder", groupId = "app.1")
    public void acceptOrder(Order order)  {
        Kitchen kitchen = new Kitchen();
        kitchen.setOrderId(order.getId());
        kitchen.setStatusOrder(order.getStatusOrder());
        kitchen.setPaidOrder(order.isPaid());
        repository.save(kitchen);
        orderProcessing(kitchen);
    }

    @Override
    public void orderProcessing(Kitchen kitchen) {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        if (random.nextBoolean()) {
            kitchen.setStatusOrder(StatusOrder.READY_FOR_DELIVERY);
        } else {
            kitchen.setStatusOrder(StatusOrder.CANCELED);
        }
        repository.save(kitchen);
        kafkaTemplate.send("cooked_order", kitchen.getStatusOrder().toString());
    }

}
