package notification.service;

import domain.model.Notification;
import domain.model.Order;
import lombok.AllArgsConstructor;
import notification.repository.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repository;

    @Override
    @KafkaListener(topics = "order", groupId = "app.1")
    public void acceptOrder(Order order) {
        Notification notification = new Notification();
        notification.setOrderId(order.getId());
        notification.setTotalPriceOrder(order.getTotalPrice());
        notification.setPaidOrder(order.isPaid());
        repository.save(notification);
    }
}
