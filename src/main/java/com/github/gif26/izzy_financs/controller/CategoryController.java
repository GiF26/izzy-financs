package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.CategoryDTO;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import com.github.gif26.izzy_financs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/{userId}")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDTO> listAllCategoriesByIdUser(@PathVariable Long userId) {
        List<CategoryDTO> categories = categoryService.listAllCategoriesByIdUser(userId);
        return categories;
    }

    @PostMapping("/categories/create")
    public ResponseEntity<String> createCategory(@PathVariable Long userId,
                                                 @RequestBody CategoryDTO dto) {

        categoryService.createCategory(dto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully");
    }
}
