package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class selfProductServiceImpl implements ProductService{
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
