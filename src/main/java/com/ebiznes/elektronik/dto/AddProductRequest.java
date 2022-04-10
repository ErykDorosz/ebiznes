package com.ebiznes.elektronik.dto;

import com.ebiznes.elektronik.entity.Category;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AddProductRequest {
    @NotBlank
    private final String name;
    @NotBlank
    private final String image;
    @NotNull
    @Min(0)
    private final BigDecimal unitPrice;
    @NotNull
    private final Long categoryId;
}
