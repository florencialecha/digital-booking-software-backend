//package com.digitalbooking.back.management.cities;
//
//import com.digitalbooking.back.management.cities.City;
//import com.digitalbooking.back.management.cities.CityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CityService {
//
//    @Autowired
//    private CityRepository cityRepository;
//
//    public List<City> findAll() {
//        return cityRepository.findAll();
//    }
//
//    public Optional<City> findById(Long id) {
//        return cityRepository.findById(id);
//    }
//
//    public void create(City city) {
//        cityRepository.save(city);
//    }
//
//    public void delete(Long id) {
//        cityRepository.deleteById(id);
//    }
//}
