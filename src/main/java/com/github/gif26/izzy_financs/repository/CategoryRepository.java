package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c " +
            "FROM Category c " +
            "JOIN c.userId u " +
            "WHERE u.id = :userId " +
            "OR ISNULL(u.id)")
    List<Category> findAllCategories(long userId);

}
