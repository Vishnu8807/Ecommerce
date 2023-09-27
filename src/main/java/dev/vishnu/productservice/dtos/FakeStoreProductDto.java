package dev.vishnu.productservice.dtos;

import dev.vishnu.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private  String image;
    private String category;
    private double price;
}
