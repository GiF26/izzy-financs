package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.CategoryDTO;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users/{userId}")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> listAllCategoriesByIdUser(long userId) {

    }
}
