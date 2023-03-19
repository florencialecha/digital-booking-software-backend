package com.digitalbooking.back.management.categories;

import com.digitalbooking.back.management.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    Optional<List<Category>> findByTitle(String title);

}
