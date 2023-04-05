package com.digitalbooking.back.bookStayApp.products.service;

import com.digitalbooking.back.bookStayApp.address.domain.Address;
import com.digitalbooking.back.bookStayApp.address.domain.AddressRepository;
import com.digitalbooking.back.bookStayApp.images.domain.Image;
import com.digitalbooking.back.bookStayApp.policies.domain.Policy;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import com.digitalbooking.back.bookStayApp.products.dto.ProductToUpdateDTO;
import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import com.digitalbooking.back.management.features.domain.Feature;
import com.digitalbooking.back.management.features.domain.FeatureRepository;
import com.digitalbooking.back.management.locations.domain.City;
import com.digitalbooking.back.management.locations.domain.CityRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UpdateProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void handle(ProductToUpdateDTO productToUpdateDTO) {
        log.info("Executing UpdateProductService.handle()");

        // Retrieve the existing product by ID
        Optional<Product> existingProductOpt = productRepository.findById(productToUpdateDTO.getId());
        if (!existingProductOpt.isPresent()) {
            log.error("Product not found with id: {}", productToUpdateDTO.getId());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }

        Product existingProduct = existingProductOpt.get();

        // Update basic fields
        existingProduct.setTitle(productToUpdateDTO.getTitle());
        existingProduct.setDescription(productToUpdateDTO.getDescription());
        existingProduct.setStars(productToUpdateDTO.getStars());
        existingProduct.setScoring(productToUpdateDTO.getScoring());
        existingProduct.setReview(productToUpdateDTO.getReview());

        // Update address
        Address address = modelMapper.map(productToUpdateDTO.getAddress(), Address.class);
        Optional<City> city = cityRepository.findById(productToUpdateDTO.getAddress().getCity());
        if (!city.isPresent()) {
            throw new IllegalArgumentException("City not found");
        }
        address.setCity(city.get());
        existingProduct.setAddress(address);

        // Update category
        Optional<Category> category = categoryRepository.findById(productToUpdateDTO.getCategory());
        if (!category.isPresent()) {
            throw new IllegalArgumentException("Category not found");
        }
        existingProduct.setCategory(category.get());

        // Update policy
        Policy policy = modelMapper.map(productToUpdateDTO.getPolicy(), Policy.class);
        existingProduct.setPolicy(policy);

        // Update features
        Set<Feature> features = featureRepository.findFeaturesByIds(productToUpdateDTO.getFeatures());
        if (features.size() != productToUpdateDTO.getFeatures().size()) {
            throw new IllegalArgumentException("Some features not found");
        }
        existingProduct.setFeatures(features);

        // Update images
        List<Image> images = productToUpdateDTO.getImages().stream().map(imageToCreateDTO -> {
            Image image = modelMapper.map(imageToCreateDTO, Image.class);
            image.setProduct(existingProduct);
            return image;
        }).collect(Collectors.toList());
        existingProduct.getImages().clear(); // <-- Clear existing images
        existingProduct.getImages().addAll(images); // <-- Add new images to the existing list

        // Save updated product
        productRepository.save(existingProduct);
        log.info("Product updated with id: {}", existingProduct.getId());
    }
}