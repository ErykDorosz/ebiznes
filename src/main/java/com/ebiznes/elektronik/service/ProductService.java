package com.ebiznes.elektronik.service;

import com.ebiznes.elektronik.dto.AddProductRequest;
import com.ebiznes.elektronik.entity.Product;
import com.ebiznes.elektronik.repository.CategoryRepository;
import com.ebiznes.elektronik.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService
{

    @Value("${app.uploadDir}")
    private String uploadDir;

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getProduct(int page)
    {
        val page1 = productRepository.findAll(
                PageRequest.of(page, 3
                ));

        return page1.getContent();
    }

    public Product addProduct(AddProductRequest addProductRequest)
    {
        val category = categoryRepository.findById(addProductRequest.getCategoryId())
                .orElseThrow(IllegalArgumentException::new);
        val image = saveImage(addProductRequest.getImage());

        val product = Product.builder()
                .name(addProductRequest.getName())
                .unitPrice(addProductRequest.getUnitPrice())
                .imageFilename(image)
                .category(category)
                .build();
        return productRepository.save(product);
    }

    private String saveImage(String imageValue)
    {
        try
        {
            val base64Image = imageValue.split(",")[1];
            val imageBytes = Base64.getDecoder().decode(base64Image);
            val root = Path.of(uploadDir);
            createDirIfNotExists(root);

            val filename = UUID.randomUUID() + ".jpg";
            new FileOutputStream(root.resolve(filename).toString()).write(imageBytes);
            return filename;
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Failed to save image");
        }
    }

    private void createDirIfNotExists(Path path)
    {
        if (!path.toFile().exists())
        {
            path.toFile().mkdirs();
        }
    }
}
