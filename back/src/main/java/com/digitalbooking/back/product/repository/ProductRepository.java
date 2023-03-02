package com.digitalbooking.back.product.repository;

import com.digitalbooking.back.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Optional<List<Product>> findByCity(String city);

}
