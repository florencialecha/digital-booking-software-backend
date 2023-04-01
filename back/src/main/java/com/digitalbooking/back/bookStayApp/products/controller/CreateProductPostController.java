//package com.digitalbooking.back.bookStayApp.products.controller;
//
//import com.digitalbooking.back.bookStayApp.address.domain.Address;
//import com.digitalbooking.back.bookStayApp.address.dto.AddressToCreateDTO;
//import com.digitalbooking.back.bookStayApp.images.domain.Image;
//import com.digitalbooking.back.bookStayApp.images.dto.ImageDTO;
//import com.digitalbooking.back.bookStayApp.images.domain.ImageRepository;
//import com.digitalbooking.back.bookStayApp.policies.domain.Policy;
//import com.digitalbooking.back.bookStayApp.policies.dto.PolicyDTO;
//import com.digitalbooking.back.bookStayApp.policies.domain.PolicyRepository;
//import com.digitalbooking.back.bookStayApp.products.service.CreateProductService;
//import com.digitalbooking.back.bookStayApp.products.domain.Product;
//import com.digitalbooking.back.management.categories.domain.Category;
//import com.digitalbooking.back.management.categories.domain.CategoryRepository;
//import com.digitalbooking.back.management.features.domain.Feature;
//import com.digitalbooking.back.management.features.domain.FeatureRepository;
//import com.digitalbooking.back.bookStayApp.address.domain.AddressRepository;
//
//import com.digitalbooking.back.management.locations.City;
//import com.digitalbooking.back.management.locations.CityRepository;
//import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/product")
//@CrossOrigin("*")
//@Log4j2
//
//public class CreateProductPostController {
//
//    @Autowired
//    ModelMapper modelMapper = new ModelMapper();
//    @Autowired
//    private CreateProductService createProductService;
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private FeatureRepository featureRepository;
//    @Autowired
//    private PolicyRepository policyRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private ImageRepository imageRepository;
//
//    @Autowired
//    private CityRepository cityRepository;
//
//    @PostMapping
//    public void handle(@RequestBody ProductToCreateDTO productToCreateDTO) {
//        try {
//            Product product = modelMapper.map(productToCreateDTO, Product.class);
//
//            // Asignar categoría por id
//            Category category = categoryRepository.findById(productToCreateDTO.getCategory())
//                    .orElseThrow(() -> new RuntimeException("Category not found"));
//            product.setCategory(category);
//            log.info("Category: " + category);
//
//            // Asignar features por id's
//            List<Feature> features = featureRepository.findAllById(productToCreateDTO.getFeatures());
//            product.setFeatures(new HashSet<>(features));
//            log.info("Features: " + features);
//
//            // Crear política
//            PolicyDTO policyDTO = productToCreateDTO.getPolicy();
//            if (policyDTO != null) {
//                Policy policy = modelMapper.map(policyDTO, Policy.class);
//                policyRepository.save(policy);
//                product.setPolicy(policy);
//            }
//            log.info("Política de cancelación: " + policyDTO.getCancellation());
//
////            // Crear imágenes
////            List<ImageDTO> imagesDTO = productToCreateDTO.getImages();
////            // imagesDTO tiene una lista con título y imageUrl
////            if (imagesDTO != null) {
////                //Guardar imágenes en la base de datos
////                List<Image> imagesList = new ArrayList<>();
////                for (ImageDTO imageDTO : imagesDTO) {
////                    //Image image = modelMapper.map(imageDTO, Image.class);
////                    Image image = new Image();
////                    image.setTitle(imageDTO.getTitle());
////                    image.setImageUrl(imageDTO.getImageUrl());
////                    imagesList.add(image);
////                }
////                product.setImages(imagesList);
////            }
//
//            // Crear dirección
//            AddressToCreateDTO addressToCreateDTO = productToCreateDTO.getAddress();
//            if (addressToCreateDTO != null) {
//                Address address = modelMapper.map(addressToCreateDTO, Address.class);
//
//                // Asignar ciudad a la dirección por id
//                City city = cityRepository.findById(addressToCreateDTO.getCity())
//                        .orElseThrow(() -> new RuntimeException("City not found"));
//                address.setCity(city);
//                addressRepository.save(address);
//                product.setAddress(address);
//            }
//            log.info("Dirección: " + addressToCreateDTO.getStreet());
//            log.info("Product id no debería existir: " + product.getId());
//
//            // Crear producto
//            createProductService.handle(product);
//
//            log.info("Product created successfully");
//
//        } catch (Exception e) {
//            log.error("Internal Server Error: {}", e.getMessage());
//        }
//    }
//
//}