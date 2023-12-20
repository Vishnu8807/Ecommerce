package dev.vishnu.productservice.thirdPartyProductServiceClient.fakeStore;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreProductServiceClient{

    private RestTemplateBuilder restTemplateBuilder;

    private String getRequestURL = "https://fakestoreapi.com/products/{id}";
    private String postRequestURL = "https://fakestoreapi.com/products";
    private String getGetRequestURLForAll = "https://fakestoreapi.com/products";
    private String putRequestURL = "https://fakestoreapi.com/products/{id}";

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(getGetRequestURLForAll,
                FakeStoreProductDto[].class);
//        FakeStoreProductDto[] fakeStoreProductDto = response.getBody();
//        List<GenericProductDto> finalList = new ArrayList<>();
//
//        for(int i=0;i<fakeStoreProductDto.length;i++) {
//            GenericProductDto product = new GenericProductDto();
//            product.setTitle(fakeStoreProductDto[i].getTitle());
//            product.setCategory(fakeStoreProductDto[i].getCategory());
//            product.setImage(fakeStoreProductDto[i].getImage());
//            product.setPrice(fakeStoreProductDto[i].getPrice());
//            product.setDescription(fakeStoreProductDto[i].getDescription());
//            finalList.add(product);
//        }

        return Arrays.stream(response.getBody()).toList();
    }

    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(postRequestURL,
                product, FakeStoreProductDto.class);

        return response.getBody();
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getRequestURL, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id " + id +  "doesn't exist");
        }


        return fakeStoreProductDto;
    }

    public void updateProductById(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(putRequestURL,
                product ,GenericProductDto.class);
    }

    public FakeStoreProductDto deleteProductById(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.delete(putRequestURL,
//                GenericProductDto.class,id);

        RestTemplate restTemplate = restTemplateBuilder.build();


        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(putRequestURL, HttpMethod.DELETE,
                requestCallback, responseExtractor, id);

        return response.getBody();
    }

}
