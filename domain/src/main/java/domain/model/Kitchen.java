package domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kitchen")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "status_order")
    private StatusOrder statusOrder;

    @Column(name = "is_paid_order")
    private boolean isPaidOrder;

    @Override
    public String toString() {
        return "Kitchen{"
                + "id=" + id
                + ", orderId=" + orderId
                + ", statusOrder=" + statusOrder
                + ", isPaidOrder=" + isPaidOrder
                + '}';
    }
}
