package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.models.Product;

public interface ProductService {

    GenericProductDto getProductById(Long id);
}
