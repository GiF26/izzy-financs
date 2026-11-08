package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.request.AddCategoryDTO;
import com.github.gif26.izzy_financs.dto.request.EditCategoryDTO;
import com.github.gif26.izzy_financs.dto.response.ResponseCategoryDTO;
import com.github.gif26.izzy_financs.infra.exception.ValidationsExceptions;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import com.github.gif26.izzy_financs.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository repository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CategoryService service;

    @Test
    @DisplayName("Criacao de categoria caminho feliz")
    void create() {
        long id = 1;
        AddCategoryDTO dto = new AddCategoryDTO("categoria", id);

        User user = new User();
        user.setId(id);

        Category categoryEntity = new Category();
        categoryEntity.setId(id);
        categoryEntity.setTitle("categoria");
        categoryEntity.setUser(user);

        when(userRepository.findById(dto.userId())).thenReturn(Optional.of(user));
        when(repository.save(any(Category.class))).thenReturn(categoryEntity);

        ResponseCategoryDTO response = service.create(dto);

        assertNotNull(response);
        assertEquals("categoria", response.title());
        verify(repository, times(1)).save(any(Category.class));;
    }

    @Test
    @DisplayName("Criacao de categoria caminho triste (busca usuario)")
    void create02() {
        AddCategoryDTO dto = new AddCategoryDTO("categoria", 0);

        when(userRepository.findById(dto.userId())).thenReturn(Optional.empty());

        ValidationsExceptions response = assertThrows(ValidationsExceptions.class,() -> service.create(dto));
        assertEquals("Usuario nao encontrado", response.getMessage());
        verify(repository, never()).save(any());
    }

//    @Test
//    @DisplayName("Edicao de categoria caminho feliz")
//    void edit() {
//
//    }
}