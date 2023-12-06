package dev.vishnu.productservice.repositories;

import dev.vishnu.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "Select * From Category Where name = :category", nativeQuery = true)
    List<Category> findByCategory(@Param("category") String category);
}
