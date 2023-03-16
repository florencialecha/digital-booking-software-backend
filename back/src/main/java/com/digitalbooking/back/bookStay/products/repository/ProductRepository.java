package com.digitalbooking.back.bookStay.products.repository;

import com.digitalbooking.back.bookStay.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findByAddressCityName(String cityName);
//
//    List<Product> findByCategoryId(Long categoryId);
}
