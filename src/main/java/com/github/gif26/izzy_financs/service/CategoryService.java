package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.controller.CategoryController;
import com.github.gif26.izzy_financs.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryController categoryController;

    public List<CategoryDTO> listAllCategoriesByIdUser(long userId) {
        List<CategoryDTO> categories = categoryController.listAllCategoriesByIdUser(userId);
        return categories;
    }
}
