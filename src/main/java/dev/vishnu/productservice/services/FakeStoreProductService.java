package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.FakeStoreProductDto;
import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    private String getRequestURL = "https://fakestoreapi.com/products/{id}";
    private String postRequestURL = "https://fakestoreapi.com/products";

    private String getGetRequestURLForAll = "https://fakestoreapi.com/products";

    private String putRequestURL = "https://fakestoreapi.com/products/{id}";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(getGetRequestURLForAll,
                FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDto = response.getBody();
        List<GenericProductDto> finalList = new ArrayList<>();

        for(int i=0;i<fakeStoreProductDto.length;i++) {
            GenericProductDto product = new GenericProductDto();
            product.setTitle(fakeStoreProductDto[i].getTitle());
            product.setCategory(fakeStoreProductDto[i].getCategory());
            product.setImage(fakeStoreProductDto[i].getImage());
            product.setPrice(fakeStoreProductDto[i].getPrice());
            product.setDescription(fakeStoreProductDto[i].getDescription());
            finalList.add(product);
        }

        return finalList;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(postRequestURL,
                product, GenericProductDto.class);

        return response.getBody();
    }

    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getRequestURL, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());

        return product;
    }

    public void updateProductById(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(putRequestURL,
               product ,GenericProductDto.class);
    }

    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(putRequestURL,
                GenericProductDto.class,id);
    }
}
