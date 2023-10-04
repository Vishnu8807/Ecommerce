package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    void updateProductById(Long id,GenericProductDto product);

    void deleteProductById(Long id);
}
