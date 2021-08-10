package marcet.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcet.dto.ProductDTO;
import marcet.service.BasketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/add")
    public List<ProductDTO> addProductInBasket(@RequestBody ProductDTO productDTO) {
        return basketService.addProductInBasket(productDTO);
    }

    @GetMapping("/get-basket")
    public List<ProductDTO> getBasket() {
        return basketService.getBasket();
    }

    @PostMapping("/del")
    public List<ProductDTO> delProductOfBasket(@RequestBody ProductDTO productDTO) {
        return basketService.delProductOfBasket(productDTO);
    }

    @PostMapping("/decriment")
    public List<ProductDTO> decrimentProduct(@RequestBody ProductDTO productDTO){
        log.info("Уменьшить количество продукта: {} ", productDTO.getTitle());
        return basketService.decrimentProduct(productDTO);
    }
}
