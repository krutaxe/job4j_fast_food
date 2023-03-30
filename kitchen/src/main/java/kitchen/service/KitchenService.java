package kitchen.service;

import domain.model.Kitchen;
import domain.model.Order;

public interface KitchenService {
    void acceptOrder(Order order);

    void orderProcessing(Kitchen kitchen);
}
