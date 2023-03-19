//package com.digitalbooking.back.bookStayApp.products;
//
//import com.digitalbooking.back.bookStayApp.address.Address;
//import com.digitalbooking.back.bookStayApp.address.AddressDTO;
//import com.digitalbooking.back.bookStayApp.address.CreateAddressService;
//import com.digitalbooking.back.bookStayApp.address.FindByIdAddressService;
//import com.digitalbooking.back.bookStayApp.images.CreateImageService;
//import com.digitalbooking.back.bookStayApp.images.ImageDTO;
//import com.digitalbooking.back.bookStayApp.images.Image;
//import com.digitalbooking.back.management.categories.Category;
//import com.digitalbooking.back.management.categories.exception.BadRequestException;
//import com.digitalbooking.back.management.categories.FindCategoryByIdService;
//import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/product")
//@CrossOrigin("*")
//@Log4j2
//
//public class CreateProductPostController {
//
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private CreateProductService createProductService;
//    @Autowired
//    private CreateAddressService createAddressService;
//    @Autowired
//    private FindByIdAddressService findByIdAddressService;
//    @Autowired
//    private FindCategoryByIdService findCategoryByIdService;
//    @Autowired
//    private CreateImageService createImageService;
//
//    @PostMapping
//    public void handle(@RequestBody ProductDTO productDTO) {
//        try {
//            // VALIDACIONES EXCLUYENTES: Verificar si los datos del producto son válidos y no son nulos
//            if (
//                    productDTO.getTitle() == null || productDTO.getTitle().isEmpty() ||
//                    productDTO.getDescription() == null || productDTO.getDescription().isEmpty() ||
//                    productDTO.getCategoryId() == null ||
//                    productDTO.getImages() == null || productDTO.getImages().isEmpty()
//            ) {
//                throw new BadRequestException("Product data is invalid");
//            }
//
//            //Mapear ProductDTO a Product:
//            Product product = modelMapper.map(productDTO, Product.class);
//            createProductService.handle(product);
//
//            //Asignar CATEGORÍA al producto:
//            Long categoryId = productDTO.getCategoryId();
//            Category categoryToAssign = findCategoryByIdService.
//                    handle(categoryId).
//                    orElseThrow(() -> new Exception("Category not found, please try again."));
//            product.setCategory(categoryToAssign);
//
//            //Crear DIRECCIÓN a partir de AddressDTO
//            AddressDTO addressDTO = productDTO.getAddress();
//            Address address = modelMapper.map(addressDTO, Address.class);
//            createAddressService.handle(address);
//
//            //Obtener el id de la dirección creada para buscar la dirección
//            Long addressId = address.getId();
//            log.info("Address Id: " + addressId);
//
//            // El método orElseThrow devolverá directamente el objeto Address si está presente o lanzará una excepción si no se encontró la dirección con el id proporcionado.
//            Address addressSaved = findByIdAddressService.handle(addressId).orElseThrow(() -> new Exception("Address not found"));
//            product.setAddress(addressSaved);
//
//            // Crear cada IMAGEN y agregarla al producto
//            List<ImageDTO> imagesDTOs = productDTO.getImages();
//            List<Image> images = new ArrayList<>();
//            for (ImageDTO imageDTO : imagesDTOs) {
//                //Crear la imagen y asignarle los datos del DTO de imagen
//                Image image = modelMapper.map(imageDTO, Image.class);
//                //Guardar la imagen
//                image.setProduct(product);
//                createImageService.handle(image);
//                //Agregar la imagen a la lista de imágenes del producto
//                images.add(image);
//                log.info("Images saved with title: " + image.getTitle());
//            }
//            product.setImageList(images);
//
//            log.info("Product created successfully");
//
//        } catch (BadRequestException e) {
//            log.error("Bad Request Exception: {}", e.getMessage());
//        } catch (Exception e) {
//            log.error("Internal Server Error: {}", e.getMessage());
//        }
//    }
//
//}
