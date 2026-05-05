package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.CategoryDTO;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.model.enums.CategoryEnum;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import com.github.gif26.izzy_financs.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CategoryDTO> listAllCategoriesByIdUser(long userId) {
        return categoryRepository.findAllCategories(userId)
                .stream().map(c -> new CategoryDTO(c.getId(), c.getDescription()))
                .toList();
    }

    public void createCategory( long userId, CategoryDTO dto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        categoryRepository.save(new Category(dto.description(), user));
    }

    @Transactional
    public void updateCategory(Long userId, CategoryDTO dto) {
        categoryRepository.updateDescription(userId, dto.description(), dto.id());
    }

    @Transactional
    public void deleteCategory(Long userId, long id) {
        categoryRepository.deleteCategory(userId, id);
    }

    @Transactional
    public void createCategoriesDefault(User user) {
        List<Category> categories = new ArrayList<>();
        for (CategoryEnum cat : CategoryEnum.values()) {
            categories.add(new Category(cat.getDescricao(), user));
        }
        categoryRepository.saveAll(categories);
    }
}
