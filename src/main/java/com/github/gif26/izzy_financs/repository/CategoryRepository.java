package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c " +
            "FROM Category c " +
            "WHERE c.user.id = :userId " +
            "ORDER BY c.id")
    List<Category> findAllCategories(long userId);

    @Modifying
    @Query("UPDATE Category c SET c.description = :description " +
            "WHERE c.user.id = :userId " +
            "AND c.id = :id")
    void updateDescription(@Param("userId") Long userId,
                           @Param("description") String description,
                           @Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Category c " +
            "WHERE c.user.id = :userId " +
            "AND c.id = :id")
    void deleteCategory(@Param("userId") Long userId, @Param("id") Long id);

    @Query("SELECT MAX(c.sequenceId) " +
            "FROM Category c " +
            "WHERE c.user.id = :userId")
    Optional<Long> findMaxSequenceIdByUserId(@Param("userId") long userId);
}
