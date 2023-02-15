package com.digitalbooking.backend.repository;

import com.digitalbooking.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class CategoryRepository extends JpaRepository<Category, Long> {

}
