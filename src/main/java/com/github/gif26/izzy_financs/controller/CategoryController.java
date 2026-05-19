package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.category.CategoryResponseDTO;
import com.github.gif26.izzy_financs.dto.category.CreateCategoryDTO;
import com.github.gif26.izzy_financs.dto.category.UpdateCategoryDTO;
import com.github.gif26.izzy_financs.dto.category.UpdateVisibilityCategoryDTO;
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

    @PostMapping
    public ResponseEntity<Void> createCategory(@PathVariable Long userId,
                                                 @RequestBody CreateCategoryDTO dto) {
        categoryService.createCategory(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<String> updateCategory(@PathVariable Long userId,
                                                 @RequestBody UpdateCategoryDTO dto) {
        categoryService.updateCategory(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body("Category updated successfully");
    }

    @PutMapping("/visibility")
    public ResponseEntity<String> updateVisibilityCategory(@PathVariable Long userId,
                                                           @RequestBody UpdateVisibilityCategoryDTO dto) {
        categoryService.updateVisibilityCategory(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body("Category updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCategory(@PathVariable Long userId,
                                                 @RequestParam Long sequenceId) {
        categoryService.deleteCategory(userId, sequenceId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> listCategoriesByIdUser(@PathVariable Long userId) {
        List<CategoryResponseDTO> response = categoryService.listCategoriesByIdUser(userId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/actives")
    public ResponseEntity<List<CategoryResponseDTO>> listActiveCategoriesByIdUser(@PathVariable Long userId) {
        List<CategoryResponseDTO> response = categoryService.listActiveCategoriesByIdUser(userId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/desactivates")
    public ResponseEntity<List<CategoryResponseDTO>> listDesactiveCategoriesByIdUser(@PathVariable Long userId) {
        List<CategoryResponseDTO> response = categoryService.listDesactiveCategoriesByIdUser(userId);
        return ResponseEntity.ok().body(response);
    }
}
