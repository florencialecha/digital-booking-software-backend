package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.address.Address;
import com.digitalbooking.back.bookStayApp.address.AddressToCreateDTO;
import com.digitalbooking.back.bookStayApp.images.Image;
import com.digitalbooking.back.bookStayApp.images.ImageDTO;
import com.digitalbooking.back.bookStayApp.policies.Policy;
import com.digitalbooking.back.bookStayApp.policies.PolicyDTO;
import com.digitalbooking.back.bookStayApp.policies.PolicyRepository;
import com.digitalbooking.back.bookStayApp.products.service.CreateProductService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.management.categories.Category;
import com.digitalbooking.back.management.categories.CategoryRepository;
import com.digitalbooking.back.management.features.Feature;
import com.digitalbooking.back.management.features.FeatureRepository;
import com.digitalbooking.back.bookStay.address.AddressRepository;

import com.digitalbooking.back.management.locations.City;
import com.digitalbooking.back.management.locations.CityRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class CreateProductPostController {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CreateProductService createProductService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @PostMapping
    public void handle(@RequestBody ProductToCreateDTO productToCreateDTO) {
        try {
            Product product = modelMapper.map(productToCreateDTO, Product.class);

            // Asignar categoría por id
            Category category = categoryRepository.findById(productToCreateDTO.getCategory())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);

            // Asignar features por id's
            List<Feature> features = featureRepository.findAllById(productToCreateDTO.getFeatures());
            product.setFeatures(new HashSet<>(features));

            // Crear política
            PolicyDTO policyDTO = productToCreateDTO.getPolicy();
            if (policyDTO != null) {
                Policy policy = modelMapper.map(policyDTO, Policy.class);
                policyRepository.save(policy);
                product.setPolicy(policy);
            }

            // Crear imágenes
            List<ImageDTO> imagesDTO = productToCreateDTO.getImages();
            if (imagesDTO != null) {
                List<Image> images = new ArrayList<>();
                for (ImageDTO imageDTO : imagesDTO) {
                    Image image = modelMapper.map(imageDTO, Image.class);
                    image.setProduct(product);
                    //No debería guardar las imágnes en el repository?
                    images.add(image);
                }
                product.setImages(images);
            }

            // Crear dirección
            AddressToCreateDTO addressToCreateDTO = productToCreateDTO.getAddress();
            if (addressToCreateDTO != null) {
                Address address = modelMapper.map(addressToCreateDTO, Address.class);

                // Asignar ciudad a la dirección por id
                City city = cityRepository.findById(addressToCreateDTO.getCity())
                        .orElseThrow(() -> new RuntimeException("City not found"));
                address.setCity(city);

                addressRepository.save(address);
                product.setAddress(address);
            }

            createProductService.handle(product);
            log.info("Product created successfully");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
        }
    }

}