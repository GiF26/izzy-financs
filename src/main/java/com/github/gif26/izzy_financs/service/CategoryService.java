package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.category.CategoryResponseDTO;
import com.github.gif26.izzy_financs.dto.category.CreateCategoryDTO;
import com.github.gif26.izzy_financs.dto.category.UpdateCategoryDTO;
import com.github.gif26.izzy_financs.dto.category.UpdateVisibilityCategoryDTO;
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

    public void createCategory(long userId, CreateCategoryDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        long nextSequence = categoryRepository.findMaxSequenceIdByUserId(userId)
                .map(max -> max + 1)
                .orElse(1L);

        categoryRepository.save(new Category(dto.description(), user, nextSequence));
    }

    @Transactional
    public void updateCategory(Long userId, UpdateCategoryDTO dto) {
        categoryRepository.updateDescription(userId, dto.description(), dto.sequenceId());
    }

    @Transactional
    public void updateVisibilityCategory(Long userId, UpdateVisibilityCategoryDTO dto) {
        categoryRepository.updateVisibility(userId, dto.visible(), dto.sequenceId());
    }

    @Transactional
    public void deleteCategory(Long userId, long sequenceId) {
        categoryRepository.deleteCategory(userId, sequenceId);
    }

    public List<CategoryResponseDTO> listCategoriesByIdUser(long userId) {
        return categoryRepository.findCategories(userId)
                .stream().map(c -> new CategoryResponseDTO(c.getSequenceId(), c.getDescription(), c.isVisible()))
                .toList();
    }

    public List<CategoryResponseDTO> listActiveCategoriesByIdUser(long userId) {
        return categoryRepository.findActivesCategories(userId)
                .stream().map(c -> new CategoryResponseDTO(c.getSequenceId(), c.getDescription(), c.isVisible()))
                .toList();
    }

    public List<CategoryResponseDTO> listDesactiveCategoriesByIdUser(long userId) {
        return categoryRepository.findDesactiveCategories(userId)
                .stream().map(c -> new CategoryResponseDTO(c.getSequenceId(), c.getDescription(), c.isVisible()))
                .toList();
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
