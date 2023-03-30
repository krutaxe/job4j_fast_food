package notification.service;

import domain.model.Notification;
import domain.model.Order;

public interface NotificationService {
   void acceptOrder(Order order);
}
