package marcet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import marcet.model.Order;
import marcet.model.OrderItem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderShowDTO {
        private UserDTO userDTO;
        private List<AddressDTO> addressDTO;
        private List<ProductDTO> productDTO;
        private List<OrderItem> orderItem;
        //private Order order;

}
