package com.digitalbooking.back.apiProduct.repository;

import com.digitalbooking.back.apiProduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Optional<List<Product>> findByCity(String city);

}
