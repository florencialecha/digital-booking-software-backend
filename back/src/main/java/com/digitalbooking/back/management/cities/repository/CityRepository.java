package com.digitalbooking.back.management.cities.repository;

import com.digitalbooking.back.management.cities.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
