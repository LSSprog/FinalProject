package marcet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "addresses_tbl")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "region_fld")
    private String region;

    @Column(name = "city_fld")
    private String city;

    @Column(name = "street_fld")
    private String street;

    @Column(name = "house_number_fld")
    private String houseNumber;

    @JsonIgnore//Нужо ставить когда появляется ошибка переполнения стека
    @ManyToOne // LSS добавил связь и изменил тип данных
    @JoinColumn(name = "user_id")
    private User user;

//    @Column(name = "user_id")
//    private Long userId;

//    @OneToMany
//    @JoinTable(name = "orders_tbl",
//            joinColumns = @JoinColumn(name = "address_id"))
//    private Collection<Order> ordersCollection;

}
