package marcet.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcet.dto.ProductDTO;
import marcet.service.ProductService;
import marcet.specifications.ProductSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminPanelController {

    private final ProductService productService;

    @PostMapping("/add") //LSS создание нового продукта
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createNewProduct(@RequestBody ProductDTO productDTO){
        log.info("создание нового продукта {} в БД ", productDTO.getTitle());
        return productService.saveNewProduct(productDTO);
    }

    @PutMapping("/create") //LSS обновление имеющегося продукта
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO editProducts(@RequestBody ProductDTO productDTO){
        log.info("обновление имеющегося продукта {} в БД ", productDTO.getTitle());
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}") // LSS удаление продукта из базы
    public void deleteProductById(@PathVariable Long id) {
        log.info("Удаление продукта ID - {} ", id);
        productService.deleteProductById(id);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public Page<ProductDTO> findAllProductsAdm(@RequestParam MultiValueMap<String, String> params,
                                               @RequestParam(name = "page", defaultValue = "1") Integer page) {
        for (int i = 0; i < params.size(); i++) {
            log.info("Продукты добавленные в корзину {}", params.toSingleValueMap());
        }

        return productService.findAllProducts(ProductSpecifications.build(params), page, 5);
    }

}
