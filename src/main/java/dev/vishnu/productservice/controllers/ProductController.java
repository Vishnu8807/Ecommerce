package dev.vishnu.productservice.controllers;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    //To use the Service in controller
    //We will use dependency injection
    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public void getALlProducts(){

    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){

        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(){

    }

    @PostMapping
    public void createProduct(){

    }
    @PutMapping("{id}")
    public void updateProductById(){

    }
}

