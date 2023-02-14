package notification.dto;

import lombok.Data;

@Data
public class Order {
    private int id;
    private int totalPrice;
    private boolean isPaid;

    public String toString() {
        return String.format("Order(id=%s ,totalPrice=%s ,isPaid=%s)",
                this.id,
                this.totalPrice,
                this.isPaid);
    }
}
