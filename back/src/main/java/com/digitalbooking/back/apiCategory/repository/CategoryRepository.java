package com.digitalbooking.back.apiCategory.repository;

import com.digitalbooking.back.apiCategory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<List<Category>> findByTitle(String title);

}
