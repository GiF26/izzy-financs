package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.CategoryDTO;
import com.github.gif26.izzy_financs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/{userId}/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listAllCategoriesByIdUser(@PathVariable Long userId) {
        List<CategoryDTO> categories = categoryService.listAllCategoriesByIdUser(userId);
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@PathVariable Long userId,
                                                 @RequestBody CategoryDTO dto) {
        categoryService.createCategory(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateCategory(@PathVariable Long userId,
                                                 @RequestBody CategoryDTO dto) {
        categoryService.updateCategory(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body("Category updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCategory(@PathVariable Long userId,
                                                 @RequestParam Long categoryId) {
        categoryService.deleteCategory(userId, categoryId);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
    }
}
