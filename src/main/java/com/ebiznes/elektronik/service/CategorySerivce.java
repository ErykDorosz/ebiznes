package com.ebiznes.elektronik.service;

import com.ebiznes.elektronik.dto.AddCategoryRequest;
import com.ebiznes.elektronik.entity.Category;
import com.ebiznes.elektronik.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorySerivce {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category add(AddCategoryRequest addCategoryRequest) {
        return this.categoryRepository.save(Category.builder()
                .categoryName(addCategoryRequest.getCategoryName())
                .description(addCategoryRequest.getDescription())
                .build());
    }
}
