package com.digitalbooking.back.bookStay.products.controller;

import com.digitalbooking.back.bookStay.address.Address;
import com.digitalbooking.back.bookStay.address.AddressDTO;
import com.digitalbooking.back.bookStay.address.CreateAddressService;
import com.digitalbooking.back.bookStay.address.FindByIdAddressService;
import com.digitalbooking.back.bookStay.products.entity.Product;
import com.digitalbooking.back.bookStay.products.service.CreateProductService;
import com.digitalbooking.back.management.categories.entity.Category;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import com.digitalbooking.back.management.categories.service.FindCategoryByIdService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class CreateProductPostController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CreateProductService createProductService;
    @Autowired
    private CreateAddressService createAddressService;
    @Autowired
    private FindByIdAddressService findByIdAddressService;
    @Autowired
    private FindCategoryByIdService findCategoryByIdService;


    @PostMapping
    public void handle(@RequestBody ProductDTO productDTO) {
        try {
            // Verificar si los datos del producto son válidos y no son nulos
            if (
                    productDTO.getTitle() == null ||
                    productDTO.getTitle().isEmpty() ||
                    productDTO.getDescription() == null ||
                    productDTO.getDescription().isEmpty() ||
                    productDTO.getCategoryId() == null
            ) {
                throw new BadRequestException("Product data is invalid");
            }

            // Crear el objeto Product a partir del DTO
            Product product = modelMapper.map(productDTO, Product.class);

            // Setear el producto con el id de category
            Long categoryId = productDTO.getCategoryId();
            //Conseguir la cotegoría correspondiente
            Category categoryToAssign = findCategoryByIdService.handle(categoryId).orElseThrow(() -> new Exception("Category not found, please try again."));
            product.setCategory(categoryToAssign);

            // Verificar si se proporcionó un DTO de dirección
            if (productDTO.getAddress() != null) {

                // Crear la dirección y asignarla al producto
                AddressDTO addressDTO = productDTO.getAddress();
                Address address = modelMapper.map(addressDTO, Address.class);
                createAddressService.handle(address);

                // Obtener el id de la dirección creada para buscar la dirección
                Long addressId = address.getId();
                log.info("Address Id: " + addressId);

                //Buscar la dirección creada para guardarla setearla en el producto.
                // El método orElseThrow devolverá directamente el objeto Address si está presente o lanzará una excepción si no se encontró la dirección con el id proporcionado.
                Address addressSaved = findByIdAddressService.handle(addressId).orElseThrow(() -> new Exception("Address not found"));

                //Guardar la dirección dentro del objeto producto
                product.setAddress(addressSaved);

            } else {
                // Asignar una dirección nula al producto
                product.setAddress(null);
                log.info("No address provided for the product");
            }

            // Crear el producto
            createProductService.handle(product);
            log.info("Product created successfully");

        } catch (BadRequestException e) {
            log.error("Bad Request Exception: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
        }
    }

}
