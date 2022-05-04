package com.ebiznes.elektronik.controller;

import com.ebiznes.elektronik.dto.AddProductRequest;
import com.ebiznes.elektronik.dto.ProductPageResponse;
import com.ebiznes.elektronik.entity.Product;
import com.ebiznes.elektronik.repository.ProductRepository;
import com.ebiznes.elektronik.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product")
public class ProductController
{
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.getProduct(0);
    }

    @GetMapping("/pages/{pageNumber}")
    public ProductPageResponse getProductPage(@PathVariable(value = "pageNumber") int pageNumber) {
        return productService.getProductPage(pageNumber);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable(value = "id") long id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()) {
            return ResponseEntity.ok().body(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    @SecurityRequirement(name = "jwt")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Product addProduct(@Valid @RequestBody AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }
}
