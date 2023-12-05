package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.models.Category;
import dev.vishnu.productservice.models.Price;
import dev.vishnu.productservice.models.Product;
import dev.vishnu.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        Product product1 = new Product();
        product1.setTitle(product.get().getTitle());
        product1.setPrice(product.get().getPrice());
        product1.setImage(product.get().getImage());
        product1.setCategory(product.get().getCategory());
        product1.setDescription(product.get().getDescription());
        return convertProductToGenericProduct(product1);
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        Category category = new Category();
        category.setProducts(product.getCategory().getProducts());
        category.setName(product.getCategory().getName());

        Price price = new Price();
        price.setPrice(product.getPrice().getPrice());
        price.setCurrency(product.getPrice().getCurrency());

        Product product1 = new Product();
        product1.setCategory(category);
        product1.setPrice(price);
        product1.setImage(product.getImage());
        product1.setTitle(product.getTitle());
        product1.setDescription(product.getDescription());

        productRepository.save(product1);
        return product;
    }

    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> finalList = new ArrayList<>();
        for(Product p : products) {
            GenericProductDto product1 = new GenericProductDto();
            product1.setTitle(p.getTitle());
            product1.setPrice(p.getPrice());
            product1.setImage(p.getImage());
            product1.setCategory(p.getCategory());
            product1.setDescription(p.getDescription());

            finalList.add(product1);
        }
        return finalList;
    }

    @Override
    public void updateProductById(Long id, GenericProductDto product) {

    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    public GenericProductDto convertProductToGenericProduct(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setCategory(product.getCategory());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setPrice(product.getPrice());
        genericProductDto.setDescription(product.getDescription());
        return genericProductDto;
    }
}
