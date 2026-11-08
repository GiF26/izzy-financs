package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.request.AddCategoryDTO;
import com.github.gif26.izzy_financs.dto.request.EditCategoryDTO;
import com.github.gif26.izzy_financs.dto.response.ResponseCategoryDTO;
import com.github.gif26.izzy_financs.infra.exception.ValidationsExceptions;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import com.github.gif26.izzy_financs.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private UserRepository userRepository;

    public ResponseCategoryDTO create(AddCategoryDTO dto) {
        User user = buscaUsuario(dto.userId());
        Category category = repository.save(new Category(user, dto.title()));
        return new ResponseCategoryDTO(category.getId(), category.getTitle());
    }

    @Transactional
    public void update(EditCategoryDTO dto) {
        buscaUsuario(dto.userId());
        Category category = repository.findByIdAndUserId(dto.id(), dto.userId())
                .orElseThrow(() -> new ValidationsExceptions("Categoria não encontrada ou não pertence a este usuário."));
        category.setTitle(dto.title());
        category.setActive(dto.active());
        repository.save(category);
    }

    //TODO:Em breve validar o id do usuario tambem
    @Transactional
    public void delete(long id){
        Category category = repository.getReferenceById(id);
        repository.delete(category);
    }

    public List<ResponseCategoryDTO> findAllCategories() {
        return repository
                .findAll()
                .stream()
                .map(c -> new ResponseCategoryDTO(c.getId(), c.getTitle()))
                .toList();
    }

    private User buscaUsuario(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ValidationsExceptions("Usuario nao encontrado"));
    }
}
