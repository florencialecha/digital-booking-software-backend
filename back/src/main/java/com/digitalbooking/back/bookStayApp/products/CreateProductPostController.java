package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.images.Image;
import com.digitalbooking.back.bookStayApp.images.ImageDTO;
import com.digitalbooking.back.bookStayApp.policies.Policy;
import com.digitalbooking.back.bookStayApp.policies.PolicyDTO;
import com.digitalbooking.back.bookStayApp.policies.PolicyRepository;
import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import com.digitalbooking.back.management.categories.Category;
import com.digitalbooking.back.management.categories.CategoryRepository;
import com.digitalbooking.back.management.features.Feature;
import com.digitalbooking.back.management.features.FeatureRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    @PostMapping
    public void handle(@RequestBody ProductDTO productDTO) {
        try {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Product product = modelMapper.map(productDTO, Product.class);

            //Asignar categoría por id
            Category category = categoryRepository.findById(productDTO.getCategory())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);

            //Asignar features por id's
            List<Feature> features = featureRepository.findAllById(productDTO.getFeatures());
            product.setFeatures(new HashSet<>(features));

            //Crear política
            PolicyDTO policyDTO = productDTO.getPolicy();
            if (policyDTO != null) {
                Policy policy = modelMapper.map(policyDTO, Policy.class);
                policyRepository.save(policy);
                product.setPolicy(policy);
            }

            // Crear imágenes
            List<ImageDTO> imagesDTO = productDTO.getImages();
            if (imagesDTO != null) {
                List<Image> images = new ArrayList<>();
                for (ImageDTO imageDTO : imagesDTO) {
                    Image image = modelMapper.map(imageDTO, Image.class);
                    image.setProduct(product);
                    images.add(image);
                }
                product.setImages(images);
            }

            createProductService.handle(product);
            log.info("Product created successfully");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
        }
    }

}