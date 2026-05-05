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

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CategoryDTO> listAllCategoriesByIdUser(long userId) {
        return categoryRepository.findAllCategories(userId)
                .stream().map(c -> new CategoryDTO(c.getSequenceId(), c.getDescription()))
                .toList();
    }

    public void createCategory( long userId, CategoryDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        long nextSequence = categoryRepository.findMaxSequenceIdByUserId(userId)
                .map(max -> max + 1)
                .orElse(1L);

        Category category = new Category(dto.description(), user, nextSequence);
        category.setSequenceId(nextSequence);

        categoryRepository.save(category);
    }

    @Transactional
    public void updateCategory(Long userId, CategoryDTO dto) {
        categoryRepository.updateDescription(userId, dto.description(), dto.idSequence());
    }

    @Transactional
    public void deleteCategory(Long userId, long id) {
        categoryRepository.deleteCategory(userId, id);
    }

    @Transactional
    public void createCategoriesDefault(User user) {
        for (CategoryEnum cat : CategoryEnum.values()) {
            long nextSequence = categoryRepository.findMaxSequenceIdByUserId(user.getId())
                    .map(max -> max + 1)
                    .orElse(1L);
            categoryRepository.save(new Category(cat.getDescricao(), user, nextSequence));
        }
    }
}
