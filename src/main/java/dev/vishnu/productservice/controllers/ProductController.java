package dev.vishnu.productservice.controllers;

import dev.vishnu.productservice.dtos.ExceptionDto;
import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.exceptions.NotFoundException;
import dev.vishnu.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    //To use the Service in controller
    //We will use dependency injection
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getALlProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {

        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable Long id){

        return new ResponseEntity<>(productService.deleteProductById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }
    @PutMapping("{id}")
    public void updateProductById(@PathVariable Long id,@RequestBody GenericProductDto product){
        productService.updateProductById(id,product);
    }

}

