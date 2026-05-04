package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c " +
            "FROM Category c " +
            "WHERE c.user.id = :userId " +
            "OR c.user IS NULL")
    List<Category> findAllCategories(long userId);

}
