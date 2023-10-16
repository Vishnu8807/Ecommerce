package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.exceptions.NotFoundException;
import dev.vishnu.productservice.thirdPartyProductServiceClient.fakeStore.FakeStoreProductDto;
import dev.vishnu.productservice.thirdPartyProductServiceClient.fakeStore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDto = fakeStoreProductServiceClient.getAllProducts();
        List<GenericProductDto> finalList = new ArrayList<>();

        for(int i=0;i<fakeStoreProductDto.size();i++) {
            GenericProductDto product = new GenericProductDto();
            product.setTitle(fakeStoreProductDto.get(i).getTitle());
            product.setCategory(fakeStoreProductDto.get(i).getCategory());
            product.setImage(fakeStoreProductDto.get(i).getImage());
            product.setPrice(fakeStoreProductDto.get(i).getPrice());
            product.setDescription(fakeStoreProductDto.get(i).getDescription());
            finalList.add(product);
        }
        return finalList;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreToGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeStoreToGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    public void updateProductById(Long id, GenericProductDto product) {
        fakeStoreProductServiceClient.updateProductById(id,product);
    }

    public GenericProductDto deleteProductById(Long id) {
       return convertFakeStoreToGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }

    public GenericProductDto convertFakeStoreToGenericProduct(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        return product;
    }

}
