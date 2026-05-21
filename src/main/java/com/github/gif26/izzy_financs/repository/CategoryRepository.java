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
    List<Category> findCategories(long userId);

    @Query("SELECT c " +
            "FROM Category c " +
            "WHERE c.user.id = :userId " +
            "AND c.visible = true " +
            "ORDER BY c.id")
    List<Category> findActivesCategories(long userId);

    @Query("SELECT c " +
            "FROM Category c " +
            "WHERE c.user.id = :userId " +
            "AND c.visible = false " +
            "ORDER BY c.id")
    List<Category> findDesactiveCategories(long userId);

    @Query("SELECT c  " +
            "FROM Category c " +
            "WHERE c.user.id = :userId " +
            "AND c.sequenceId = :sequenceId")
    Category findByUserIdAndSequenceId(@Param("userId") long userId,
                                       @Param("sequenceId") long sequenceId);

    @Modifying
    @Query("UPDATE Category c SET c.description = :description " +
            "WHERE c.user.id = :userId " +
            "AND c.sequenceId = :sequenceId")
    void updateDescription(@Param("userId") Long userId,
                           @Param("description") String description,
                           @Param("sequenceId") Long sequenceId);

    @Modifying
    @Query("UPDATE Category c SET c.visible = :visible " +
            "WHERE c.user.id = :userId " +
            "AND c.sequenceId = :sequenceId")
    void updateVisibility(@Param("userId") Long userId,
                           @Param("visible") boolean visible,
                           @Param("sequenceId") Long sequenceId);

    @Modifying
    @Query("DELETE FROM Category c " +
            "WHERE c.user.id = :userId " +
            "AND c.sequenceId = :sequenceId")
    void deleteCategory(@Param("userId") Long userId, @Param("sequenceId") Long sequenceId);

    @Query("SELECT MAX(c.sequenceId) " +
            "FROM Category c " +
            "WHERE c.user.id = :userId")
    Optional<Long> findMaxSequenceIdByUserId(@Param("userId") long userId);
}
