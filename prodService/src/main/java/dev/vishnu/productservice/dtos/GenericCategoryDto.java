package dev.vishnu.productservice.dtos;

import dev.vishnu.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenericCategoryDto {
    private String name;
    private List<Product> productList;
}
