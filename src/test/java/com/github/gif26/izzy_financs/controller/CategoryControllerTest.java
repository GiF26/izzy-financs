package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.request.AddCategoryDTO;
import com.github.gif26.izzy_financs.dto.request.EditCategoryDTO;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import com.github.gif26.izzy_financs.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private CategoryRepository  repository;

    @Autowired
    private UserRepository userRepository;

    private Category category;

    private User user;

    @Test
    @DisplayName("requisicao de cadastro categoria (caminho feliz)")
    void addCategory() throws Exception {
        AddCategoryDTO dto = new AddCategoryDTO("titulo", user.getId());
        var json =  mapper.writeValueAsString(dto);

        mockMvc.perform(
                post("/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(jsonPath("$.title").value(dto.title())
        ).andDo(print());
    }

    @Test
    @DisplayName("requisicao de cadastro categoria (caminho triste sem titulo)")
    void addCategory02() throws Exception {
        AddCategoryDTO dto = new AddCategoryDTO("", user.getId());
        var json =  mapper.writeValueAsString(dto);

        mockMvc.perform(
                post("/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(status().isBadRequest()
        ).andDo(print());
    }

    @Test
    @DisplayName("requisicao de cadastro categoria (caminho triste sem idUsuario)")
    void addCategory03() throws Exception {
        AddCategoryDTO dto = new AddCategoryDTO("titulo", 0);
        var json =  mapper.writeValueAsString(dto);

        mockMvc.perform(
                post("/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(status().isBadRequest()
        ).andDo(print());
    }

    @Test
    @DisplayName("requisicao de edicao categoria (caminho feliz))")
    void editCategory() throws Exception {
        EditCategoryDTO dto = new EditCategoryDTO(category.getId(), user.getId(), "titulo", true);
        var json =  mapper.writeValueAsString(dto);

        mockMvc.perform(
                put("/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(status().isOk()
        ).andDo(print());
    }

    @BeforeEach
    void createCategory() {
        User user = new  User();
        user.setName("admin");
        user.setEmail("email");
        user.setPassword("password");
        this.user = userRepository.save(user);

        Category category = new Category();
        category.setUser(user);
        category.setTitle("Test Category");
        category.setActive(true);
        this.category = repository.save(category);
    }
}