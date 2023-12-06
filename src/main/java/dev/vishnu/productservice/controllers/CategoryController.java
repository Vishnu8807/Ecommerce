package dev.vishnu.productservice.controllers;

import dev.vishnu.productservice.dtos.GenericCategoryDto;
import dev.vishnu.productservice.dtos.GenericProductDto;
import dev.vishnu.productservice.services.CategoryService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("getAllCategories")
    public List<GenericCategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("getCategory/{category}")
    public  List<GenericCategoryDto> getCategory(@PathVariable String category) {
        return categoryService.getCategory(category);
    }
}
