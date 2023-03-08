package com.digitalbooking.back.apiProduct.repository;

import com.digitalbooking.back.apiProduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByAddressCityName(String cityName);

    List<Product> findByCategoryTitle(String categoryName);
}
