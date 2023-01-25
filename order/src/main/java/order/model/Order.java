package order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn
    private List<Dish> dishes;
    */

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "is_paid")
    private boolean isPaid;

    @Override
    public String toString() {
        return String.format("Order(id=%s ,totalPrice=%s ,isPaid=%s)",
                this.id,
                this.totalPrice,
                this.isPaid);
    }
}
