package notification.service;

import notification.dto.Order;

public interface NotificationService {
   void sendOrder(Order order);
}
