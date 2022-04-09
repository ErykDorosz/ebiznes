package com.ebiznes.elektronik.service;

import com.ebiznes.elektronik.dto.AddProductRequest;
import com.ebiznes.elektronik.entity.Product;
import com.ebiznes.elektronik.repository.CategoryRepository;
import com.ebiznes.elektronik.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product addProduct(AddProductRequest addProductRequest) {
        val catgory = categoryRepository.findById(addProductRequest.getCategoryId())
                        .orElseThrow(IllegalArgumentException::new);

        val product = Product.builder()
                .name(addProductRequest.getName())
                .unitPrice(addProductRequest.getUnitPrice())
                .imageFilename("foo")
                .category(catgory)
                .build();
        return productRepository.save(product);
    }
}
