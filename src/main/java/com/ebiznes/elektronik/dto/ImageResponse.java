package com.ebiznes.elektronik.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ImageResponse {
    @NotNull
    private final String image;
}
