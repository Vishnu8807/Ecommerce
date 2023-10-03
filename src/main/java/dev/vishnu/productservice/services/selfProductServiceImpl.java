package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class selfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    public GenericProductDto createProduct(GenericProductDto product) {return  null;}
}
