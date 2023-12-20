package dev.vishnu.productservice.controllers;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.exceptions.NotFoundException;
import dev.vishnu.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @MockBean
    ProductService productService;

    @MockBean
    ProductController productController;
    @Test
    void TestGetAllProducts() throws NotFoundException {
        when(productService.getProductById(any(Long.class))).thenReturn(null);
        GenericProductDto genericProductDto = productController.getProductById(12342L);
        assertNull(genericProductDto);
    }
}
