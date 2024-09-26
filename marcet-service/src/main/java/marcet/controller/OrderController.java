package marcet.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcet.dto.OrderDTO;
import marcet.dto.OrderShowDTO;
import marcet.exceptions_handling.MarketError;
import marcet.model.JwtResponse;
import marcet.model.Order;
import marcet.service.BasketService;
import marcet.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private static Long orderCount;
    private final BasketService basketService;
    private final OrderService orderService;

    @PostConstruct
    public void init(){
        orderCount = 0L;
    }

/*
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody String userName) {
        log.info("Username - {}", userName);
        if(userName.equals(null)){
            return new ResponseEntity<>(new MarketError(HttpStatus.UNAUTHORIZED.value(), "Incorrect username"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(basketService.createOrder(userName));
    }
*/

    @PostMapping("/create") //LSS просто скопировал создание заказа как выше было, подставил только другой сервис
    public ResponseEntity<?> createOrder(@RequestParam String userName, Long addressId) {
        log.info("Username - {}", userName);
        if(userName.equals(null)){
            return new ResponseEntity<>(new MarketError(HttpStatus.UNAUTHORIZED.value(), "Incorrect username"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(orderService.createOrder(userName, addressId));
    }


    @PostMapping("/show")
    public ResponseEntity<?> showOrderOnNumber(@RequestBody Long orderNumber){
        log.info("OrderNumber {}", orderNumber);
        return ResponseEntity.ok(orderService.showOrderOnNumber(orderNumber));
    }

    @GetMapping //LSS список всех заказов по юзеру
    public List<OrderDTO> findAllOrderByUsername(Principal principal) {
        String username = principal.getName();
        List<OrderDTO> orderList = orderService.getAllByUsername(username);
        return orderList;
    }
}