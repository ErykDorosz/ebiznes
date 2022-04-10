package com.ebiznes.elektronik.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddCategoryRequest {
    @NotBlank
    private String categoryName;
    @NotBlank
    private String description;
}
