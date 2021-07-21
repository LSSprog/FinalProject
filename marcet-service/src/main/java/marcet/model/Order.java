package marcet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "sum_cost")
    private int sumCost;

    @Column(name = "adres")
    private String adres;
}
