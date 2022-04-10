package com.ebiznes.elektronik.controller;

import com.ebiznes.elektronik.dto.AddCategoryRequest;
import com.ebiznes.elektronik.entity.Category;
import com.ebiznes.elektronik.repository.CategoryRepository;
import com.ebiznes.elektronik.service.CategorySerivce;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Tag(name = "Category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategorySerivce categoryService;

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("")
    public Category add(AddCategoryRequest addCategoryRequest) {
        return categoryService.add(addCategoryRequest);
    }
}
