package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.request.AddCategoryDTO;
import com.github.gif26.izzy_financs.dto.request.EditCategoryDTO;
import com.github.gif26.izzy_financs.dto.response.ResponseCategoryDTO;
import com.github.gif26.izzy_financs.service.CategoryService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<ResponseCategoryDTO> addCategory(@Valid @RequestBody AddCategoryDTO dto, UriComponentsBuilder uriBuilder) {
        ResponseCategoryDTO response = service.create(dto);

        var uri = uriBuilder.path("/category/{id}")
                .buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    public ResponseEntity<?> editCategory(@Valid @RequestBody EditCategoryDTO dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponseCategoryDTO>> findAll() {
        List<ResponseCategoryDTO> response = service.findAllCategories();
        return ResponseEntity.ok().body(response);
    }
}
