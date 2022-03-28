package com.ebiznes.elektronik.controller;

import com.ebiznes.elektronik.entity.Product;
import com.ebiznes.elektronik.repository.ProductRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product")
public class ProductController
{
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> findAllProducts() {
        return productRepository.findAll();
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
    public Product saveProduct(@Validated @RequestBody Product product) {
        return productRepository.save(product);
    }
}
