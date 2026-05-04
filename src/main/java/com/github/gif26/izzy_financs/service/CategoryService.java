package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.controller.CategoryController;
import com.github.gif26.izzy_financs.dto.CategoryDTO;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> listAllCategoriesByIdUser(long userId) {

    }

    private List<Category> carregaCategoriasDefault() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Alimentação"));
        categories.add(new Category("Entreterimento"));
        categories.add(new Category("Estudos"));
        categories.add(new Category("Pet"));
        categoryRepository.saveAll(categories);
        return categories;
    }
}
