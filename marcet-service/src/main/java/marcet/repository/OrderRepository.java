package marcet.repository;

import marcet.model.Order;
import marcet.model.OrderItem;
import marcet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    //Order findOrdersByCreateTime(LocalDateTime date);

    @Query(value = "select MAX(order_id) FROM orders_tbl", nativeQuery = true)
    Long findMaxIDOrder();
    //Order findOrdersBy

    //@Query(value = "")
    //@Query(value = "")
    List<Order> findAllByUser(User user);
}
