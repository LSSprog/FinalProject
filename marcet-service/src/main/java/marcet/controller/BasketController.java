package marcet.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcet.dto.BasketItemDTO;
import marcet.dto.ProductDTO;
import marcet.service.BasketService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

//    @PostMapping("/add")
//    public List<ProductDTO> addProductInBasket(@RequestBody ProductDTO productDTO) {
//        return basketService.addProductInBasket(productDTO);
//    }

    @PostMapping("/add") //LSS скопировал метод выше добавив Principal и возврат теперь BasketItemDTO
    public List<BasketItemDTO> addProductToBasket(@RequestBody ProductDTO productDTO, Principal principal) {
        log.info("Product {},  Principal {}", productDTO.getTitle(), principal.getName());
        return basketService.addProductToBasket(productDTO, principal.getName());
    }

//    @GetMapping("/get-basket")
//    public List<ProductDTO> getBasket() {
//        return basketService.getBasket();
//    }

    @GetMapping("/get-basket") //LSS пока добавил username из Principal, если не сработает то надо будет с фронта получать username
    public List<BasketItemDTO> getBasket(Principal principal) {
        return basketService.getBasket(principal.getName());
    }

//    @PostMapping("/del")
//    public List<ProductDTO> delProductOfBasket(@RequestBody ProductDTO productDTO) {
//        return basketService.delProductOfBasket(productDTO);
//    }

    @PostMapping("/del") //LSS //LSS скопировал метод выше добавив Principal и возврат теперь BasketItemDTO
    public List<BasketItemDTO> delProductFromBasket(@RequestBody ProductDTO productDTO, Principal principal) {
        log.info("Product {},  Principal {}", productDTO.getTitle(), principal.getName());
        return basketService.delProductFromBasket(productDTO, principal.getName());
    }


//    @PostMapping("/decriment")
//    public List<ProductDTO> decrimentProduct(@RequestBody ProductDTO productDTO){
//        log.info("Уменьшить количество продукта: {} ", productDTO.getTitle());
//        return basketService.decrimentProduct(productDTO);
//    }

    @PostMapping("/decriment") //LSS скопировал метод выше добавив Principal и возврат теперь BasketItemDTO
    public List<BasketItemDTO> decrementProduct(@RequestBody ProductDTO productDTO, Principal principal){
        log.info("Уменьшить количество продукта: {} ", productDTO.getTitle());
        return basketService.decrementProduct(productDTO, principal.getName());
    }

}
