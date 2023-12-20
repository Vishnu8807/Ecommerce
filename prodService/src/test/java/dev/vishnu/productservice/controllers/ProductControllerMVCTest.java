package dev.vishnu.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.exceptions.NotFoundException;
import dev.vishnu.productservice.models.Category;
import dev.vishnu.productservice.models.Price;
import dev.vishnu.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
public class ProductControllerMVCTest {

    @MockBean
    ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper;
    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception {
        Mockito.when(productService.getAllProducts()).
                thenReturn(new ArrayList<>());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")).
                andExpect(status().is(200)).andExpect(content().string("[]"));
    }

    @Test
    void getAllProductsReturnsListOfProducts() throws Exception {
        //Arrange
        List<GenericProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new GenericProductDto());
        productDtoList.add(new GenericProductDto());
        Mockito.when(productService.getAllProducts()).thenReturn(productDtoList);

        //Act
        //Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")).
                andExpect(status().is(200)).andExpect(content().
                        string("[{\"id\":null,\"title\":null,\"description\":null,\"image\":null,\"category\":null,\"price\":null},{\"id\":null,\"title\":null,\"description\":null,\"image\":null,\"category\":null,\"price\":null}]"));
    }

    @Test
    void getProductByIdReturnsAProduct() throws Exception {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(231L);
        genericProductDto.setTitle("Mobile");
        genericProductDto.setImage("Prod Image");
        genericProductDto.setDescription("Empty");
        genericProductDto.setPrice(new Price());
        genericProductDto.setCategory(new Category());

        Mockito.when(productService.getProductById(231L)).thenReturn(genericProductDto);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/{id}", 231L))
                .andExpect(status().is(200))
                .andExpect(content().string("{\"id\":231,\"title\":\"Mobile\",\"description\":\"Empty\",\"image\":\"Prod Image\",\"category\":{\"id\":0,\"name\":null,\"products\":null},\"price\":{\"id\":0,\"currency\":null,\"price\":0.0}}"));
    }
}
