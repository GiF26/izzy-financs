package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.CategoryDTO;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> listAllCategoriesByIdUser(long userId) {
        List<CategoryDTO> categories = categoryRepository.findAllCategories(userId)
                .stream().map(c -> new CategoryDTO(c.getDescription(), c.getUser()))
                .toList();
//        List<CategoryDTO> categories = categoryRepository.findAll()
//                .stream().map(c -> new CategoryDTO(c.getDescription(), c.getUserId()))
//                .toList();
        return categories;
    }

    public void createCategoriesDefault() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Alimentação"));
        categories.add(new Category("Entreterimento"));
        categories.add(new Category("Estudos"));
        categories.add(new Category("Pet"));
        categoryRepository.saveAll(categories);
    }

    public void createCategory(CategoryDTO dto, long userId) {
        categoryRepository.save(new Category(dto.description(), userId));
    }
}
