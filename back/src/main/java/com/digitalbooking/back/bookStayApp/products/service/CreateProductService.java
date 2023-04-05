package com.digitalbooking.back.bookStayApp.products.service;

import com.digitalbooking.back.bookStayApp.address.domain.Address;
import com.digitalbooking.back.bookStayApp.address.domain.AddressRepository;
import com.digitalbooking.back.bookStayApp.images.domain.Image;
import com.digitalbooking.back.bookStayApp.policies.domain.Policy;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import com.digitalbooking.back.bookStayApp.products.dto.ProductToCreateDTO;
import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import com.digitalbooking.back.management.features.domain.Feature;
import com.digitalbooking.back.management.features.domain.FeatureRepository;
import com.digitalbooking.back.management.locations.domain.City;
import com.digitalbooking.back.management.locations.domain.CityRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CreateProductService {
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

    public void handle(Product product, ProductToCreateDTO productToCreateDTO) {
        log.info("Executing CreateProductService.handle()");

        // Find category by ID
        log.info("Finding category by ID {}", productToCreateDTO.getCategory());
        Optional<Category> category = categoryRepository.findById(productToCreateDTO.getCategory());
        log.info("Category found with title: {}", category.get().getTitle());

        if (!category.isPresent()) {
            throw new IllegalArgumentException("Category not found");
        }
        product.setCategory(category.get());
        log.info("Category {} found and saved on product", product.getCategory().getTitle());

        // Find features by IDs
        Set<Feature> features = featureRepository.findFeaturesByIds(productToCreateDTO.getFeatures());
        log.info("Found {} features", features.size());
        //Check if all features were found
        if (features.size() != productToCreateDTO.getFeatures().size()) {
            throw new IllegalArgumentException("Some features not found");
        }
        product.setFeatures(features);
        log.info("{} features saved on product", product.getFeatures().size());

        // Map Policy DTO to Policy entity
        Policy policy = modelMapper.map(productToCreateDTO.getPolicy(), Policy.class);
        product.setPolicy(policy);
        log.info("Policy saved on product");

        // Map Image DTOs to Image entities and set product
        List<Image> images = productToCreateDTO.getImages().stream().map(imageToCreateDTO -> {
            Image image = modelMapper.map(imageToCreateDTO, Image.class);
            image.setProduct(product);
            return image;
        }).collect(Collectors.toList());
        product.setImages(images);
        log.info("{} images saved on product", product.getImages().size());

        // Map Address DTO to Address entity
        Address address = modelMapper.map(productToCreateDTO.getAddress(), Address.class);
        Optional<City> city = cityRepository.findById(productToCreateDTO.getAddress().getCity());
        log.info("City found with name: {}", city.get().getName());

        if (!city.isPresent()) {
            throw new IllegalArgumentException("City not found");
        }

        address.setCity(city.get());
        //address.setProduct(product);
        product.setAddress(address);
        log.info("Address saved on product");

        // Save product
        productRepository.save(product);
        log.info("Product created with id: {} and title: {}", product.getId(), product.getTitle());
    }
}