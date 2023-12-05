package dev.vishnu.productservice.thirdPartyProductServiceClient.fakeStore;

import dev.vishnu.productservice.models.Category;
import dev.vishnu.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private  String image;
    private Category category;
    private Price price;
}
