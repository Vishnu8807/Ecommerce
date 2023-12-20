package dev.vishnu.productservice.dtos;

import dev.vishnu.productservice.models.Category;
import dev.vishnu.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    //Generally a third party API returns an object different to out required model object
    //So it is better to create a generic dto
    private Long id;
    private String title;
    private String description;
    private String image;
    private Category category;
    private Price price;
}
