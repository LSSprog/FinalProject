package marcet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders_tbl")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @JsonIgnore
    @OneToMany(mappedBy = "order") // LSS Добавил новую связь и новый парамент в модель Order
    @Cascade(org.hibernate.annotations.CascadeType.ALL) // на лекции ещё вот это добавляли здесь - вроде включили каскадное сохранение
    private List<OrderItem> orderItems;

    @ManyToOne // LSS добавил связь и изменил тип данных
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_quantity_fld")
    private int totalQuantity;

    @Column(name = "total_cost_fld")
    private BigDecimal totalCost;

    @ManyToOne // LSS добавил связь и изменил тип данных
    @JoinColumn(name = "address_id")
    private Address address;

//    @Column(name = "address_id")
//    private Long addressId;


    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createAt; //LSS изменил тип данных

//    private LocalDateTime createTime;

//    @OneToMany
//    @JoinTable(name = "order_items_tbl",
//            joinColumns = @JoinColumn(name = "order_id"))
//    private Collection<Order> ordersItemCollection;


//    @ManyToMany
//    @JoinTable(name = "categories_tbl",
//            joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "title_id"))
//    private Collection<Order> addressCollection;
}
