package marcet.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcet.dto.ProductDTO;
import marcet.model.Product;
import marcet.service.ProductService;
import marcet.specifications.ProductSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

//    @GetMapping("/products")
//    public String products() {
//        System.out.println("MarcetServiceControlelr Запрос пршол");
//
//        return "Держи Пакет продуктов";
//    }


    @GetMapping("/get-products")
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOS = productService.getProduct();
        for (ProductDTO p : productDTOS){
            log.info("{} {} {} {} {} {} ", p.getTitle(), p.getPrice(), p.getShortDescription());
        }
        return productService.getProduct();
    }

    @PostMapping //LSS создание нового продукта
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createNewProduct(@RequestBody ProductDTO productDTO){
        return productService.saveNewProduct(productDTO);
    }

    @PutMapping //LSS обновление имеющегося продукта
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO editProducts(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{product_id}") // LSS удаление продукта из базы
    public void deleteProductById(@PathVariable Long product_id) {
        productService.deleteProductById(product_id);
    }


    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public Page<ProductDTO> findAllProducts(@RequestParam MultiValueMap<String, String> params,
                                            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        for (int i = 0; i < params.size(); i++) {
            log.info("Продукты добавленные в корзину {}", params.toSingleValueMap());
        }

        return productService.findAllProducts(ProductSpecifications.build(params), page, 5);
    }

    @PostMapping("/add-basket")
    public void addBasketProduct(@RequestBody ProductDTO productDTO) {
        System.out.println(productDTO.getTitle());
        // return new ArrayList<>();
    }

    @GetMapping("/{product_id}") // LSS посик товара по id
    public ProductDTO findProductDtoById(@PathVariable Long product_id) {
        return productService.findProductDtoById(product_id);
    }


}
