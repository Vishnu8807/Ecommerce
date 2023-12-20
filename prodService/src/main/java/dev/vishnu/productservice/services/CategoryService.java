package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<GenericCategoryDto> getAllCategories();

    List<GenericCategoryDto> getCategory(String category);
}
