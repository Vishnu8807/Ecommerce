package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.exceptions.NotFoundException;
import dev.vishnu.productservice.thirdPartyProductServiceClient.fakeStore.FakeStoreProductDto;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    void updateProductById(Long id,GenericProductDto product);

    GenericProductDto deleteProductById(Long id);
}
