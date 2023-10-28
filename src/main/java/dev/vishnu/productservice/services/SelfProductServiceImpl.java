package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    public GenericProductDto createProduct(GenericProductDto product) {return  null;}

    public List<GenericProductDto> getAllProducts() {return null;}

    @Override
    public void updateProductById(Long id, GenericProductDto product) {

    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }
}
