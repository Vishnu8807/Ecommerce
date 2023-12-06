package dev.vishnu.productservice.services;

import dev.vishnu.productservice.dtos.GenericCategoryDto;
import dev.vishnu.productservice.models.Category;
import dev.vishnu.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<GenericCategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<GenericCategoryDto> genericCategoryDtoList = new ArrayList<>();
        for(Category c :categoryList) {
            GenericCategoryDto genericCategoryDto = new GenericCategoryDto();
            genericCategoryDto.setName(c.getName());
            genericCategoryDto.setProductList(c.getProducts());
            genericCategoryDtoList.add(genericCategoryDto);
        }
        return genericCategoryDtoList;
    }

    public List<GenericCategoryDto> getCategory(String category) {
        List<Category> categoryList = categoryRepository.findByCategory(category);
        List<GenericCategoryDto> genericCategoryDtoList = new ArrayList<>();
        for(Category c :categoryList) {
            GenericCategoryDto genericCategoryDto = new GenericCategoryDto();
            genericCategoryDto.setName(c.getName());
            genericCategoryDto.setProductList(c.getProducts());
            genericCategoryDtoList.add(genericCategoryDto);
        }
        return genericCategoryDtoList;
    }


}
