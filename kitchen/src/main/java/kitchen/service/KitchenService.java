package kitchen.service;

import domain.model.Kitchen;
import domain.model.Order;

import java.util.concurrent.ExecutionException;

public interface KitchenService {
    void acceptOrder(Order order);

    void orderProcessing(Kitchen kitchen);
}
